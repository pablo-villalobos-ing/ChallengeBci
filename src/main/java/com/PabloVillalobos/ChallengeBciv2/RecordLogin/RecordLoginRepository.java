package com.PabloVillalobos.ChallengeBciv2.RecordLogin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordLoginRepository extends JpaRepository<RecordLoginEntity, Integer> {
	
	
	List<RecordLoginEntity> findByIdUser(String idUser);
	
	Optional<RecordLoginEntity>   findTopByIdUserOrderByLoginDateDesc(String idUser);

}
