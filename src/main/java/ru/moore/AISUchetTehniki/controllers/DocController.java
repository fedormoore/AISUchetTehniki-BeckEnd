package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.moore.AISUchetTehniki.models.Dto.doc.response.IncomeMainResponseDto;
import ru.moore.AISUchetTehniki.services.DocService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/app/doc")
@RequiredArgsConstructor
public class DocController {

    private final DocService docService;

    @GetMapping("/income_main")
    public List<IncomeMainResponseDto> allIncomeMain(Authentication authentication) {
        return docService.getAllIncomeMain(authentication);
    }

//    @PostMapping("/save_income_main")
//    @ResponseStatus(HttpStatus.CREATED)
//    public IncomeMainDto saveIncomeMain(Authentication authentication, @RequestBody IncomeMain docMain) {
//        return docService.saveIncomeMain(authentication, docMain);
//    }
//
//    @GetMapping("/income_sub/{id}")
//    public List<IncomeSubDto> getIncomeSubById(Authentication authentication, @PathVariable Long id) {
//        return docService.getIncomeSubById(authentication, id);
//    }
//
//    @PostMapping("/save_income_sub")
//    @ResponseStatus(HttpStatus.CREATED)
//    public IncomeSubDto saveIncomeSub(Authentication authentication, @RequestBody IncomeSub docSub) {
//        return docService.saveIncomeSub(authentication, docSub);
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    @GetMapping("/write_off_main")
//    public List<WriteOffMainDto> allWriteOffMain(Authentication authentication) {
//        return docService.getAllWriteOffMain(authentication);
//    }
//
//    @PostMapping("/save_write_off_main")
//    @ResponseStatus(HttpStatus.CREATED)
//    public WriteOffMainDto saveWriteOffMain(Authentication authentication, @RequestBody WriteOffMain docMain) {
//        return docService.saveWriteOffMain(authentication, docMain);
//    }
//
//    @GetMapping("/write_off_sub/{id}")
//    public List<WriteOffSubDto> getWriteOffSubById(Authentication authentication, @PathVariable Long id) {
//        return docService.getWriteOffSubById(authentication, id);
//    }
//
//    @PostMapping("/save_write_off_sub")
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<WriteOffSubDto> saveWriteOffSub(Authentication authentication, @RequestBody WriteOffMain docMain) {
//        return docService.saveWriteOffSub(authentication, docMain);
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    @GetMapping("/recycle_main")
//    public List<RecycleMainDto> allRecycleMain(Authentication authentication) {
//        return docService.getAllRecycleMain(authentication);
//    }
//
//    @PostMapping("/save_recycle_main")
//    @ResponseStatus(HttpStatus.CREATED)
//    public RecycleMainDto saveRecycleMain(Authentication authentication, @RequestBody RecycleMain docMain) {
//        return docService.saveRecycleMain(authentication, docMain);
//    }
//
//    @GetMapping("/recycle_sub/{id}")
//    public List<RecycleMainDto> getRecycleSubById(Authentication authentication, @PathVariable Long id) {
//        return docService.getRecycleSubById(authentication, id);
//    }

}
