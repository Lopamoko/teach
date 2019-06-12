package me.teach.lopamoko.TeachMe.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<UserDataTransferObject> getUserById(@PathVariable Long id) {
        UserDataTransferObject user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @PutMapping()
    private ResponseEntity<UserDataTransferObject> updateUser(@RequestBody UserDataTransferObject userDataTransferObject) {
        UserDataTransferObject updatedUser = userService.updateUser(userDataTransferObject);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity removeUserById(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok().build();
    }

}
