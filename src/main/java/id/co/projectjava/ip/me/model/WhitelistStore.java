package id.co.projectjava.ip.me.model;

import id.co.projectjava.ip.me.model.base.BaseModelAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "mst_whiteliststore")
@Data
public class WhitelistStore extends BaseModelAudit {
    @Column(unique = true, nullable = false)
    private Long storeId;
    private String storeCode;
    private String storeName;
    private boolean active;
    private boolean deleted;
}
