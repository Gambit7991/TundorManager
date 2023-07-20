package org.tundor.manager.services.user_service;

import org.domain.models.userRoles.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tundor.data.DTOs.user_roles.StudentDTO;
import org.tundor.data.data_interacting.repositories.BaseRepository;
import org.tundor.data.data_interacting.repositories.user_repositories.StudentRepository;
import org.tundor.manager.mappers.StudentMapper;
import org.tundor.manager.services.BaseService;

import java.util.UUID;

@Service
public class StudentService implements BaseService<StudentDTO, UUID, Student> {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public BaseRepository<StudentDTO> getRepository() {
        return repository;
    }

    @Override
    public Student toDomainModel(StudentDTO user) {
        return StudentMapper.INSTANCE.toDomain(user);
    }

    @Override
    public StudentDTO toDTO(Student user) {
        return StudentMapper.INSTANCE.toDTO(user);
    }

}
