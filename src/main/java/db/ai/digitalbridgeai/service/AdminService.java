package db.ai.digitalbridgeai.service;

import db.ai.digitalbridgeai.dto.UserDto;
import db.ai.digitalbridgeai.entity.User;
import db.ai.digitalbridgeai.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {
    @Autowired
    private UserRepo userRepo;
    public List<UserDto> getUserList() {
        return userRepo.findAll().stream()
                .map(this::toDtoUser)
                .toList();
    }
    private UserDto toDtoUser(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail()
        );
    }
}
