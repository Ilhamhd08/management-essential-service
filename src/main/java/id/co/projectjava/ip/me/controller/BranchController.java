package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.model.Branch;
import id.co.projectjava.ip.me.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

  /*  @PostMapping("/save")
    public ResponseEntity<ResponseDto<BranchRequestDto>> save(@RequestBody BranchRequestDto branchRequestDto) {
        return buildResponse(ResponseStatusCode.SUCCESS, branchService.updateBranch());
    }*/

    @PutMapping("/{id}")
    public Branch update(@PathVariable Long id, @RequestBody Branch branch){
        return branchService.updateBranch(id, branch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }
}
