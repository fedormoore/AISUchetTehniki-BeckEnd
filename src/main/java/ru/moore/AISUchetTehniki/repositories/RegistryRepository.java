package ru.moore.AISUchetTehniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.Registry;

import java.util.List;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry> findAllByGlobalIdOrderByIdAsc(String globalId);


}
