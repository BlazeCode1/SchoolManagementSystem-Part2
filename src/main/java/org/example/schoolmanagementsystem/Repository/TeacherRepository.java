package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Query("select t from Teacher t where t.id=?1")
    Teacher findTeacherById(Integer id);
}
