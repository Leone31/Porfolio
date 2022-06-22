package it.studiomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.studiomedico.model.Paziente;

public interface PazienteRepository extends JpaRepository<Paziente, Integer> {

}
