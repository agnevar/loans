package codeacademy.agne.loans.repository;

import codeacademy.agne.loans.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByAuthority(String authority);

}
