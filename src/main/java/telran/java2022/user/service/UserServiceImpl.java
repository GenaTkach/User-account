package telran.java2022.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.user.dao.UserRepository;
import telran.java2022.user.dto.CreateDto;
import telran.java2022.user.dto.LoginDto;
import telran.java2022.user.dto.RoleDto;
import telran.java2022.user.dto.UpdateDto;
import telran.java2022.user.model.Role;
import telran.java2022.user.model.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public User register(CreateDto createDto) {
	User user = modelMapper.map(createDto, User.class);
	user.adddefaultRole();
	return userRepository.save(user);
    }

    @Override
    public User login(LoginDto loginDto) {
	return userRepository.findByLogin(loginDto.getLogin());
    }

    @Override
    public User delete(String login) {
	User user = userRepository.findByLogin(login);
	userRepository.delete(user);
	return user;
    }

    @Override
    public User update(String login, UpdateDto updateDto) {
	User user = userRepository.findByLogin(login);
	user.setFirstName(updateDto.getFirstName());
	user.setLastName(updateDto.getLastName());
	userRepository.save(user);
	return user;
    }

    @Override
    public RoleDto addRole(String login, Role role) {
	User user = userRepository.findByLogin(login);
	user.addRole(role);
	userRepository.save(user);
	RoleDto roleDto = new RoleDto();
	roleDto.setLogin(login);
	roleDto.setRoles(user.getRoles());
	return roleDto;
    }

    @Override
    public RoleDto deleteRole(String login, Role role) {
	User user = userRepository.findByLogin(login);
	user.deleteRole(role);
	userRepository.save(user);
	RoleDto roleDto = new RoleDto();
	roleDto.setLogin(login);
	roleDto.setRoles(user.getRoles());
	return roleDto;
    }

    @Override
    public void changePassword(LoginDto loginDto) {
	User user = userRepository.findByLogin(loginDto.getLogin());
	user.setNewPassword(loginDto.getPassword());
	userRepository.save(user);
    }

}
