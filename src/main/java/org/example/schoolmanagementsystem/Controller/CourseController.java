package org.example.schoolmanagementsystem.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.Model.Course;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,@Valid @RequestBody Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }

    @PutMapping("/{teacherId}/assign/{courseId}")
    public ResponseEntity<?> assignTeacherToCourse(@PathVariable Integer teacherId,@PathVariable Integer courseId){
        courseService.assignTeacherToCourse(teacherId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Assigned to course"));
    }

    @GetMapping("/get/teacher/name/{courseId}")
    public ResponseEntity<?> getTeacherNameByCourseId(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(courseId));

    }

    @GetMapping("/students/{courseID}")
    public ResponseEntity<?> getStudentsFromCourse(@PathVariable Integer courseID){
        Set<Student> students= courseService.getStudentsFromCourse(courseID);
        if(students.isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("No Students Enrolled in this Course"));
        return ResponseEntity.status(200).body(students);
    }
}
