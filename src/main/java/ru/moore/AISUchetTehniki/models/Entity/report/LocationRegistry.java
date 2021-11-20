package ru.moore.AISUchetTehniki.models.Entity.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.Registry;
import ru.moore.AISUchetTehniki.models.Entity.spr.LocationParent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spr_location")
public class LocationRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "global_id")
    private String globalId;

    @OneToMany(mappedBy = "location")
    private List<Registry> registries;

}
