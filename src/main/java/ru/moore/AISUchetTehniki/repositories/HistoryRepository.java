package ru.moore.AISUchetTehniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.History;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findAllByRegistryIdAndGlobalId(Long id, String globalId);

    List<History> findAllByRegistryId(Long id);
}
