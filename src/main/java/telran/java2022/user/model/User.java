package telran.java2022.user.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "login")
@Document(collection = "Users")
public class User {
    @Id
    String login;
    @Setter
    @JsonIgnore
    String password;
    @Setter
    String firstName;
    @Setter
    String lastName;
    List<Role> roles = new ArrayList<>();

    public void adddefaultRole() {
	roles.add(Role.USER);
    }

    public void addRole(Role role) {
	if (!roles.contains(role)) {
	    roles.add(role);
	}
    }

    public void deleteRole(Role role) {
	roles.remove(role);
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setNewPassword(String password) {
	this.password = password;
    }

    public User(String login, String password, String firstName, String lastName) {
	this.login = login;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	adddefaultRole();
    }

}
