package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotDeliverableOrderException;
import org.junit.Test;

public class DeliveryOrderServiceImplTest {

    public static final String NOT_EXISTING_PRODUCT = "product-1";

    private DeliveryOrderServiceImpl deliveryOrderService = new DeliveryOrderServiceImpl();

    @Test
    public void shouldDeliverProducts() {
        OrderFulfilmentServiceMock fulfilmentServiceMock = new OrderFulfilmentServiceMock();
        deliveryOrderService.setOrderFulfilmentService(fulfilmentServiceMock);
        deliveryOrderService.setDeliveryService(new TrueDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub(NOT_EXISTING_PRODUCT));
        fulfilmentServiceMock.assertFirstProductName(NOT_EXISTING_PRODUCT);
    }

    @Test (expected = NotDeliverableOrderException.class)
    public void shouldNotDeliverProducts() {
        deliveryOrderService.setDeliveryService(new FalseDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub(NOT_EXISTING_PRODUCT));
    }
}