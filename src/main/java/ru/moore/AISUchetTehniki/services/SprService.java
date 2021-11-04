package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.spr.*;
import ru.moore.AISUchetTehniki.models.Entity.spr.*;
import ru.moore.AISUchetTehniki.repositories.spr.*;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final DeviceTypeRepository deviceTypeRepository;
    private final FirmRepository firmRepository;
    private final ModelRepository modelRepository;
    private final CounterpartyRepository providerRepository;
    private final MapperUtils mapperUtils;

    private Long getOrganizationId(Authentication authentication) {
        return ((UserPrincipal) authentication.getPrincipal()).getOrganization_id();
    }

    private Organization getOrganization(Authentication authentication) {
        return Organization.builder()
                .id(((UserPrincipal) authentication.getPrincipal()).getOrganization_id())
                .build();
    }

    public List<LocationDto> getAllLocation(Authentication authentication) {
        return mapperUtils.mapAll(locationRepository.findAllByTypeAndOrganizationIdOrderByNameDesc("country", getOrganizationId(authentication)), LocationDto.class);
    }

    public List<LocationDto> saveLocation(Authentication authentication, Location location) {
        location.setOrganization(getOrganization(authentication));

        locationRepository.findByTypeAndNameAndOrganizationId(location.getType(), location.getName(), getOrganizationId(authentication)).ifPresent(value -> {
            if (!value.getId().equals(location.getId())) throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
        });

        mapperUtils.map(locationRepository.save(location), LocationDto.class);
        return mapperUtils.mapAll(locationRepository.findAllByTypeAndOrganizationIdOrderByNameDesc("country", getOrganizationId(authentication)), LocationDto.class);
    }

    public List<UserDto> getAllUser(Authentication authentication) {
        return mapperUtils.mapAll(userRepository.findAllByOrganizationId(getOrganizationId(authentication)), UserDto.class);
    }

    public UserDto saveUser(Authentication authentication, User userIn) {
        User user = new User();
        if (userIn.getId() != null) {
            user = userRepository.findById(userIn.getId()).get();
        }

        user.setEmail(userIn.getEmail());
        user.setTelephone(userIn.getTelephone());
        user.setLastName(userIn.getLastName());
        user.setFirstName(userIn.getFirstName());
        user.setMiddleNames(userIn.getMiddleNames());
        user.setLocation(userIn.getLocation());
        user.setOrganization(getOrganization(authentication));

        return mapperUtils.map(userRepository.save(user), UserDto.class);
    }

    public List<DeviceTypeDto> getAllDeviceType(Authentication authentication) {
        return mapperUtils.mapAll(deviceTypeRepository.findAllByLevelOrOrganizationIdOrderByNameAsc("Global", getOrganizationId(authentication)), DeviceTypeDto.class);
    }

    public DeviceTypeDto saveDeviceType(Authentication authentication, DeviceType deviceType) {
        deviceTypeRepository.findByName(deviceType.getName()).ifPresent(value -> {
            if (!value.getId().equals(deviceType.getId())) throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
        });

        deviceType.setOrganization(getOrganization(authentication));

        try {
            return mapperUtils.map(deviceTypeRepository.save(deviceType), DeviceTypeDto.class);
        }catch (DataIntegrityViolationException ex){
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, ex.getRootCause().getMessage());
        }
    }

    public List<FirmDto> getAllFirm(Authentication authentication) {
        return mapperUtils.mapAll(firmRepository.findAllByLevelOrOrganizationIdOrderByNameAsc("Global", getOrganizationId(authentication)), FirmDto.class);
    }

    public FirmDto saveFirm(Authentication authentication, Firm firm) {
        firmRepository.findByName(firm.getName()).ifPresent(value -> {
            if (!value.getId().equals(firm.getId())) throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
        });

        firm.setOrganization(getOrganization(authentication));

        return mapperUtils.map(firmRepository.save(mapperUtils.map(firm, Firm.class)), FirmDto.class);
    }

//    public List<ModelDto> getAllModel(Authentication authentication) {
//        return mapperUtils.mapAll(modelRepository.findByOrderByIdDesc(), ModelDto.class);
//    }

    public List<ModelDto> getModelByFirmId(Authentication authentication, Long id) {
        return mapperUtils.mapAll(modelRepository.findAllByFirmIdAndOrganizationIdOrderByNameDesc(id, getOrganizationId(authentication)), ModelDto.class);
    }

//    public ModelDto getModelById(Long id) {
//        return mapperUtils.map(modelRepository.findById(id).get(), ModelDto.class);
//    }

    public ModelDto saveModel(Authentication authentication, Model model) {
        modelRepository.findByNameAndOrganizationIdAndFirmId(model.getName(), getOrganizationId(authentication), model.getFirm().getId()).ifPresent(value -> {
            if (!value.getId().equals(model.getId())) throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
        });

        if (deviceTypeRepository.findByName(model.getDeviceType().getName()).isEmpty()) {
            DeviceType deviceType = mapperUtils.map(saveDeviceType(authentication, model.getDeviceType()), DeviceType.class);
            model.setDeviceType(deviceType);
        }

        model.setOrganization(getOrganization(authentication));

        try {
            return mapperUtils.map(modelRepository.save(mapperUtils.map(model, Model.class)), ModelDto.class);
        }catch (DataIntegrityViolationException ex){
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, ex.getRootCause().getMessage());
        }
    }

    public List<CounterpartyDto> getAllCounterparty(Authentication authentication) {
        return mapperUtils.mapAll(providerRepository.findAllByOrganizationIdOrderByNameAsc(getOrganizationId(authentication)), CounterpartyDto.class);
    }

    public CounterpartyDto saveCounterparty(Authentication authentication, Counterparty counterparty) {
        providerRepository.findByNameAndOrganizationId(counterparty.getName(), getOrganizationId(authentication)).ifPresent(value -> {
            if (!value.getId().equals(counterparty.getId())) throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
        });

        counterparty.setOrganization(getOrganization(authentication));

        return mapperUtils.map(providerRepository.save(counterparty), CounterpartyDto.class);
    }

}
