package Cars.Showroom.controller;


import Cars.Showroom.model.User;
import Cars.Showroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public User getProfile(Principal principal) {
        return userService.getUserByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/addUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "Added Successfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}