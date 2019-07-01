package me.teach.lopamoko.TeachMe.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class AuthorizationController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    private ResponseEntity<UserDataTransferObject> login(@RequestBody UserDataTransferObject userDataTransferObject) {
        UserDataTransferObject findUser = userService.getUserByLoginAndPassword(userDataTransferObject);
        return ResponseEntity.ok(findUser);
    }

    @PostMapping("/registration")
    private ResponseEntity<UserDataTransferObject> registration(@RequestBody UserDataTransferObject userDataTransferObject) {
        UserDataTransferObject createdUser = userService.createNewUser(userDataTransferObject);
        return ResponseEntity.ok(createdUser);
    }
}
