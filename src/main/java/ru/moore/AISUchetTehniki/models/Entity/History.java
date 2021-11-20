package ru.moore.AISUchetTehniki.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.Registry;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REGISTRY_HISTORY")
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registry_id")
    private Long registryId;

    @Column(name = "type_record")
    private String typeRecord;

    @Column(name = "old_value")
    private Long oldValue;

    @Column(name = "new_value")
    private Long newValue;

    @Column(name = "global_id")
    private String globalId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
