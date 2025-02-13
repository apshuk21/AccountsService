package com.apoorva.accounts.services;

import com.apoorva.accounts.dtos.CustomerDto;
import com.apoorva.accounts.models.Customer;

public interface IAccountsServices {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
