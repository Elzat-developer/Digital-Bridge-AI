package db.ai.digitalbridgeai.controller;

import db.ai.digitalbridgeai.dto.UserDto;
import db.ai.digitalbridgeai.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminPanelController {
    private final AdminService adminService;
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUserList(){
        List<UserDto> users = adminService.getUserList();
        return ResponseEntity.ok(users);
    }
}
