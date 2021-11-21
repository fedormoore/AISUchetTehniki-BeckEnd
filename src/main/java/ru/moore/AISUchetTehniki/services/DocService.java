package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.doc.request.IncomeMainRequestDto;
import ru.moore.AISUchetTehniki.models.Dto.doc.response.IncomeMainResponseDto;
import ru.moore.AISUchetTehniki.models.Entity.History;
import ru.moore.AISUchetTehniki.models.Entity.Registry;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeMain;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeSub;
import ru.moore.AISUchetTehniki.repositories.RegistryRepository;
import ru.moore.AISUchetTehniki.repositories.doc.IncomeMainRepository;
import ru.moore.AISUchetTehniki.repositories.doc.IncomeSubRepository;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DocService {

    private final IncomeMainRepository incomeMainRepository;
    private final IncomeSubRepository incomeSubRepository;
    //    private final IncomeSubRepository incomeSubRepository;
//
//    private final WriteOffMainRepository writeOffMainRepository;
//    private final WriteOffSubRepository writeOffSubRepository;
//
//    private final RecycleMainRepository recycleMainRepository;
//    private final RecycleSubRepository recycleSubRepository;
//
    private final RegistryRepository registryRepository;
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

    @Transactional
    public IncomeMainResponseDto saveIncomeMain(Authentication authentication, IncomeMainRequestDto incomeMainRequestDto) {
        IncomeMain incomeMain = mapperUtils.map(incomeMainRequestDto, IncomeMain.class);
        incomeMain.setGlobalId(getGlobalId(authentication));
        Long incomeMainId = incomeMainRepository.save(incomeMain).getId();

        if (incomeMain.getExecuted()) {
            for (IncomeSub docSub : incomeMain.getDocSubs()) {

                for (int i = 0; i < docSub.getCount(); i++) {
                    Registry registry = mapperUtils.map(docSub, Registry.class);
                    registry.setGlobalId(getGlobalId(authentication));

                    if (docSub.getChildren() != null) {
                        registry.setChildren(insertRegistry(getGlobalId(authentication), docSub.getChildren()));
                    }

                    List<History> historyList = new ArrayList<>();
                    History history = History.builder()
                            .typeRecord("IncomeDoc")
                            .newValue(incomeMainId)
                            .globalId(getGlobalId(authentication))
                            .build();
                    historyList.add(history);

                    registry.setHistories(historyList);

                    registryRepository.save(registry);
                }
            }
        }

        try {
            return mapperUtils.map(incomeMainRepository.findById(incomeMainId).get(), IncomeMainResponseDto.class);
        } catch (DataIntegrityViolationException ex) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage());
        }
    }

    private List<Registry> insertRegistry(String globalId, List<IncomeSub> docSubIn) {
        List<Registry> registryChildrenList = new ArrayList<>();

        for (IncomeSub docSub : docSubIn) {
            for (int i = 0; i < docSub.getCount(); i++) {
                Registry registryTemp = mapperUtils.map(docSub, Registry.class);
                registryTemp.setGlobalId(globalId);
                if (docSub.getChildren() != null) {
                    registryTemp.setChildren(insertRegistry(globalId, docSub.getChildren()));
                }
                registryChildrenList.add(registryTemp);
            }

        }

        return registryChildrenList;
    }

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


}
