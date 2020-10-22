package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static ArrayList<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Hà Duy Hoàng", "haduyhoang@gmail.com", 22));
        customers.add(new Customer(2, "Nguyễn Trung Dũng", "TrungDung@gmail.com", 21));
        customers.add(new Customer(3, "Đào Văn Lâm", "VanLam@gmail.com", 25));
        customers.add(new Customer(4, "Đào Duy Hiển", "duyhien@gmail.com", 20));
    }

    /*
    thêm tài khoản khách hàng
    id tự tăng
    */
    public Customer addCustomers (Customer customer) {
//        id mới của customer
        int iNextId = customers.get(customers.size() - 1).getId() + 1;
        customer.setId(iNextId);
        customers.add(customer);
        return customer;
    }

    /*lấy tất cả tài khoản khách hàng*/
    public ArrayList<Customer> getAllCustomers () {
        return customers;
    }

    /*lấy tài khoản khách hàng bằng id*/
    public Customer getCustomerById (int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }

    /*xóa tài khoản khách hàng bằng id*/
    public boolean deleteCustomerById (int id) {
        // xóa tất cả phần tử có id trùng
        return customers.removeIf(t -> t.getId() == id);
    }

}
