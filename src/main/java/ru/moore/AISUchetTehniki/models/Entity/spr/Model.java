package ru.moore.AISUchetTehniki.models.Entity.spr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.moore.AISUchetTehniki.models.Entity.doc.IncomeSub;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spr_model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
//    @JoinColumn(name = "firm_id")
    private Firm firm;

    @ManyToOne
//    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

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

//    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
//    private List<IncomeSub> incomeSubs;
//
//    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
//    private List<IncomeSubParent> incomeSubParents;
}
