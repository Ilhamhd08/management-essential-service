package id.co.projectjava.ip.me.model;

import id.co.projectjava.ip.me.model.base.BaseModelAudit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "mst_province")
@Data
public class Province extends BaseModelAudit {
    private String code;
    private String name;
    private boolean active = true;
    private boolean deleted = false;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Branch> branches;
}
