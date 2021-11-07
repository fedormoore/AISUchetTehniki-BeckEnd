package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.moore.AISUchetTehniki.models.Dto.report.LocationUserReportDto;
import ru.moore.AISUchetTehniki.services.ReportService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://172.16.3.120:3000", "http://192.168.5.227:3000"})
@RestController
@RequestMapping("/api/v1/app/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/location_user")
    public List<LocationUserReportDto> allAddress(Authentication authentication) {
        return reportService.getAllLocationUser(authentication);
    }

}
