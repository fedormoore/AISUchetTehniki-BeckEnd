package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moore.AISUchetTehniki.models.Entity.spr.DeviceType;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

    List<DeviceType> findByOrderByIdAsc();

    Optional<DeviceType> findByNameOrderByIdAsc(String name);
}
