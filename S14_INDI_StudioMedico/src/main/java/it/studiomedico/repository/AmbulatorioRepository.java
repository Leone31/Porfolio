package it.studiomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.studiomedico.model.Ambulatorio;

public interface AmbulatorioRepository extends JpaRepository<Ambulatorio, String> {

}
