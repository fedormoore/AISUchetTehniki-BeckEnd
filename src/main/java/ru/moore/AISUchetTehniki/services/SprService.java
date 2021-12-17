package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.spr.request.*;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.*;
import ru.moore.AISUchetTehniki.models.Entity.spr.*;
import ru.moore.AISUchetTehniki.repositories.RegistryRepository;
import ru.moore.AISUchetTehniki.repositories.doc.IncomeMainRepository;
import ru.moore.AISUchetTehniki.repositories.doc.IncomeSubRepository;
import ru.moore.AISUchetTehniki.repositories.spr.*;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SprService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final DeviceTypeRepository deviceTypeRepository;
    private final FirmRepository firmRepository;
    private final ModelRepository modelRepository;
    private final CounterpartyRepository providerRepository;
    private final BudgetAccountRepository budgetAccountRepository;
    private final RegistryRepository registryRepository;
    private final IncomeSubRepository incomeSubRepository;
    private final IncomeMainRepository incomeMainRepository;
    private final MapperUtils mapperUtils;

    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    private String getGlobalId(Authentication authentication) {
        if (authentication == null) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет секретного ключа");
        }
        return ((UserPrincipal) authentication.getPrincipal()).getGlobalId();
    }

    public List<LocationResponseDto> getAllLocation(Authentication authentication) {
//        entityManager
//                .unwrap(Session.class)
//                .enableFilter("authorize")
//                .setParameter("globalId", getGlobalId(authentication));
        List<Location> locationList = locationRepository.findAllByTypeOrderByNameDesc("country");
        return mapperUtils.mapAll(locationList, LocationResponseDto.class);
    }

    public List<LocationResponseDto> saveLocation(Authentication authentication, LocationRequestDto locationRequestDto) {
        Location location = mapperUtils.map(locationRequestDto, Location.class);
        location.setGlobalId(getGlobalId(authentication));

        try {
            locationRepository.save(location);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }

        return getAllLocation(authentication);
    }

    @Transactional
    public ResponseEntity<?> deleteLocation(Authentication authentication, LocationDeleteRequestDto locationDeleteRequestDto) {
//        entityManager
//                .unwrap(Session.class)
//                .enableFilter("authorize")
//                .setParameter("globalId", getGlobalId(authentication));
        Location location = locationRepository.findById(locationDeleteRequestDto.getId()).orElseThrow(() -> new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет данных!"));
        location.setGlobalId(getGlobalId(authentication));
        location.setDeleted(true);
        if (location.isDeleted()) {
            if (!userRepository.findAllByLocationId(location.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
            if (!registryRepository.findAllByLocationId(location.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
//            if (!locationRepository.findAllById(location.getId()).get(0).getChildren().isEmpty()) {
//                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Имеется подчиненые записи!");
//            }
        }

        try {
            locationRepository.save(location);
        } catch (Exception | Error e) {
            System.out.println("111111111111111111111 "+e.getCause().getCause().getLocalizedMessage());
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(e).getMessage());
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    public List<UserResponseDto> getAllUser(Authentication authentication) {
        return mapperUtils.mapAll(userRepository.findAllByGlobalIdOrderByLastNameAsc(getGlobalId(authentication)), UserResponseDto.class);
    }

    public UserResponseDto saveUser(Authentication authentication, UserRequestDto userRequestDto) {
        User user = mapperUtils.map(userRequestDto, User.class);
        user.setGlobalId(getGlobalId(authentication));

        if (user.isDeleted()) {
            if (!registryRepository.findAllByUserId(user.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(userRepository.save(user), UserResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

    public List<DeviceTypeResponseDto> getAllDeviceType(Authentication authentication) {
        return mapperUtils.mapAll(deviceTypeRepository.findAllByLevelOrGlobalIdOrderByNameAsc("Global", getGlobalId(authentication)), DeviceTypeResponseDto.class);
    }

    public DeviceTypeResponseDto saveDeviceType(Authentication authentication, DeviceTypeRequestDto deviceTypeRequestDto) {
        DeviceType deviceType = mapperUtils.map(deviceTypeRequestDto, DeviceType.class);
        deviceType.setGlobalId(getGlobalId(authentication));

        if (deviceType.isDeleted()) {
            if (!modelRepository.findAllByDeviceTypeId(deviceType.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(deviceTypeRepository.save(deviceType), DeviceTypeResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

    public List<FirmResponseDto> getAllFirm(Authentication authentication) {
        return mapperUtils.mapAll(firmRepository.findAllByLevelOrGlobalIdOrderByNameAsc("Global", getGlobalId(authentication)), FirmResponseDto.class);
    }

    public FirmResponseDto saveFirm(Authentication authentication, FirmRequestDto firmRequestDto) {
        Firm firm = mapperUtils.map(firmRequestDto, Firm.class);
        firm.setGlobalId(getGlobalId(authentication));

        if (firm.isDeleted()) {
            if (!modelRepository.findAllByFirmId(firm.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(firmRepository.save(mapperUtils.map(firm, Firm.class)), FirmResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

    public List<ModelResponseDto> getAllModel(Authentication authentication) {
        return mapperUtils.mapAll(modelRepository.findAllByGlobalIdOrderByNameDesc(getGlobalId(authentication)), ModelResponseDto.class);
    }

    public List<ModelResponseDto> getModelByFirmId(Authentication authentication, Long id) {
        return mapperUtils.mapAll(modelRepository.findAllByFirmIdAndGlobalIdOrderByNameDesc(id, getGlobalId(authentication)), ModelResponseDto.class);
    }

    public ModelResponseDto saveModel(Authentication authentication, ModelRequestDto modelRequestDto) {
        Model model = mapperUtils.map(modelRequestDto, Model.class);
        model.setGlobalId(getGlobalId(authentication));

        if (model.isDeleted()) {
            if (!incomeSubRepository.findAllByModelId(model.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(modelRepository.save(model), ModelResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, ex.getRootCause().getMessage());
        }
    }

    public List<CounterpartyResponseDto> getAllCounterparty(Authentication authentication) {
        return mapperUtils.mapAll(providerRepository.findAllByGlobalIdOrderByNameAsc(getGlobalId(authentication)), CounterpartyResponseDto.class);
    }

    public CounterpartyResponseDto saveCounterparty(Authentication authentication, CounterpartyRequestDto counterpartyRequestDto) {
        Counterparty counterparty = mapperUtils.map(counterpartyRequestDto, Counterparty.class);
        counterparty.setGlobalId(getGlobalId(authentication));

        if (counterparty.isDeleted()) {
            if (!incomeMainRepository.findAllByCounterpartyId(counterparty.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(providerRepository.save(counterparty), CounterpartyResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

    public List<BudgetAccountResponseDto> getAllBudgetAccount(Authentication authentication) {
        return mapperUtils.mapAll(budgetAccountRepository.findAllByGlobalIdOrderByCodeAsc(getGlobalId(authentication)), BudgetAccountResponseDto.class);
    }

    public BudgetAccountResponseDto saveBudgetAccount(Authentication authentication, BudgetAccountRequestDto budgetAccountRequestDto) {
        BudgetAccount budgetAccountRequest = mapperUtils.map(budgetAccountRequestDto, BudgetAccount.class);
        budgetAccountRequest.setGlobalId(getGlobalId(authentication));

        if (budgetAccountRequest.isDeleted()) {
            if (!registryRepository.findAllByBudgetAccountId(budgetAccountRequest.getId()).isEmpty()) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись используется!");
            }
        }

        try {
            return mapperUtils.map(budgetAccountRepository.save(budgetAccountRequest), BudgetAccountResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Запись уже существует!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

}
