package org.tundor.manager.services;

import org.domain.models.Account;
import org.tundor.data.DTOs.BaseUserDTO;
import org.tundor.data.data_interacting.repositories.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<UserDTO extends BaseUserDTO, ID extends UUID, User extends Account> {
    BaseRepository<UserDTO> getRepository();

    User toDomainModel(UserDTO user);

    UserDTO toDTO(User dto);

    default List<User> findAll() {
        return getRepository().findAll().stream().map(this::toDomainModel).toList();
    }

    default Optional<User> findById(ID id) {
        return getRepository().findById(id).map(this::toDomainModel);
    }

    default Optional<User> save(User user) {
        return Optional.of(toDomainModel(getRepository().save(toDTO(user))));
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    default Optional<User> update(ID id, Account account) {
        Optional<User> retrievedUser = findById(id);
        retrievedUser.ifPresent(el -> {
            el.setInfo(account.getInfo());
            save(el);
        });
        return retrievedUser;
    }


}
