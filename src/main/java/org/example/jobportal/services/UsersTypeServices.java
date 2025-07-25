package org.example.jobportal.services;

import org.example.jobportal.entities.UsersType;
import org.example.jobportal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeServices {
private final UsersTypeRepository usersTypeRepository;

    public UsersTypeServices(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }

}
