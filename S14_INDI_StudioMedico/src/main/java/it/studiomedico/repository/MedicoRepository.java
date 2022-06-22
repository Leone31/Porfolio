package it.studiomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.studiomedico.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	public boolean existsByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("delete from Medico m where m.email =:email")
	public void deleteByEmail(@Param(value = "email") String email); 
	
	
}
