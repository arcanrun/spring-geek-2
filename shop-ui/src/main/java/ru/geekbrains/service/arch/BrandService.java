package ru.geekbrains.service.arch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.Brand;
import ru.geekbrains.repository.arch.BrandMapper;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class BrandService {

    private final BrandMapper brandMapper;
    private Map<Integer, Brand> brandMap;

    @PostConstruct
    public void init(){
        brandMap = new HashMap<>();
    }

    public void addBrand(Brand brand) {
        brandMap.put(brand.getId(), brand);
        brandMapper.insert(brand);
        log.info("inserted!");
    }

    public Brand getBrandById(int id) {
        Brand requestedBrand = brandMap.get(id);
        if (requestedBrand == null) {
            requestedBrand = brandMapper.findById(id);
            brandMap.put(id, requestedBrand);
        }
        return requestedBrand;
    }
}
