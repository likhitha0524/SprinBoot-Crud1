package org.brillio.com.brillio.productorder.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductOrderModel {

    private BigDecimal orderNumber;

    private BigDecimal productNumber;

    private String productDescription;

    private String productCategory;}
