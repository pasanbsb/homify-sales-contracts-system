package com.pasanbsb.com.pasanbsb.hscs.persistence;

import com.pasanbsb.hscs.core.domain.Customer;
import com.pasanbsb.hscs.core.domain.Message;

import java.util.List;

/**
 * Created by Pasan on 5/1/2017.
 */
public interface CustomerDAO {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Customer> findAll();

    /**
     * Find by id customer.
     *
     * @param id the id
     * @return the customer
     */
    Customer findById(int id);

    /**
     * Add message.
     *
     * @param customer the customer
     * @return the message
     */
    Message add(Customer customer);
}