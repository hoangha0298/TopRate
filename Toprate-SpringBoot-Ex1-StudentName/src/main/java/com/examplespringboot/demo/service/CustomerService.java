package com.examplespringboot.demo.service;

import com.examplespringboot.demo.model.Customer;
import com.examplespringboot.demo.model.ResponseCustomer;
import com.examplespringboot.demo.repository.IRepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
@PropertySource(value = "classpath:language/name_en.properties", encoding = "UTF-8")
public class CustomerService {

    @Value("#{${name}}")
    private Map<String, String> nameEnglishs;

    @Autowired
    private IRepositoryCustomer repositoryCustomer;

    public void setDefaultData () {
        System.out.println("====================== default ======================");
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Hà Duy Hoàng", "haduyhoang@gmail.com", 22));
        customers.add(new Customer(2, "Nguyễn Trung Dũng", "TrungDung@gmail.com", 21));
        customers.add(new Customer(3, "Đào Văn Lâm", "VanLam@gmail.com", 25));
        customers.add(new Customer(4, "Đào Duy Hiển", "duyhien@gmail.com", 20));
        customers.add(new Customer(5, "Hoàng Trọng Thắng", "Thanghoang@gmail.com", 22));
        repositoryCustomer.saveAll(customers);
        System.out.println("====================== default ======================\n");
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

    // lấy về key có value như tham số truyền vào
    public String getKey(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // sử dụng hàm so sánh riêng vì trong csdl lư unicode tổ hợp còn trong file name_en lưu kiểu unicode dựng sẵn
            if ( UnikeyTowType.equal(entry.getValue().toLowerCase(), value.toLowerCase() ) ) {
                return entry.getKey();
            }
        }
        return null;
    }

    // lấy về tên cuối cùng ví dụ "hà duy hoàng" lấy về "hoàng"
    public String getLastName(String fullName) {
        fullName = fullName.trim();
        fullName = fullName.replaceAll("\\s+", " ");
        String[] names = fullName.split(" ");
        return names[names.length - 1];
    }

    /*lấy tài khoản khách hàng bằng id*/
    public Customer getCustomerById (int id) {

        try {
            Customer customerBase = repositoryCustomer.findById(id).get();
            // lấy tên english từ file name_en.properties
            String lastName = getLastName(customerBase.getName());
            String nameEN = getKey(nameEnglishs, lastName);
            ResponseCustomer responseCustomer = new ResponseCustomer(customerBase, nameEN);
            System.out.println("===== " + responseCustomer);
            return responseCustomer;
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
