package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.model.WhitelistStore;
import id.co.projectjava.ip.me.repository.WhitelistStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/whitelist")
@RequiredArgsConstructor
public class WhitelistController extends BaseController {
    private final WhitelistStoreRepository repo;

    @GetMapping
    public List<WhitelistStore> listAll() {
        return repo.findByActiveTrueAndDeletedFalse();
    }

    @PostMapping
    public WhitelistStore add(@RequestBody WhitelistStore w) {
        return repo.save(w);
    }

    @PutMapping("/{id}")
    public WhitelistStore update(@PathVariable Long id, @RequestBody WhitelistStore w) {
        WhitelistStore ws = repo.findById(id).orElseThrow();
        ws.setStoreCode(w.getStoreCode());
        ws.setStoreName(w.getStoreName());
        ws.setActive(w.isActive());
        ws.setDeleted(w.isDeleted());
        return repo.save(ws);
    }

    @DeleteMapping("/{id}")
    public void deleted(@PathVariable Long id) {
        WhitelistStore ws = repo.findById(id).orElseThrow();
        ws.setActive(false);
        ws.setDeleted(true);
        repo.save(ws);
    }
}
