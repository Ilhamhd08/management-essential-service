package id.co.projectjava.ip.me.repository;

import id.co.projectjava.ip.me.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByBranchProvinceNameAndActiveTrueAndDeletedFalse(String provinceName);

    List<Store> findByActiveTrueAndDeletedFalse();

 //   List<Store> findByActiveTrueAndDeletedFalse(Long branchId);
}
