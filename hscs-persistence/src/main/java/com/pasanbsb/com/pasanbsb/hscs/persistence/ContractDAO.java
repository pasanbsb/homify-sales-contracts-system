package com.pasanbsb.com.pasanbsb.hscs.persistence;

import com.pasanbsb.hscs.core.domain.Contract;
import com.pasanbsb.hscs.core.domain.Message;

import java.util.List;

/**
 * Created by Pasan on 5/1/2017.
 */
public interface ContractDAO {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Contract> findAll();

    /**
     * Find by id contract.
     *
     * @param id the id
     * @return the contract
     */
    Contract findById(int id);

    /**
     * Add message.
     *
     * @param customer the customer
     * @return the message
     */
    Message add(Contract customer);

    /**
     * Gets revenue for customer.
     *
     * @param id the id
     * @return the revenue for customer
     */
    Message getRevenueForCustomer(int id);

    /**
     * Gets revenue for type.
     *
     * @param type the type
     * @return the revenue for type
     */
    Message getRevenueForType(String type);
}