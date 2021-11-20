package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Dto.HistoryResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.RegistryRequestDto;
import ru.moore.AISUchetTehniki.models.Dto.RegistryResponseDto;
import ru.moore.AISUchetTehniki.models.Entity.History;
import ru.moore.AISUchetTehniki.models.Entity.Registry;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeMain;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;
import ru.moore.AISUchetTehniki.repositories.HistoryRepository;
import ru.moore.AISUchetTehniki.repositories.RegistryRepository;
import ru.moore.AISUchetTehniki.repositories.doc.IncomeMainRepository;
import ru.moore.AISUchetTehniki.repositories.spr.LocationRepository;
import ru.moore.AISUchetTehniki.repositories.spr.UserRepository;
import ru.moore.AISUchetTehniki.security.UserPrincipal;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final IncomeMainRepository incomeMainRepository;
    private final HistoryRepository historyRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    private String getGlobalId(Authentication authentication) {
        if (authentication == null) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Нет секретного ключа");
        }
        return ((UserPrincipal) authentication.getPrincipal()).getGlobalId();
    }

    public List<HistoryResponseDto> getHistoryByRegistryId(Authentication authentication, Long registryId) {
        List<History> histories = historyRepository.findAllByRegistryIdAndGlobalId(registryId, getGlobalId(authentication));

        List<HistoryResponseDto> historyResponseDtoList = new ArrayList<>();
        for (History history : histories) {
            HistoryResponseDto historyResponseDto = new HistoryResponseDto();
            if (history.getTypeRecord().equals("IncomeDoc")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                IncomeMain incomeMain = incomeMainRepository.findById(history.getNewValue()).get();
                historyResponseDto.setText("Поступление. Основание № " + incomeMain.getNumberDoc() + " дата " + dateFormat.format(incomeMain.getDataDoc()));
            }
            if (history.getTypeRecord().equals("invNumber")) {
                if (history.getOldValue() == null) {
                    historyResponseDto.setText("Присвоили инвентарный номер " + history.getNewValue());
                } else {
                    historyResponseDto.setText("Изменили инвентарный номер с " + history.getOldValue() + " на " + history.getNewValue());
                }
            }
            if (history.getTypeRecord().equals("Location")) {
                if (history.getOldValue() == null) {
                    historyResponseDto.setText("Закрепили за кабинетом " + locationRepository.findById(Long.valueOf(history.getNewValue()).longValue()).get().getName());
                } else {
                    historyResponseDto.setText("Изменили инвентарный номер с " + locationRepository.findById(Long.valueOf(history.getOldValue()).longValue()).get().getName() + " на " + locationRepository.findById(Long.valueOf(history.getNewValue()).longValue()).get().getName());
                }
            }
            if (history.getTypeRecord().equals("User")) {
                if (history.getOldValue() == null) {
                    User user = userRepository.findById(Long.valueOf(history.getNewValue()).longValue()).get();
                    historyResponseDto.setText("Закрепили за сотрудником " + user.getLastName() + " " + user.getFirstName() + " " + user.getMiddleNames());
                } else {
                    User userOld = userRepository.findById(Long.valueOf(history.getOldValue()).longValue()).get();
                    User userNew = userRepository.findById(Long.valueOf(history.getNewValue()).longValue()).get();
                    historyResponseDto.setText("Изменили сотрудника с " + userOld.getLastName() + " " + userOld.getFirstName() + " " + userOld.getMiddleNames() + " на " + userNew.getLastName() + " " + userNew.getFirstName() + " " + userNew.getMiddleNames());
                }
            }
            historyResponseDtoList.add(historyResponseDto);
        }

        return historyResponseDtoList;
    }
}
