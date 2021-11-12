package ru.moore.AISUchetTehniki.models.Entity.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;
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
    private Boolean executed;

    @Column(name = "data_executed")
    private Date dataExecuted;

    @Column(name = "number_doc")
    private String numberDoc;

    @Column(name = "data_doc")
    private Date dataDoc;

    @Column(name = "sum_con")
    private String sumCon;

    @Column(name = "number_con")
    private String numberCon;

    @Column(name = "data_con")
    private Date dataCon;

    @ManyToOne
    @JoinColumn(name = "counterparty_id")
    private Counterparty counterparty;

//    @OneToMany(mappedBy = "docMain")
//    private List<IncomeSub> docSubs;

    @Column(name = "global_id")
    private String globalId;

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
