package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.moore.AISUchetTehniki.models.Dto.spr.request.*;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.*;
import ru.moore.AISUchetTehniki.services.SprService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/app/spr")
@RequiredArgsConstructor
public class SprController {

    private final SprService sprService;

    @GetMapping("/location")
    public List<LocationResponseDto> allAddress(Authentication authentication) {
        return sprService.getAllLocation(authentication);
    }

    @PostMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LocationResponseDto> saveAddress(Authentication authentication, @Valid @RequestBody LocationRequestDto location) {
        return sprService.saveLocation(authentication, location);
    }

    @DeleteMapping("/location")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteAddress(Authentication authentication, @RequestBody LocationDeleteRequestDto location) {
        return sprService.deleteLocation(authentication, location);
    }

    @GetMapping("/user")
    public List<UserResponseDto> allUser(Authentication authentication) {
        return sprService.getAllUser(authentication);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto saveUser(Authentication authentication, @Valid @RequestBody UserRequestDto user) {
        return sprService.saveUser(authentication, user);
    }

    @GetMapping("/device_type")
    public List<DeviceTypeResponseDto> allDeviceType(Authentication authentication) {
        return sprService.getAllDeviceType(authentication);
    }

    @PostMapping("/device_type")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceTypeResponseDto saveDeviceType(Authentication authentication, @Valid @RequestBody DeviceTypeRequestDto deviceType) {
        return sprService.saveDeviceType(authentication, deviceType);
    }

    @GetMapping("/firm")
    public List<FirmResponseDto> allFirm(Authentication authentication) {
        return sprService.getAllFirm(authentication);
    }

    @PostMapping("/firm")
    @ResponseStatus(HttpStatus.CREATED)
    public FirmResponseDto saveFirm(Authentication authentication, @Valid @RequestBody FirmRequestDto firm) {
        return sprService.saveFirm(authentication, firm);
    }

    @GetMapping("/model")
    public List<ModelResponseDto> allModel(Authentication authentication) {
        return sprService.getAllModel(authentication);
    }

    @GetMapping("/model/{id}")
    public List<ModelResponseDto> getModelByFirmId(Authentication authentication, @PathVariable Long id) {
        return sprService.getModelByFirmId(authentication, id);
    }

    @PostMapping("/model")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelResponseDto saveModel(Authentication authentication, @RequestBody @Valid ModelRequestDto model) {
        return sprService.saveModel(authentication, model);
    }

    @GetMapping("/counterparty")
    public List<CounterpartyResponseDto> allCounterparty(Authentication authentication) {
        return sprService.getAllCounterparty(authentication);
    }

    @PostMapping("/counterparty")
    @ResponseStatus(HttpStatus.CREATED)
    public CounterpartyResponseDto saveCounterparty(Authentication authentication, @Valid @RequestBody CounterpartyRequestDto counterparty) {
        return sprService.saveCounterparty(authentication, counterparty);
    }

    @GetMapping("/budget_account")
    public List<BudgetAccountResponseDto> getAllBudgetAccount(Authentication authentication) {
        return sprService.getAllBudgetAccount(authentication);
    }

    @PostMapping("/budget_account")
    @ResponseStatus(HttpStatus.CREATED)
    public BudgetAccountResponseDto saveBudgetAccount(Authentication authentication, @Valid @RequestBody BudgetAccountRequestDto budgetAccountRequestDto) {
        return sprService.saveBudgetAccount(authentication, budgetAccountRequestDto);
    }

}
