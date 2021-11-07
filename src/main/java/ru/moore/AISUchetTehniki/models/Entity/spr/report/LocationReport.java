package ru.moore.AISUchetTehniki.models.Entity.spr.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.spr.LocationParent;
import ru.moore.AISUchetTehniki.models.Entity.spr.Organization;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spr_location")
public class LocationReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "location")
    private List<User> user;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

}
