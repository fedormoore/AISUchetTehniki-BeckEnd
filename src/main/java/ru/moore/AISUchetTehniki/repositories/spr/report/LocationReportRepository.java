package ru.moore.AISUchetTehniki.repositories.spr.report;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moore.AISUchetTehniki.models.Entity.spr.report.LocationReport;

import java.util.List;

public interface LocationReportRepository extends JpaRepository<LocationReport, Long> {

//    List<LocationReport> findAllByTypeAndOrganizationIdOrderByNameDesc(String type, Long organizationId);

}
