package com.pasanbsb.hscs.core.domain;

import java.util.List;

/**
 * Created by Pasan on 5/1/2017.
 */
public class Customer {
    private int customerId;
    private String fullName;
    private String email;
    private List<Contract> contractList;

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets contract list.
     *
     * @return the contract list
     */
    public List<Contract> getContractList() {
        return contractList;
    }

    /**
     * Sets contract list.
     *
     * @param contractList the contract list
     */
    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
