package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Location;
import ru.moore.AISUchetTehniki.models.Entity.spr.report.LocationReport;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAllByTypeAndOrganizationIdOrderByNameDesc(String type, Long organizationId);

    Optional<Location> findByTypeAndNameAndOrganizationId(String type, String name, Long organizationId);

}
