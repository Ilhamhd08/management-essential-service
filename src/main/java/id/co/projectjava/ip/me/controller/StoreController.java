package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    // GET /api/store
    @GetMapping
    public List<Map<String,Object>> search(@RequestParam(name="province") String province){
        return storeService.searchStoresByProvinceName(province);
    }
}
