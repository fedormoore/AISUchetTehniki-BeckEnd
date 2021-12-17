package ru.moore.AISUchetTehniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.Registry;

import java.util.Collection;
import java.util.List;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry> findAllByGlobalIdOrderByIdAsc(String globalId);

    List<Registry> findAllByLocationId(Long id);

    List<Registry> findAllByUserId(Long id);

    List<Registry> findAllByBudgetAccountId(Long id);
}
