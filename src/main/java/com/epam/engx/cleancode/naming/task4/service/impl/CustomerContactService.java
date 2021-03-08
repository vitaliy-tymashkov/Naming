package com.epam.engx.cleancode.naming.task4.service.impl;


import com.epam.engx.cleancode.naming.task4.service.ContactService;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactService implements ContactService {

    private CustomerContactDAO customerContactDAO;

    public CustomerContact findCustomerContactDetailsByCustomerId(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    public void updateCustomerContactDetails(CustomerContact customerContactDetails) {
        customerContactDAO.update(customerContactDetails);
    }
}
