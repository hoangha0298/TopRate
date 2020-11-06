package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    public StudentService() {
    }

    public void setDataDefault () {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hà Duy Hoàng", "phú thọ", 22));
        students.add(new Student(2, "Nguyễn Trung Dũng", "nam định", 21));
        students.add(new Student(3, "Đào Văn Lâm", "yên bái", 25));
        students.add(new Student(4, "Đào Duy Hiển", "lâm đồng", 20));
        iStudentRepository.saveAll(students);
    }

    public Student addStudents(Student student) {
        return iStudentRepository.save(student);
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) iStudentRepository.findAll();
    }

    public Student getStudentById(int stdId) {
        // lấy sinh viên đầu tiên trong kết quả trả về
        try {
            return iStudentRepository.findById(stdId).get();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean deleteStudentById(int stdId) {
        // không có id này
        if (getStudentById(stdId) == null) return false;
        iStudentRepository.deleteById(stdId);
        // xóa thành công
        if (getStudentById(stdId) == null) return true;
        // xóa không thành công
        return false;
    }
}
