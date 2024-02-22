package org.brillio.com.brillio.productorder.pact.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.brillio.com.brillio.productorder.domain.model.ProductModel;
import org.brillio.com.brillio.productorder.service.rest.client.ProductServiceClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@ExtendWith(PactConsumerTestExt.class)
public class ProductServicePactConsumerTest {

    private static final String PROVIDER_NAME = "productService";
    private static final String CONSUMER_NAME = "order-service";

    private static Map<String,String> getHeaders(){
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type","application/json");
        return map;
    }

    @Pact(consumer = CONSUMER_NAME, provider = PROVIDER_NAME)
    public RequestResponsePact createPact(PactDslWithProvider builder){
        return builder.uponReceiving("a request to retrieve product information")
                .path("/product-service/product/105")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(getHeaders())
                .body(new PactDslJsonBody()
                        .decimalType("productNumber")
                        .stringType("productDescription")
                        .stringType("productCategory")
                )
                .toPact();
    }

    @Test
    @PactTestFor(providerName = PROVIDER_NAME, pactVersion = PactSpecVersion.V2)
    void runTest(MockServer mockServer){
        ProductServiceClient testInstance = new ProductServiceClient(new RestTemplate(), mockServer.getUrl());
        ProductModel productDetail = testInstance.getProductDetail(new BigDecimal(105));
        assertThat(productDetail,is(notNullValue()));
    }
}
