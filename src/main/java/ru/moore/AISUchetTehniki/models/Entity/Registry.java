package ru.moore.AISUchetTehniki.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.spr.Location;
import ru.moore.AISUchetTehniki.models.Entity.spr.Model;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registry")
@Builder
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Model model;

    @Column(name = "inv_number")
    private String invNumber;

    @ManyToOne
    private Location location;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private List<Registry> children;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "registry_id")
    private List<History> histories;

    @Column(name = "global_id")
    private String globalId;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

}
