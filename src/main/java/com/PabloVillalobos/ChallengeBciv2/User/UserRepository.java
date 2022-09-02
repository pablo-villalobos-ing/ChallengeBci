package com.PabloVillalobos.ChallengeBciv2.User;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
	
	Optional<UserEntity>  findById(String id);
	
	Optional<UserEntity>  findByEmail(String email);

}
