package ru.moore.AISUchetTehniki.models.Entity.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.spr.Counterparty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOC_INCOME_MAIN")
public class IncomeMain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "executed")
    private Boolean executed = false;

    @Column(name = "data_executed")
    private Date dataExecuted;

    @Column(name = "number_doc")
    private String numberDoc;

    @Column(name = "data_doc")
    private Date dataDoc;

    @Column(name = "sum_con")
    private double sumCon;

    @Column(name = "number_con")
    private String numberCon;

    @Column(name = "data_con")
    private Date dataCon;

    @ManyToOne
    private Counterparty counterparty;

    @OrderBy(value = "id desc")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_id")
    private List<IncomeSub> docSubs;

    @Column(name = "global_id")
    private String globalId;

    @Column(name = "created_at", updatable = false)
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
