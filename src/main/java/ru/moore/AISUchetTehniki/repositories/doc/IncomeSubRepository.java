package ru.moore.AISUchetTehniki.repositories.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeSub;

import java.util.List;

public interface IncomeSubRepository extends JpaRepository<IncomeSub, Long> {

//    List<IncomeSub> findAllByDocMainAndParentOrderByIdAsc(Long docMain, Long parent);

}
