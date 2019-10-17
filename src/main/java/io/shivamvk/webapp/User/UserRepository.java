package io.shivamvk.webapp.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	public UserModel findByEmail(String email);
	public UserModel findByPhone(String phone);
}
