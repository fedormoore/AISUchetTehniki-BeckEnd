package ru.moore.AISUchetTehniki.repositories.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeMain;

import java.util.List;

public interface IncomeMainRepository extends JpaRepository<IncomeMain, Long> {

    List<IncomeMain> findAllByGlobalIdOrderByIdAsc(String globalId);

}
