package ru.moore.AISUchetTehniki.models.Entity.doc;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.spr.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOC_INCOME_SUB")
public class IncomeSub implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Basic(optional = false)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "count")
    private int count;

    @Column(name = "sum")
    private double sum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private IncomeSubParent parent;

    @OneToMany(
            mappedBy = "parent",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<IncomeSub> children = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "doc_main_id", nullable = false)
    private IncomeMain docMain;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted")
    private boolean deleted;
}
