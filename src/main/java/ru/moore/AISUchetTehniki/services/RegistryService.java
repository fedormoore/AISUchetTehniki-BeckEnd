package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.RegistryRequestDto;
import ru.moore.AISUchetTehniki.models.Dto.RegistryResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.UserResponseDto;
import ru.moore.AISUchetTehniki.models.Entity.Registry;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;
import ru.moore.AISUchetTehniki.repositories.RegistryRepository;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegistryService {

    private final RegistryRepository registryRepository;
    private final MapperUtils mapperUtils;

    private String getGlobalId(Authentication authentication) {
        if (authentication == null) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет секретного ключа");
        }
        return ((UserPrincipal) authentication.getPrincipal()).getGlobalId();
    }

    public List<RegistryResponseDto> getAll(Authentication authentication) {
        return mapperUtils.mapAll(registryRepository.findAllByGlobalIdOrderByIdAsc(getGlobalId(authentication)), RegistryResponseDto.class);
    }

    public RegistryResponseDto saveRegistry(Authentication authentication, RegistryRequestDto registryRequestDto) {
        Registry registry = mapperUtils.map(registryRequestDto, Registry.class);
        registry.setGlobalId(getGlobalId(authentication));
        registry.setHistories(null);

        try {
            return mapperUtils.map(registryRepository.save(registry), RegistryResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

//    public Object getById(Long code) {
//        return mapperUtils.map(registryRepository.findById(code).get(), RegistryDto.class);
//    }

//    public List<DeviceTypeDto> getAllDeviceType(Authentication authentication) {
//        return mapperUtils.mapAll(deviceTypeRepository.findByOrderByIdAsc(), DeviceTypeDto.class);
//    }
//
//    public DeviceTypeDto saveDeviceType(Authentication authentication, DeviceType deviceType) {
//        deviceTypeRepository.findByNameOrderByIdAsc(deviceType.getName()).ifPresent(value -> {
//            if (value.getId() != deviceType.getId()) throw new RecordExistsException("Ошибка", "Запись уже существует");
//        });
//
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//        deviceType.setUser(user);
//
//        return mapperUtils.map(deviceTypeRepository.save(mapperUtils.map(deviceType, DeviceType.class)), DeviceTypeDto.class);
//    }

}
