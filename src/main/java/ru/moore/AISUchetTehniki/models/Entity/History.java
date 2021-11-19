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
    private Long registry_id;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
