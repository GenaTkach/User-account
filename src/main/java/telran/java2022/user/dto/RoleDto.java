package telran.java2022.user.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import telran.java2022.user.model.Role;

@Getter
@Setter
public class RoleDto {
    String login;
    List<Role> roles;

    public void addRole(Role role) {
	if(roles.contains(role)) {
	    roles.add(role);
	}
    }
}
