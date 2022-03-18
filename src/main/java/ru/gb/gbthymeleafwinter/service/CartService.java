package ru.gb.gbthymeleafwinter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.gbthymeleafwinter.dao.CartDao;
import ru.gb.gbthymeleafwinter.dto.CartProductDto;
import ru.gb.gbthymeleafwinter.entity.Product;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartDao cartDao;

    private final ProductService productService;

    public void save(Long productId) {
        cartDao.addProduct(productId);
    }

    public Set<CartProductDto> findCartProducts() {
        Map<Long, Integer> productIdsMap = cartDao.getProductIdsMap();
        Set<Product> products = productService.findAllByIdIn(productIdsMap.keySet());

        return products.stream().map(product -> {
            CartProductDto cartProductDto = new CartProductDto();
            cartProductDto.setId(product.getId());
            cartProductDto.setTitle(product.getTitle());
            cartProductDto.setCost(product.getCost());
            cartProductDto.setCount(productIdsMap.get(product.getId()));
            return cartProductDto;
        }).collect(Collectors.toUnmodifiableSet());
    }

    public void deleteById(Long id) {
        cartDao.deleteById(id);
    }
}
