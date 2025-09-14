package id.co.projectjava.ip.me.service;

import id.co.projectjava.ip.me.model.Store;
import id.co.projectjava.ip.me.model.WhitelistStore;
import id.co.projectjava.ip.me.repository.StoreRepository;
import id.co.projectjava.ip.me.repository.WhitelistStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final WhitelistStoreRepository whitelistStoreRepository;

    public List<Map<String,Object>> searchStoresByProvinceName(String provinceName) {
        List<Store> stores = storeRepository.findByBranchProvinceNameAndActiveTrueAndDeletedFalse(provinceName);
        List<WhitelistStore> whitelist = whitelistStoreRepository.findByActiveTrueAndDeletedFalse();

        Map<String, Map<String,Object>> result = new LinkedHashMap<>();

        // add province-based stores
        for (Store s : stores) {
            String code = s.getCode() != null ? s.getCode() : "STORE_ID" + s.getId();
            Map<String,Object> m = new HashMap<>();
            m.put("id", s.getId());
            m.put("code", code);
            m.put("name", s.getName());
            m.put("branchId", "branch-store");
            m.put("source", "province");
            result.put(code, m);
        }

        // add whitelist stores (without overriding)
        for (WhitelistStore w : whitelist) {
            String code = w.getStoreCode() != null ? w.getStoreCode() : "WL_" + w.getId();
            result.computeIfAbsent(code, k -> {
                Map<String,Object> m = new HashMap<>();
                m.put("id", w.getStoreId()); // may be null
                m.put("code", code);
                m.put("name", w.getStoreName());
                m.put("branchId", null);
                m.put("source", "whitelist");
                return m;
            });
        }

        return new ArrayList<>(result.values());
    }
}

