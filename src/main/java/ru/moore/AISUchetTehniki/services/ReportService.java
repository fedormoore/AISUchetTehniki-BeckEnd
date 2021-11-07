package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.moore.AISUchetTehniki.models.Dto.report.LocationUserReportDto;
import ru.moore.AISUchetTehniki.repositories.spr.report.LocationReportRepository;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final MapperUtils mapperUtils;

    private final LocationReportRepository locationReportRepository;

    private Long getOrganizationId(Authentication authentication) {
        return ((UserPrincipal) authentication.getPrincipal()).getOrganization_id();
    }

    public List<LocationUserReportDto> getAllLocationUser(Authentication authentication) {
        return mapperUtils.mapAll(locationReportRepository.findAllByTypeAndOrganizationIdOrderByNameDesc("cabinet", getOrganizationId(authentication)), LocationUserReportDto.class);
    }

}
