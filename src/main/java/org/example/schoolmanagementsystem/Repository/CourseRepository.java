package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
}
