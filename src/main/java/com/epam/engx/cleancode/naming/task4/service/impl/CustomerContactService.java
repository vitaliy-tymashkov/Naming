package com.epam.engx.cleancode.naming.task4.service.impl;


import com.epam.engx.cleancode.naming.task4.service.ContactService;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactService implements ContactService {

    private CustomerContactDAO customerContactDAO;

    @Override
    public CustomerContact findByCustomerId(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    @Override
    public void update(CustomerContact customerContact) {
        customerContactDAO.update(customerContact);
    }
}
