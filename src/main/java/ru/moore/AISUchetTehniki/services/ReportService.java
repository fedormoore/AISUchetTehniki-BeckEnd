package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry.LocationRegistryReportDto;
import ru.moore.AISUchetTehniki.repositories.report.LocationRegistryRepository;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final LocationRegistryRepository locationRegistryRepository;
    private final MapperUtils mapperUtils;

    private String getGlobalId(Authentication authentication) {
        if (authentication == null) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет секретного ключа");
        }
        return ((UserPrincipal) authentication.getPrincipal()).getGlobalId();
    }

    public List<LocationRegistryReportDto> getAllLocationRegistry(Authentication authentication) {
        return mapperUtils.mapAll(locationRegistryRepository.findAllByTypeAndGlobalIdOrderByNameDesc("cabinet", getGlobalId(authentication)), LocationRegistryReportDto.class);
    }

//    public List<LocationUserReportDto> getAllLocationUser(Authentication authentication) {
//        return mapperUtils.mapAll(locationReportRepository.findAllByTypeAndOrganizationIdOrderByNameDesc("cabinet", getOrganizationId(authentication)), LocationUserReportDto.class);
//    }

}
