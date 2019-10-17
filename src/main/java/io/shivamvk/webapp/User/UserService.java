package io.shivamvk.webapp.User;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.shivamvk.webapp.Role.RoleModel;
import io.shivamvk.webapp.Role.RoleRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public boolean userWithSameEmailExists(UserModel user) {
		UserModel userWithSameEmail = userRepository.findByEmail(user.getEmail());
		return (userWithSameEmail==null)?false : true;
	}
	
	public boolean userWithSamePhoneExists(UserModel user) {
		UserModel userWithSamePhone = userRepository.findByPhone(user.getPhone());
		return (userWithSamePhone==null)?false : true; 
	}
	
	public boolean registerNewUser(UserModel user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("NOTVERIFIED");
		RoleModel role = roleRepository.findByRoleName("SITE_USER");
		user.setRoles(new HashSet<RoleModel>((Arrays.asList(role))));
		userRepository.save(user);
		return true;
	}
	

}
