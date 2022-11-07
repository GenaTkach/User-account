package telran.java2022.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.user.dto.CreateDto;
import telran.java2022.user.dto.LoginDto;
import telran.java2022.user.dto.RoleDto;
import telran.java2022.user.dto.UpdateDto;
import telran.java2022.user.model.Role;
import telran.java2022.user.model.User;
import telran.java2022.user.service.UserService;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    // Ссылка на интерфейс сервиса
    final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody CreateDto createDto) {
	return userService.register(createDto);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto) {
	return userService.login(loginDto);
    }

    @DeleteMapping("/user/{login}")
    User delete(@PathVariable String login) {
	return userService.delete(login);
    }

    @PutMapping("/user/{login}")
    User update(@PathVariable String login, @RequestBody UpdateDto updateDto) {
	return userService.update(login, updateDto);
    }

    @PutMapping("/user/{login}/role/{role}")
    RoleDto addRole(@PathVariable String login, @PathVariable String role) {
	Role valueRole = Role.valueOf(role.toUpperCase());
	return userService.addRole(login, valueRole);
    }

    @DeleteMapping("/user/{login}/role/{role}")
    RoleDto deleteRole(@PathVariable String login, @PathVariable String role) {
	Role valueRole = Role.valueOf(role.toUpperCase());
	return userService.deleteRole(login, valueRole);
    }

    @PutMapping("/password")
    void changePassword(@RequestBody LoginDto loginDto) {
	userService.changePassword(loginDto);
    }
}
