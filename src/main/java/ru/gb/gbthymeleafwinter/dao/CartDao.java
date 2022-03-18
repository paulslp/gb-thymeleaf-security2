package ru.gb.gbthymeleafwinter.dao;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Setter
@Getter
public class CartDao {

    private Map<Long, Integer> productIdsMap = new HashMap<>();

    @PostConstruct
    void init() {
        productIdsMap = new HashMap<>();
    }

    public void addProduct(Long productId) {
        Integer productCount = productIdsMap.containsKey(productId)
                ? productIdsMap.get(productId) + 1 : 1;
        productIdsMap.put(productId, productCount);
    }

    public void deleteById(Long productId) {
        productIdsMap.remove(productId);
    }
}
