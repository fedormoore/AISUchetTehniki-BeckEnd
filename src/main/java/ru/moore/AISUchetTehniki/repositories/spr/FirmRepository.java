package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Firm;

import java.util.List;

public interface FirmRepository extends JpaRepository<Firm, Long> {

    List<Firm> findAllByLevelOrGlobalIdOrderByNameAsc(String global, String globalId);
}
