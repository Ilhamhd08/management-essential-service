package id.co.projectjava.ip.me.service;

import id.co.projectjava.ip.me.model.Province;
import id.co.projectjava.ip.me.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    //  Get all provinces that are active and not deleted.
    public List<Province> getAllActiveProvinces(){
        return provinceRepository.findAll().stream()
                .filter(p -> p.isActive() && !p.isDeleted())
                .toList();
    }

    // Get a province by ID
    public Province getProvinceById(Long id){
        Province pro = provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found with id: " + id));
        if (!pro.isActive() || pro.isDeleted()) {
            throw new RuntimeException("Province is inactive or deleted");
        }
        return pro;
    }

    // Create a new province
    public Province createProvince(Province province){
        province.setActive(true);
        province.setDeleted(false);
        return provinceRepository.save(province);
    }

    // Update an existing province
    public Province updateProvince(Long id, Province updated) {
        Province province = provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found with id: " + id));
        if(!province.isActive() || province.isDeleted()) {
            throw new RuntimeException("Cannot update inactive or deleted province");
        }

        province.setName(updated.getName());
        return provinceRepository.save(province);
    }

    public void deleteProvince(Long id){
        Province province = provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found with id: " + id));
        province.setDeleted(true);
        province.setActive(false);
        provinceRepository.save(province);
    }

}
