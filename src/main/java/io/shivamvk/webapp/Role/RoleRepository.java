package io.shivamvk.webapp.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer>{
	public RoleModel findByRoleName(String roleName);
}
