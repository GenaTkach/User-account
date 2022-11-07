package telran.java2022.user.service;

import telran.java2022.user.dto.CreateDto;
import telran.java2022.user.dto.LoginDto;
import telran.java2022.user.dto.RoleDto;
import telran.java2022.user.dto.UpdateDto;
import telran.java2022.user.model.Role;
import telran.java2022.user.model.User;

public interface UserService {
    User register(CreateDto createDto);
    
    User login(LoginDto loginDto);
    
    User delete(String login);
    
    User update(String login, UpdateDto updateDto);
    
    RoleDto addRole(String login, Role role);
    
    RoleDto deleteRole(String login, Role role);
    
    void changePassword(LoginDto loginDto);
}
