package com.apoorva.accounts.services;

import com.apoorva.accounts.dtos.CustomerDto;

public interface IAccountsServices {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
