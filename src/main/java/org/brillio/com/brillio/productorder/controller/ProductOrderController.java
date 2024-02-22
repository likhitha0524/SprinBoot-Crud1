package org.brillio.com.brillio.productorder.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.brillio.com.brillio.productorder.domain.entity.ProductOrderEntity;
import org.brillio.com.brillio.productorder.domain.model.ProductOrderModel;
import org.brillio.com.brillio.productorder.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orderDetails")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping(value= "/{orderNumber}")
    public ProductOrderModel getOrderDetails(@PathVariable BigDecimal orderNumber)
    {
        return productOrderService.getProductOrderDetails(orderNumber);
    }


    @PostMapping
    public void insertProductDetails(@RequestBody ProductOrderModel productOrderModel) {
        productOrderService.insertOrderDetails(productOrderModel);
    }
//
//    @PutMapping("/{orderNumber}")
//    public ProductOrderModel updateProductDetails(@PathVariable BigDecimal orderNumber,
//                                             @RequestBody ProductOrderModel productOrderModel) {
//        return buildOrderModel(productOrderService.updateOrderDetails(orderNumber, productOrderModel));
//    }
    @DeleteMapping("/{orderNumber}")
    public void deleteProductDetails(@PathVariable BigDecimal orderNumber) {
        productOrderService.deleteProductDetails(orderNumber);
    }

}
