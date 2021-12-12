package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.moore.AISUchetTehniki.models.Dto.HistoryResponseDto;
import ru.moore.AISUchetTehniki.services.HistoryService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/app/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping()
    public List<HistoryResponseDto> getHistoryByRegistryId(Authentication authentication, @RequestBody Long registryId) {
        return historyService.getHistoryByRegistryId(authentication, registryId);
    }

}
