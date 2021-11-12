package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.doc.response.IncomeMainResponseDto;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;
import ru.moore.AISUchetTehniki.models.Entity.doc.*;
import ru.moore.AISUchetTehniki.models.Entity.spr.Model;
import ru.moore.AISUchetTehniki.repositories.doc.*;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocService {

    private final IncomeMainRepository incomeMainRepository;
//    private final IncomeSubRepository incomeSubRepository;
//
//    private final WriteOffMainRepository writeOffMainRepository;
//    private final WriteOffSubRepository writeOffSubRepository;
//
//    private final RecycleMainRepository recycleMainRepository;
//    private final RecycleSubRepository recycleSubRepository;
//
//    private final RegistryRepository registryRepository;
//    private final HistoryRepository historyRepository;
    private final MapperUtils mapperUtils;

    private String getGlobalId(Authentication authentication) {
        if (authentication == null) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет секретного ключа");
        }
        return ((UserPrincipal) authentication.getPrincipal()).getGlobalId();
    }

    public List<IncomeMainResponseDto> getAllIncomeMain(Authentication authentication) {
        return mapperUtils.mapAll(incomeMainRepository.findAllByGlobalIdOrderByIdAsc(getGlobalId(authentication)), IncomeMainResponseDto.class);
    }

//    @Transactional
//    public IncomeMainDto saveIncomeMain(Authentication authentication, IncomeMain docMain) {
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//        docMain.setUser(user);
//
//        if (docMain.getExecuted()) {
//            List<IncomeSubDto> docSubDtoList = mapperUtils.mapAll(incomeSubRepository.findAllByDocMainIdAndDocSub(docMain.getId(), null), IncomeSubDto.class);
//            for (IncomeSubDto docSub : docSubDtoList) {
//                for (int i = 0; i < docSub.getCount(); i++) {
//                    Registry registry = insertRegistry(null, docSub, user);
//                    registryRepository.save(registry);
//                }
//            }
//        }
//
//        return mapperUtils.map(incomeMainRepository.save(docMain), IncomeMainDto.class);
//    }
//
//    public List<IncomeSubDto> getIncomeSubById(Authentication authentication, Long id) {
//        return mapperUtils.mapAll(incomeSubRepository.findAllByDocMainIdAndDocSub(id, null), IncomeSubDto.class);
//    }
//
//    public IncomeSubDto saveIncomeSub(Authentication authentication, IncomeSub docSub) {
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//        docSub.setUser(user);
//
//        return mapperUtils.map(incomeSubRepository.save(mapperUtils.map(docSub, IncomeSub.class)), IncomeSubDto.class);
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    public List<WriteOffMainDto> getAllWriteOffMain(Authentication authentication) {
//        return mapperUtils.mapAll(writeOffMainRepository.findAllByUserIdOrderByIdAsc(((UserPrincipal) authentication.getPrincipal()).getId()), WriteOffMainDto.class);
//    }
//
//    public WriteOffMainDto saveWriteOffMain(Authentication authentication, WriteOffMain docMain) {
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//        docMain.setUser(user);
//
////        if (docMain.getExecuted()) {
////            List<IncomeSubDto> docSubDtoList = mapperUtils.mapAll(incomeSubRepository.findAllByDocMainIdAndDocSub(docMain.getId(), null), IncomeSubDto.class);
////            for (IncomeSubDto docSub : docSubDtoList) {
////                for (int i = 0; i < docSub.getCount(); i++) {
////                    Registry registry = insertRegistry(null, docSub, user);
////                    registryRepository.save(registry);
////                }
////            }
////        }
//
//        return mapperUtils.map(writeOffMainRepository.save(docMain), WriteOffMainDto.class);
//    }
//
//    public List<WriteOffSubDto> getWriteOffSubById(Authentication authentication, Long id) {
//        return mapperUtils.mapAll(writeOffSubRepository.findAllByDocMainId(id), WriteOffSubDto.class);
//    }
//
//    @Transactional
//    public List<WriteOffSubDto> saveWriteOffSub(Authentication authentication, WriteOffMain docMain) {
//
//
//        writeOffSubRepository.deleteByDocMainId(docMain.getId());
//
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//
//        for (WriteOffSub docSub:docMain.getDocSubs()) {
//            docSub.setUser(user);
//        }
//
//        return mapperUtils.mapAll(writeOffSubRepository.saveAll(docMain.getDocSubs()), WriteOffSubDto.class);
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    public List<RecycleMainDto> getAllRecycleMain(Authentication authentication) {
//        return mapperUtils.mapAll(recycleMainRepository.findAllByUserIdOrderByIdAsc(((UserPrincipal) authentication.getPrincipal()).getId()), RecycleMainDto.class);
//    }
//
//    public RecycleMainDto saveRecycleMain(Authentication authentication, RecycleMain docMain) {
//        User user = User.builder()
//                .id(((UserPrincipal) authentication.getPrincipal()).getId())
//                .build();
//        docMain.setUser(user);
//
////        if (docMain.getExecuted()) {
////            List<IncomeSubDto> docSubDtoList = mapperUtils.mapAll(incomeSubRepository.findAllByDocMainIdAndDocSub(docMain.getId(), null), IncomeSubDto.class);
////            for (IncomeSubDto docSub : docSubDtoList) {
////                for (int i = 0; i < docSub.getCount(); i++) {
////                    Registry registry = insertRegistry(null, docSub, user);
////                    registryRepository.save(registry);
////                }
////            }
////        }
//
//        return mapperUtils.map(recycleMainRepository.save(docMain), RecycleMainDto.class);
//    }
//
//    public List<RecycleMainDto> getRecycleSubById(Authentication authentication, Long id) {
//        return mapperUtils.mapAll(recycleSubRepository.findAllByDocMainId(id), RecycleMainDto.class);
//    }
//
//    private Registry insertRegistry(Registry registryIn, IncomeSubDto docSub, User user) {
//        List<Registry> registryList = new ArrayList<>();
//
//        Registry registry = Registry.builder()
//                .model(mapperUtils.map(docSub.getModel(), Model.class))
//                .user(user)
//                .registry(registryIn)
//                .build();
//
//        History history = History.builder()
//                .user(user)
//                .text("Поступление. Основание № "+docSub.getDocMain().getNumberDoc()+" дата "+docSub.getDocMain().getDataDoc())
//                .registry(registry)
//                .build();
//        historyRepository.save(history);
//
//        if (docSub.getDocSubs().size() > 0) {
//            for (IncomeSubDto docSubL : docSub.getDocSubs()) {
//                for (int i = 0; i < docSubL.getCount(); i++) {
//                    registryList.add(insertRegistry(registry, docSubL, user));
//                }
//            }
//            registry.setRegisters(registryList);
//        }
//
//        return registry;
//    }

}
