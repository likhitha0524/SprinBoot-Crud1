package org.brillio.com.brillio.productorder.service.rest.client;

import org.brillio.com.brillio.productorder.domain.model.ProductModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ProductServiceClient {

    private RestTemplate restTemplate;

    private String productServiceBaseUrl;

    private static final String PRODUCT_INFORMATION_URL = "/product/{ProductNumber}";

    public ProductServiceClient(RestTemplate restTemplate,
                                @Value("${product.service.base.uri}") String productServiceBaseUrl) {
        this.restTemplate = restTemplate;
        this.productServiceBaseUrl = productServiceBaseUrl + "/product-service";
    }

    public ProductModel getProductDetail(BigDecimal productNumber) {
        ProductModel productModel = restTemplate.getForObject(getProductInformationUrl(),
                ProductModel.class, productNumber);
        return productModel;
    }

    private String getProductInformationUrl(){
        return productServiceBaseUrl + PRODUCT_INFORMATION_URL;
    }
}
