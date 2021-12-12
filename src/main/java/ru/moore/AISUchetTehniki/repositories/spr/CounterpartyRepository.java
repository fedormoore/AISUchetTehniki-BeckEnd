package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Counterparty;

import java.util.List;

public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {

    List<Counterparty> findAllByGlobalIdOrderByNameAsc(String globalId);

}
