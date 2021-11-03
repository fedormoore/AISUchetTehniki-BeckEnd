package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Counterparty;

import java.util.List;
import java.util.Optional;

public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {

    List<Counterparty> findAllByOrderByIdAsc();

    Optional<Counterparty> findByNameOrderByIdAsc(String name);
}
