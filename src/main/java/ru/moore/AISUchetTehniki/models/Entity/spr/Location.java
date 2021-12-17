package ru.moore.AISUchetTehniki.models.Entity.spr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spr_location")
//@FilterDef(name = "authorize", parameters = {@ParamDef(name = "globalId", type = "string")})
//@Filters({
//        @Filter(name = "authorize", condition = "global_id = :globalId and deleted = false")
//})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent")
    private LocationParent parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @OrderBy(value = "name asc")
//    //фильтр по целевой таблице сущностей
//    @Filter(name="betweenLength", condition=":minLength <= length and :maxLength >= length")
//    //фильтр по таблице ассоциаций
//    @FilterJoinTable(name="authorize", condition = "global_id = :globalId and deleted = false")
//    @Filters({
//            @Filter(name = "authorize", condition = "global_id = :globalId and deleted = false")
//    })
    private List<Location> children;

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
    private boolean deleted = Boolean.FALSE;

}
