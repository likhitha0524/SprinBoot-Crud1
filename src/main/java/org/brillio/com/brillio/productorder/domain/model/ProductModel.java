package org.brillio.com.brillio.productorder.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {

    private BigDecimal productNumber;
    private String productDescription;
    private String productCategory;
}
