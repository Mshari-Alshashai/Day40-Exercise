package com.example.day39exercise.Service;

import com.example.day39exercise.Api.ApiException;
import com.example.day39exercise.Model.Teacher;
import com.example.day39exercise.Repository.AddressRepository;
import com.example.day39exercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        if (teacherRepository.findTeacherById(id) == null) throw new ApiException("teacher not found");

        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        oldTeacher.setName(teacher.getName());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setAddress(teacher.getAddress());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        if (teacherRepository.findTeacherById(id) == null) throw new ApiException("teacher not found");

        teacherRepository.findTeacherById(id).setAddress(null);

        if (addressRepository.findAddressById(id) != null) {
            addressRepository.delete(addressRepository.findAddressById(id));
        }

        teacherRepository.delete(teacherRepository.findTeacherById(id));

    }

    public Teacher getTeacherById(Integer id) {
        if (teacherRepository.findTeacherById(id) == null) throw new ApiException("teacher not found");
        return teacherRepository.findTeacherById(id);
    }
}
