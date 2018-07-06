package com.david.SL.AutoScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("CustomerServiceA")
@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public String toString() {
        return "CustomerService [customerDAO=" + customerDAO + "]";
    }
}
