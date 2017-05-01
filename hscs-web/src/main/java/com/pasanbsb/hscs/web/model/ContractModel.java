package com.pasanbsb.hscs.web.model;

import com.pasanbsb.com.pasanbsb.hscs.persistence.ContractDAO;
import com.pasanbsb.hscs.core.domain.Contract;
import impl.ContractDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Pasan on 5/1/2017.
 * ContractModel is responsible for handling contract related requests. This intercepts /customerservice/contract path requests
 */
@Path("contract")
public class ContractModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractModel.class);

    /**
     * Create contract response.
     *
     * @param contract the contract
     * @return the response
     */
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createContract(Contract contract) {
        LOGGER.info("Add contract request received id={}", contract.getId());
        ContractDAO contractDAO = new ContractDAOImpl();
        return Response.status(201).entity(contractDAO.add(contract)).build();
    }

    /**
     * Gets revenue by customer.
     *
     * @param id the id
     * @return the revenue by customer
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRevenueByCustomer(@PathParam("id") int id) {
        LOGGER.info("get revenue for customer request received id={}", id);

        ContractDAO contractDAO = new ContractDAOImpl();
        return Response.status(201).entity(contractDAO.getRevenueForCustomer(id)).build();
    }

    /**
     * Gets revenues by type.
     *
     * @param type the type
     * @return the revenues by type
     */
    @GET
    @Path("{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRevenuesByType(@PathParam("type") String type) {
        LOGGER.info("get revenue for type request received type={}", type);

        ContractDAO contractDAO = new ContractDAOImpl();
        return Response.status(201).entity(contractDAO.getRevenueForType(type)).build();
    }
}
