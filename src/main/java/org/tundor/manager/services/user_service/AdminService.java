package org.tundor.manager.services.user_service;

import org.domain.models.userRoles.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tundor.data.DTOs.user_roles.AdminDTO;
import org.tundor.data.data_interacting.repositories.BaseRepository;
import org.tundor.data.data_interacting.repositories.user_repositories.AdminRepository;
import org.tundor.manager.mappers.AdminMapper;
import org.tundor.manager.services.BaseService;

import java.util.UUID;

@Service
public class AdminService implements BaseService<AdminDTO, UUID, Admin> {
    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseRepository<AdminDTO> getRepository() {
        return repository;
    }

    @Override
    public Admin toDomainModel(AdminDTO user) {
        return AdminMapper.INSTANCE.toDomain(user);
    }

    @Override
    public AdminDTO toDTO(Admin user) {
        return AdminMapper.INSTANCE.toDTO(user);
    }

}
