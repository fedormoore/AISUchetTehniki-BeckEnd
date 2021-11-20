package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry.LocationRegistryReportDto;
import ru.moore.AISUchetTehniki.services.ReportService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/app/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
//
//    @GetMapping("/location_user")
//    public List<LocationUserReportDto> allAddress(Authentication authentication) {
//        return reportService.getAllLocationUser(authentication);
//    }

    @GetMapping("/location_registry")
    public List<LocationRegistryReportDto> getAllLocationRegistry(Authentication authentication) {
        return reportService.getAllLocationRegistry(authentication);
    }

}
