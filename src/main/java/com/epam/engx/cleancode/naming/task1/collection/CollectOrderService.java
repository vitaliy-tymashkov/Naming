package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.OrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class CollectOrderService implements OrderService {

    private CollectionService ser1;
    private NotificationManager ser2;

    public void submitOrder(Order order) {
        if (ser1.isEligibleForCollection(order))
            ser2.notifyCustomer(Message.READY_FOR_COLLECT, 4); // 4 - info notification level
        else
            ser2.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, 1); // 1 - critical notification level
    }

    public void setSer1(CollectionService ser1) {
        this.ser1 = ser1;
    }

    public void setSer2(NotificationManager ser2) {
        this.ser2 = ser2;
    }
}
