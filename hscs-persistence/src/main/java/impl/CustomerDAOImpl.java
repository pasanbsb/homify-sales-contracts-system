package impl;

import com.pasanbsb.com.pasanbsb.hscs.persistence.CustomerDAO;
import com.pasanbsb.hscs.core.domain.Contract;
import com.pasanbsb.hscs.core.domain.Customer;
import com.pasanbsb.hscs.core.domain.Message;

import java.util.List;

import static com.pasanbsb.com.pasanbsb.hscs.persistence.data.CustomerServiceInMemory.getPersistenceService;

/**
 * Created by Pasan on 5/1/2017.
 * ContractDAOImpl is responsible for retrieving and storing customer data from memory
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) getPersistenceService().getCustomers().values();
    }

    @Override
    public Customer findById(int id) {
        List<Contract> contracts = getPersistenceService().getCustomerContracts().get(id);
        Customer customer = getPersistenceService().getCustomers().get(id);
        if (contracts != null) {
            customer.setContractList(contracts);
        }
        return customer;
    }

    @Override
    public Message add(Customer customer) {
        if (getPersistenceService().getCustomers().get(customer.getCustomerId()) == null) {
            getPersistenceService().addCustomer(customer);
            Message message = new Message();
            message.setMessage("Customer id=" + customer.getCustomerId() + " added successfully");
            return message;
        } else {
            Message message = new Message();
            message.setMessage("Customer already exists for id=" + customer.getCustomerId());
            return message;
        }
    }
}
