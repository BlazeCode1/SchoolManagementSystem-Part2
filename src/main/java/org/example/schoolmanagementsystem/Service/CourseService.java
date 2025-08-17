package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;

import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.DTO.CourseDTOout;
import org.example.schoolmanagementsystem.Model.Course;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.CourseRepository;
import org.example.schoolmanagementsystem.Repository.StudentRepository;
import org.example.schoolmanagementsystem.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }


    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course){
        Course oldCourse = courseRepository.findCourseById(id);

        if(oldCourse == null)
            throw new ApiException("Course Not Found");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }


    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null)
            throw new ApiException("Course not found");

        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer teacherId, Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if(course ==null || teacher == null)
            throw new ApiException("Teacher or Course Not found");

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public CourseDTOout getTeacherNameByCourseId(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if(course == null)
            throw new ApiException("Course not found");
        Teacher teacher = course.getTeacher();

        return new CourseDTOout(teacher.getName());

    }

    public Set<Student> getStudentsFromCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if(course == null)
            throw new ApiException("Course not found");

        return course.getStudents();
    }








}
