package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Submitable;

public class CollectionOrderServiceTestHelper {

    public CustomerNotificationService getService(){
        return new CustomerNotificationService();
    }

    public void submit(Submitable collectOrderService) {
        ((CustomerNotificationService) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock,
                                       Submitable collectOrderService) {
        ((CustomerNotificationService) collectOrderService)
                .setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submitable collectOrderService,
                                     CollectionService collectionServiceStub) {
        ((CustomerNotificationService) collectOrderService)
                .setCollectionService(collectionServiceStub);
    }
}
