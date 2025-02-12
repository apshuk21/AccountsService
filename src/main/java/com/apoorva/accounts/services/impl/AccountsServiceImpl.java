package com.apoorva.accounts.services.impl;

import com.apoorva.accounts.constants.AccountsConstants;
import com.apoorva.accounts.dtos.CustomerDto;
import com.apoorva.accounts.exceptions.CustomerAlreadyExistException;
import com.apoorva.accounts.mappers.CustomerMapper;
import com.apoorva.accounts.models.Accounts;
import com.apoorva.accounts.models.Customer;
import com.apoorva.accounts.repositories.AccountsRepository;
import com.apoorva.accounts.repositories.CustomerRepository;
import com.apoorva.accounts.services.IAccountsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

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
        Customer customerExists = customerRepository.findByMobileNumber(customerDto.getMobileNumber()).orElse(null);

        if (customerExists != null) {
            throw new CustomerAlreadyExistException("Customer with mobile number " + customerDto.getMobileNumber() + " already exist");
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);

        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
