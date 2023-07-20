package org.tundor.manager.services.user_service;

import org.domain.models.userRoles.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tundor.data.DTOs.user_roles.TutorDTO;
import org.tundor.data.data_interacting.repositories.BaseRepository;
import org.tundor.data.data_interacting.repositories.user_repositories.TutorRepository;
import org.tundor.manager.mappers.TutorMapper;
import org.tundor.manager.services.BaseService;

import java.util.UUID;

@Service
public class TutorService implements BaseService<TutorDTO, UUID, Tutor> {

    private final TutorRepository repository;

    @Autowired
    public TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<TutorDTO> getRepository() {
        return repository;
    }

    @Override
    public Tutor toDomainModel(TutorDTO user) {
        return TutorMapper.INSTANCE.toDomain(user);
    }

    @Override
    public TutorDTO toDTO(Tutor user) {
        return TutorMapper.INSTANCE.toDTO(user);
    }
}
