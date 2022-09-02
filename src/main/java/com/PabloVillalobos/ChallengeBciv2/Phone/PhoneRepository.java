package com.PabloVillalobos.ChallengeBciv2.Phone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long>{
	
	List<PhoneEntity> findByIdUser(String idUser);

}
