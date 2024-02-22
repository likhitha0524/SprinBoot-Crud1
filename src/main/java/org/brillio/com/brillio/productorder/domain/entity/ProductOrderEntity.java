package org.brillio.com.brillio.productorder.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class ProductOrderEntity {

    @Id
    @Column(name="ordernumber")
    private BigDecimal orderNumber;

    @Column(name="pnumber")
    private BigDecimal productNumber;

}

