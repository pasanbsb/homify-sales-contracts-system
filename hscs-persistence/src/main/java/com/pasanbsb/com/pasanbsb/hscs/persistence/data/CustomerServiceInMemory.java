package com.pasanbsb.com.pasanbsb.hscs.persistence.data;

import com.pasanbsb.hscs.core.domain.Contract;
import com.pasanbsb.hscs.core.domain.Customer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Pasan on 5/1/2017.
 * CustomerServiceInMemory is responsible for storing Customer and Contract data in memory
 */
public class CustomerServiceInMemory {
    // Singleton model
    private static final CustomerServiceInMemory PERSISTENCE_SERVICE = new CustomerServiceInMemory();

    // Map to store customers against ids
    private Map<Integer, Customer> customers;

    // Map to store contracts against ids
    private Map<Integer, Contract> contracts;

    // Map to store contracts for customers
    private Map<Integer, List<Contract>> customerContracts;

    /**
     * Instantiates a new Customer service in memory.
     */
    public CustomerServiceInMemory() {
        customers = new Hashtable<>();
        contracts = new Hashtable<>();
        customerContracts = new Hashtable<>();
    }

    /**
     * Add customer.
     *
     * @param customer the customer
     */
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    /**
     * Add contract.
     *
     * @param contract the contract
     */
    public void addContract(Contract contract){
        contracts.put(contract.getId(), contract);
        List<Contract> contractList = customerContracts.get(contract.getCustomerId());
        if (contractList != null) {
            contractList.add(contract);
            customerContracts.put(contract.getCustomerId(), contractList);
        } else {
            contractList = new ArrayList<>();
            contractList.add(contract);
            customerContracts.put(contract.getCustomerId(), contractList);
        }
    }

    /**
     * Gets customers.
     *
     * @return the customers
     */
    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    /**
     * Gets contracts.
     *
     * @return the contracts
     */
    public Map<Integer, Contract> getContracts() {
        return contracts;
    }

    /**
     * Gets customer contracts.
     *
     * @return the customer contracts
     */
    public Map<Integer, List<Contract>> getCustomerContracts() {
        return customerContracts;
    }

    /**
     * Gets persistence service.
     *
     * @return the persistence service
     */
    public static CustomerServiceInMemory getPersistenceService() {
        return PERSISTENCE_SERVICE;
    }
}
