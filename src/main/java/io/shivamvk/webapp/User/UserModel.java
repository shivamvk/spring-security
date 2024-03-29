package io.shivamvk.webapp.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.util.*;

import io.shivamvk.webapp.Role.*;

@Entity
@Table(name="user")
public class UserModel {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="This field is mandatory")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="This field is mandatory")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="This field is mandatory")
	@Email(message="Enter a valid email")
	@Column(name="email")
	private String email;
	
	@NotNull(message="This field is mandatory")
	@Length(min = 10, max = 10, message="Enter a valid mobile number")
	@Column(name="phone")
	private String phone;
	
	@NotNull(message="This field is mandatory")
	@Length(min=6, message="Password should be atleast 6 characters")
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
	
}
