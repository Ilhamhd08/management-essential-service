package id.co.projectjava.ip.me.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.projectjava.ip.me.model.base.BaseModelAudit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "mst_branch")
@Data
public class Branch extends BaseModelAudit {
    @Column(unique = true)
    private String code;
    private String name;
    private boolean active;
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Store> stores;
}
