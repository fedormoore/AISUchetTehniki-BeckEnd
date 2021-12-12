package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByFirmIdAndGlobalIdOrderByNameDesc(Long firmId, String globalId);

    List<Model> findAllByGlobalIdOrderByNameDesc(String globalId);
}
