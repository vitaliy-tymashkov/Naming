package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Submitable;

public class CollectionOrderServiceTestHelper {

    public CollectionOrderServiceImpl getService(){
        return new CollectionOrderServiceImpl();
    }

    public void submit(Submitable collectOrderService) {
        ((CollectionOrderServiceImpl) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock, Submitable collectOrderService) {
        ((CollectionOrderServiceImpl) collectOrderService).setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submitable collectOrderService, CollectionService collectionServiceStub) {
        ((CollectionOrderServiceImpl) collectOrderService).setCollectionService(collectionServiceStub);
    }
}
