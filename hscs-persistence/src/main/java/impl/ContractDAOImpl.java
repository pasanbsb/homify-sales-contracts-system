package impl;

import com.pasanbsb.com.pasanbsb.hscs.persistence.ContractDAO;
import com.pasanbsb.com.pasanbsb.hscs.persistence.CustomerDAO;
import com.pasanbsb.hscs.core.domain.Contract;
import com.pasanbsb.hscs.core.domain.Message;

import java.util.List;

import static com.pasanbsb.com.pasanbsb.hscs.persistence.data.CustomerServiceInMemory.getPersistenceService;

/**
 * Created by Pasan on 5/1/2017.
 * ContractDAOImpl is responsible for retrieving and storing contract data from memory
 */
public class ContractDAOImpl implements ContractDAO {
    @Override
    public List<Contract> findAll() {
        return (List<Contract>) getPersistenceService().getContracts().values();
    }

    @Override
    public Contract findById(int id) {
        return getPersistenceService().getContracts().get(id);
    }

    @Override
    public Message add(Contract contract) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        if (customerDAO.findById(contract.getCustomerId()) == null) {
            Message message = new Message();
            message.setMessage("Customer does not exist id=" + contract.getCustomerId());
            return message;
        } else {
            getPersistenceService().addContract(contract);
            Message message = new Message();
            message.setMessage("Contract id=" + contract.getId() + " added successfully");
            return message;
        }
    }

    @Override
    public Message getRevenueForCustomer(int id) {
        List<Contract> contracts = getPersistenceService().getCustomerContracts().get(id);
        if (contracts != null) {
            Message message = new Message();
            Double revenue = contracts.stream().mapToDouble(value -> value.getRevenue()).sum();
            message.setRevenue(String.valueOf(revenue));
            return message;
        } else {
            Message message = new Message();
            message.setMessage("Contracts not found for Customer id=" + id);
            return message;
        }
    }

    @Override
    public Message getRevenueForType(String type) {
        List<Contract> contracts = (List<Contract>) getPersistenceService().getContracts().values();
        Message message = new Message();
        Double revenue = contracts.stream()
                .filter(contract -> type.equals(contract.getType()))
                .mapToDouble(value -> value.getRevenue()).sum();
        message.setRevenue(String.valueOf(revenue));
        return message;
    }
}
