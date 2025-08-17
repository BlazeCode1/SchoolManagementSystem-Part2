package org.example.schoolmanagementsystem.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Updated"));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student Deleted"));
    }


    @PutMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<?> enrollStudentToCourse(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.enrollStudentToCourse(studentId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Student Enrolled To Course"));
    }

    @PutMapping("/change/major/{studentId}/{major}")
    public ResponseEntity<?> changeStudentMajor(@PathVariable Integer studentId,@PathVariable String major){
        studentService.changeStudentMajor(studentId,major);
        return ResponseEntity.status(200).body(new ApiResponse("Student Major Changed"));
    }

}
