package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByType(String country);

    List<Location> findAllByLocationId(Long id);
}
