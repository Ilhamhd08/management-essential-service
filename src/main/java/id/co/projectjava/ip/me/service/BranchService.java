package id.co.projectjava.ip.me.service;

import id.co.projectjava.ip.me.model.Branch;
import id.co.projectjava.ip.me.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public Branch updateBranch(Long id, Branch updated) {
        Branch b = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        if(b.isDeleted() || !b.isActive()) {
            throw  new RuntimeException("Cannot update deleted or inactive branch");
        }
        b.setName(updated.getName());
        b.setCode(updated.getCode());
        // updated other
        return branchRepository.save(b);
    }

    // soft delete
/*    public Map<String, Object> delete(String code) {
        Branch branch = branchRepository.findByCode(code);
        branchRepository.delete(branch);
        Map<String, Object> hMap = new HashMap<>();

        return  hMap;
    }*/


    public void deleteBranch(Long id) {
        Branch br = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        br.setDeleted(true);
        br.setActive(false);
        branchRepository.save(br);
    }
}
