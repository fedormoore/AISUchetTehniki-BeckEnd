package ru.moore.AISUchetTehniki.repositories.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moore.AISUchetTehniki.models.Entity.spr.DeviceType;

import java.util.List;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

//    Optional<DeviceType> findByName(String name);

    List<DeviceType> findAllByLevelOrGlobalIdOrderByNameAsc(String global, String globalId);
}
