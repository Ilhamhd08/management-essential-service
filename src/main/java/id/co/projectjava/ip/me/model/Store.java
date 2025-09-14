package id.co.projectjava.ip.me.model;


import id.co.projectjava.ip.me.model.base.BaseModelAudit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "mst_store")
@Data
public class Store extends BaseModelAudit {
    @Column(unique = true)
    private String code;
    private String name;
    private boolean active;
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
