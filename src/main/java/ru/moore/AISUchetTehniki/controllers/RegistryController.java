package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.moore.AISUchetTehniki.models.Dto.RegistryRequestDto;
import ru.moore.AISUchetTehniki.models.Dto.RegistryResponseDto;
import ru.moore.AISUchetTehniki.services.RegistryService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/app/registry")
@RequiredArgsConstructor
public class RegistryController {

    private final RegistryService registryService;

    @GetMapping()
    public List<RegistryResponseDto> allRegistry(Authentication authentication) {
        return registryService.getAll(authentication);
    }

    @PostMapping()
    public RegistryResponseDto saveRegistry(Authentication authentication, @RequestBody RegistryRequestDto registryRequestDto) {
        return registryService.saveRegistry(authentication, registryRequestDto);
    }

//
//    @PostMapping("/save_device_type")
//    @ResponseStatus(HttpStatus.CREATED)
//    public DeviceTypeDto saveDeviceType(Authentication authentication, @RequestBody DeviceType deviceType) {
//        return sprService.saveDeviceType(authentication, deviceType);
//    }

}
