package ru.moore.AISUchetTehniki.repositories.report;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.report.LocationRegistry;
import ru.moore.AISUchetTehniki.models.Entity.spr.Location;

import java.util.List;

public interface LocationRegistryRepository extends JpaRepository<LocationRegistry, Long> {

    List<LocationRegistry> findAllByTypeAndGlobalIdOrderByNameDesc(String type, String globalId);

}
