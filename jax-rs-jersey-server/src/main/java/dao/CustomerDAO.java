package dao;

import dto.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private List<Customer> list;

    public CustomerDAO() {
        list = new ArrayList<Customer>();
    }

    public void add(Customer customer){
        list.add(customer);
    }

    public Customer get(int id){
        return list.get(id);
    }

    public List<Customer> search(String name, int limit) {
        List<Customer> result = new ArrayList<Customer>();
        for(Customer customer : list){
            if(customer.getName().contains(name)){
                result.add(customer);
            }
            if(result.size() == limit){
                return result;
            }
        }
        return result;
    }
}
