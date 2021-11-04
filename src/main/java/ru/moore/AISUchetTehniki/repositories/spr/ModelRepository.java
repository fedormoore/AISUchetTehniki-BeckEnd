package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByFirmId(Long id);

    Optional<Model> findByNameAndOrganizationIdAndFirmId(String name, Long organizationId, Long firmId);

    List<Model> findByOrderByIdDesc();

    List<Model> findAllByFirmIdAndOrganizationIdOrderByNameDesc(Long id, Long organizationId);
}
