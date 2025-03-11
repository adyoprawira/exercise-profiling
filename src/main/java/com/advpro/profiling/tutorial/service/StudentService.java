package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            return new ArrayList<>(); // Return empty list for empty student list.
        }

        List<Long> studentIds = students.stream()
                .map(Student::getId)
                .collect(Collectors.toList());

        List<StudentCourse> allStudentCourses = studentCourseRepository.findByStudentIdIn(studentIds);

        Map<Long, Student> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, student -> student));

        return allStudentCourses.stream()
                .map(sc -> {
                    StudentCourse result = new StudentCourse();
                    result.setStudent(studentMap.get(sc.getStudent().getId()));
                    result.setCourse(sc.getCourse());
                    return result;
                })
                .collect(Collectors.toList());
    }

    public Optional<Student> findStudentWithHighestGpa() {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            return Optional.empty(); // Handle empty list case
        }

        return students.stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            return ""; // Handle empty list case
        }

        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }
}

