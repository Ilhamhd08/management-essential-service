package id.co.projectjava.ip.me.repository;

import id.co.projectjava.ip.me.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByIdAndActiveTrueAndDeletedFalse(Long id);

    List<Branch> findByProvinceIdAndActiveTrueAndDeletedFalse(Long provinceId);

   /* @Query("SELECT b FROM Branch b WHERE b.province.id = :provinceId AND b.active = true AND b.deleted = false")
    List<Branch> findActiveNonDeletedByProvinceId(@Param("provinceId") Long provinceId);*/




}
