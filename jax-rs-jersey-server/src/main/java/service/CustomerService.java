package service;

import com.sun.jersey.spi.resource.Singleton;
import dao.CustomerDAO;
import dto.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/customer")
public class CustomerService {

    private CustomerDAO dao;

    public CustomerService() {
        dao = new CustomerDAO();
        dao.add(new Customer(1, "Ireneusz", "ireneusz.kawalec@gmail.com"));
        dao.add(new Customer(2, "Jan", "jan.kowalski@gmail.com"));
        dao.add(new Customer(3, "Jan", "jann@yahoo.com"));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer get(@PathParam("id") int id){
        return dao.get(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void add(Customer customer){
        dao.add(customer);
    }

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> search(@QueryParam("name") String name, @DefaultValue("5") @QueryParam("limit") int limit){
        return dao.search(name, limit);
    }

}
