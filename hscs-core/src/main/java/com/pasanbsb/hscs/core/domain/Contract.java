package com.pasanbsb.hscs.core.domain;

/**
 * Created by Pasan on 5/1/2017.
 */
public class Contract {
    private int id;
    private int customerId;
    private String startDate;
    private String type;
    private Double revenue;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets revenue.
     *
     * @return the revenue
     */
    public Double getRevenue() {
        return revenue;
    }

    /**
     * Sets revenue.
     *
     * @param revenue the revenue
     */
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

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
     * Gets start date.
     *
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
