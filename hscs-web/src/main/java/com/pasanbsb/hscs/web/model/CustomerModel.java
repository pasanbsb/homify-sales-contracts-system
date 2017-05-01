package com.pasanbsb.hscs.web.model;

import com.pasanbsb.com.pasanbsb.hscs.persistence.CustomerDAO;
import com.pasanbsb.hscs.core.domain.Customer;
import impl.CustomerDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Pasan on 5/1/2017.
 * CustomerModel is responsible for handling customer related requests. This intercepts /customerservice/customer path requests
 */
@Path("customer")
public class CustomerModel {
    /**
     * Create customer response.
     *
     * @param customer the customer
     * @return the response
     */
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return Response.status(201).entity(customerDAO.add(customer)).build();
    }

    /**
     * Gets customer.
     *
     * @param id the id
     * @return the customer
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") int id) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return Response.status(201).entity(customerDAO.findById(id)).build();
    }
}
