package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Firm;

import java.util.List;
import java.util.Optional;

public interface FirmRepository extends JpaRepository<Firm, Long> {

    Optional<Firm> findByName(String name);

    List<Firm> findAllByLevelOrOrganizationIdOrderByNameAsc(String global, Long organizationId);
}
