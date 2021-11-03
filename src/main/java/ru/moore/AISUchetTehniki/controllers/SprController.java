package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.moore.AISUchetTehniki.models.Dto.spr.*;
import ru.moore.AISUchetTehniki.models.Entity.spr.*;
import ru.moore.AISUchetTehniki.services.SprService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://172.16.3.120:3000"})
@RestController
@RequestMapping("/api/v1/app/spr")
@RequiredArgsConstructor
public class SprController {

    private final SprService sprService;

    @GetMapping("/location")
    public List<LocationDto> allAddress(Authentication authentication) {
        return sprService.getAllLocation(authentication);
    }

    @PostMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LocationDto> saveAddress(Authentication authentication, @RequestBody Location location) {
        return sprService.saveLocation(authentication, location);
    }

    @GetMapping("/user")
    public List<UserDto> allUser(Authentication authentication) {
        return sprService.getAllUser(authentication);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(Authentication authentication, @RequestBody User user) {
        return sprService.saveUser(authentication, user);
    }

    @GetMapping("/device_type")
    public List<DeviceTypeDto> allDeviceType(Authentication authentication) {
        return sprService.getAllDeviceType(authentication);
    }

    @PostMapping("/device_type")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceTypeDto saveDeviceType(Authentication authentication, @RequestBody DeviceType deviceType) {
        return sprService.saveDeviceType(authentication, deviceType);
    }

    @GetMapping("/firm")
    public List<FirmDto> allFirm(Authentication authentication) {
        return sprService.getAllFirm(authentication);
    }

    @PostMapping("/firm")
    @ResponseStatus(HttpStatus.CREATED)
    public FirmDto saveFirm(Authentication authentication, @RequestBody Firm firm) {
        return sprService.saveFirm(authentication, firm);
    }

//    @GetMapping("/model")
//    public List<ModelDto> gallModel(Authentication authentication) {
//        return sprService.getAllModel(authentication);
//    }

    @GetMapping("/model/{id}")
    public List<ModelDto> getModelByFirmId(Authentication authentication, @PathVariable Long id) {
        return sprService.getModelByFirmId(authentication, id);
    }

    @PostMapping("/model")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelDto saveModel(Authentication authentication, @RequestBody Model model) {
        return sprService.saveModel(authentication, model);
    }

    @GetMapping("/counterparty")
    public List<CounterpartyDto> allCounterparty(Authentication authentication) {
        return sprService.getAllCounterparty(authentication);
    }

    @PostMapping("/counterparty")
    @ResponseStatus(HttpStatus.CREATED)
    public CounterpartyDto saveCounterparty(Authentication authentication, @RequestBody Counterparty counterparty) {
        return sprService.saveCounterparty(authentication, counterparty);
    }

}
