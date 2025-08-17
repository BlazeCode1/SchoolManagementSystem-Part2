package org.example.schoolmanagementsystem.Service;


import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.Model.Course;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Repository.CourseRepository;
import org.example.schoolmanagementsystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student){
        Student oldStudent = studentRepository.findStudentById(id);
        if(oldStudent == null)
            throw new ApiException("Student not found");

        oldStudent.setName(student.getName());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setAge(student.getAge());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id)
    {
        Student student = studentRepository.findStudentById(id);
        if(student == null)
            throw new ApiException("Student Not Found");

        studentRepository.delete(student);
    }

    public void enrollStudentToCourse(Integer studentId, Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if(course == null)
            throw new ApiException("Course not found");
        Student student = studentRepository.findStudentById(studentId);
        if(student == null)
            throw new ApiException("Student not found");

        course.getStudents().add(student);
        student.getCourse().add(course);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    public void changeStudentMajor(Integer studentId, String major){
        Student student = studentRepository.findStudentById(studentId);
        if(student == null)
            throw new ApiException("Student not found");
        student.setCourse(null);
        student.setMajor(major);
        studentRepository.save(student);
    }

}
