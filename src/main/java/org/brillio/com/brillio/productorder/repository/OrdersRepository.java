package org.brillio.com.brillio.productorder.repository;


import org.brillio.com.brillio.productorder.domain.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;


@Repository
public interface OrdersRepository extends JpaRepository<ProductOrderEntity, BigDecimal>, JpaSpecificationExecutor<ProductOrderEntity>
{
    ProductOrderEntity findByOrderNumber(BigDecimal orderNumber);
}
