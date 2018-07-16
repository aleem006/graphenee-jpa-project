package jpa.graphenee.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpa.graphenee.project.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
 