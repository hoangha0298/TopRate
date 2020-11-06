package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Model.Customer;
import com.examplespringboot.demo.Repository.IRepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class CustomerService {

    @Autowired
    private IRepositoryCustomer repositoryCustomer;

    public void setDefaultData () {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Hà Duy Hoàng", "haduyhoang@gmail.com", 22));
        customers.add(new Customer(2, "Nguyễn Trung Dũng", "TrungDung@gmail.com", 21));
        customers.add(new Customer(3, "Đào Văn Lâm", "VanLam@gmail.com", 25));
        customers.add(new Customer(4, "Đào Duy Hiển", "duyhien@gmail.com", 20));
        customers.add(new Customer(5, "Hoàng Trọng Thắng", "Thanghoang@gmail.com", 22));
        repositoryCustomer.saveAll(customers);
    }

    /*
    thêm tài khoản khách hàng
    id tự tăng
    */
    public Customer addCustomers (Customer customer) {
//        nếu đã có thì update, chưa có thì thêm
        return repositoryCustomer.save(customer);
    }

    /*lấy tất cả tài khoản khách hàng*/
    public ArrayList<Customer> getAllCustomers () {
        ArrayList<Customer> arr = new ArrayList<>();
        // copy toàn bộ interable vào arraylist
        repositoryCustomer.findAll().forEach(arr::add);
        return arr;
    }

    /*lấy tài khoản khách hàng bằng id*/
    public Customer getCustomerById (int id) {

        try {
            return repositoryCustomer.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    /*xóa tài khoản khách hàng bằng id*/
    public boolean deleteCustomerById (int id) {
        // nếu phần tử không tồn tại nhẩy vào exception
        try {
            repositoryCustomer.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        // kiểm tra phần tử xóa chưa
        if (getCustomerById(id) == null)
            return true;
        return false;
    }

}
