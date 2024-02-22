package org.brillio.com.brillio.productorder.service;

import org.brillio.com.brillio.productorder.domain.entity.ProductOrderEntity;
import org.brillio.com.brillio.productorder.domain.model.ProductModel;
import org.brillio.com.brillio.productorder.domain.model.ProductOrderModel;
import org.brillio.com.brillio.productorder.repository.OrdersRepository;
import org.brillio.com.brillio.productorder.service.rest.client.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductOrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductServiceClient productServiceClient;

    public ProductOrderModel getProductOrderDetails(BigDecimal orderNumber)
    {
        ProductOrderEntity orderEntity= ordersRepository.findByOrderNumber(orderNumber);
        if (orderEntity == null){
            throw new RuntimeException("No order details found for order number:" + orderNumber);
        }
        ProductModel productModel = productServiceClient.getProductDetail(orderEntity.getProductNumber());
        return buildProductOrderModel(orderNumber,productModel);
    }

    private ProductOrderModel buildProductOrderModel(BigDecimal orderNumber, ProductModel productModel){
        return ProductOrderModel.builder()
                .orderNumber(orderNumber)
                .productNumber(productModel.getProductNumber())
                .productDescription(productModel.getProductDescription())
                .productCategory(productModel.getProductCategory())
                .build();
    }

    public void insertOrderDetails(ProductOrderModel productOrderModel){
        ProductOrderEntity ordersEntity = ProductOrderEntity.builder()
                .orderNumber(productOrderModel.getOrderNumber())
                .productNumber(productOrderModel.getProductNumber())
                .build();

        ordersRepository.save(ordersEntity);
    }

    public ProductOrderEntity updateOrderDetails(BigDecimal orderNumber,ProductOrderModel productOrderModel){
        ProductOrderEntity orderEntity = ordersRepository.findByOrderNumber(orderNumber);
        if (orderEntity == null){
            throw new RuntimeException("No order details found for order number:" + orderNumber);
        }
        orderEntity.setOrderNumber(productOrderModel.getOrderNumber());
        orderEntity.setProductNumber(productOrderModel.getProductNumber());

        return ordersRepository.save(orderEntity);
    }

    public void deleteProductDetails(BigDecimal orderNumber)
    {
        ProductOrderEntity orderEntity = ordersRepository.findByOrderNumber(orderNumber);
        if (orderEntity == null){
            throw new RuntimeException("No order details found for order number:" + orderNumber +"to delete");
        }
        ordersRepository.deleteById(orderNumber);

    }

}
