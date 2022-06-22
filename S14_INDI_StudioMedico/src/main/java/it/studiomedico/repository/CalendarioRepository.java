package it.studiomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.studiomedico.model.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {

}
