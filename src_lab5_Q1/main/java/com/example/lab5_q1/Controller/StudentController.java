package com.example.lab5_q1.Controller;

import com.example.lab5_q1.ApiResponse.ApiResponse;
import com.example.lab5_q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();
    @GetMapping("/get")
    public java.util.ArrayList<Student> getStudents() {
        return students;
    }
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("task updated","200");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("task updated","200");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("task deleted","200");
    }
    @GetMapping("/update/{index}")
    public ApiResponse Status(@PathVariable int index) {
        if (students.get(index).getStatus().equals("graduated")){
            return new ApiResponse("Student is graduated","true");
        }
        return new ApiResponse("Student is not graduated","false");
    }
}
