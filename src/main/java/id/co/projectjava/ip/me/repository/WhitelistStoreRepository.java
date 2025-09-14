package id.co.projectjava.ip.me.repository;

import id.co.projectjava.ip.me.model.WhitelistStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhitelistStoreRepository extends JpaRepository<WhitelistStore, Long> {
    List<WhitelistStore> findByActiveTrueAndDeletedFalse();
}
