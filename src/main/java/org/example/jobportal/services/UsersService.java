package org.example.jobportal.services;

import org.example.jobportal.entities.Users;
import org.example.jobportal.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addNewUser(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(users);
    }
    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
