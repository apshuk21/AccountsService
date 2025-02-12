package com.apoorva.accounts.services.impl;

import com.apoorva.accounts.dtos.CustomerDto;
import com.apoorva.accounts.repositories.AccountsRepository;
import com.apoorva.accounts.repositories.CustomerRepository;
import com.apoorva.accounts.services.IAccountsServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsServices {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
