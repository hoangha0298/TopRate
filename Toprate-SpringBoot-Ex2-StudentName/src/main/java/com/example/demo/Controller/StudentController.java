package com.example.demo.Controller;

import com.example.demo.Model.ResponseDelete;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;     // singleton service sinh viên

    @PostMapping("student/create")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudents(student);
    }

    @GetMapping("students/list")
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> temp = studentService.getAllStudents();
        if (temp.size() == 0) {
            studentService.setDataDefault();
            temp = studentService.getAllStudents();
        }
        return temp;
    }

    @GetMapping("student/{stdId}")
    public Student getStudentById(@PathVariable int stdId) {
        return studentService.getStudentById(stdId);
    }

    @GetMapping("student/delete/{stdId}")
    public ResponseDelete deleteStudentById(@PathVariable int stdId) {
        ResponseDelete responseDelete = new ResponseDelete();
        responseDelete.setSucess(studentService.deleteStudentById(stdId));
        return responseDelete;
    }

}
