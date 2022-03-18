package ru.gb.gbthymeleafwinter.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal cost;

    private Integer count;

    @Override
    public String toString() {
        return "CartProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }
}
