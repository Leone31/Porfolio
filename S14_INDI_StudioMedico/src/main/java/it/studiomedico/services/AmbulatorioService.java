package it.studiomedico.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import it.studiomedico.dto.AmbulatorioDTO;
import it.studiomedico.model.Ambulatorio;
import it.studiomedico.model.Paziente;
import it.studiomedico.repository.AmbulatorioRepository;

@Service
public class AmbulatorioService {

	@Autowired AmbulatorioRepository ar;
	
	public void inserisci(AmbulatorioDTO request) throws EntityExistsException {
		if(ar.existsById(request.getNomeAmbulatorio())) {
			throw new EntityExistsException("Nome Ambulatorio gia esistente");
		}
		Ambulatorio a = new Ambulatorio();
		a.setNomeAmbulatorio(request.getNomeAmbulatorio());
		ar.save(a);
	}
	
	public void modifica(AmbulatorioDTO request) throws NotFoundException {
		if(!ar.existsById(request.getNomeAmbulatorio())) {
			throw new NotFoundException("Nome Ambulatorio NON esistente");
		}
		Ambulatorio a = ar.findById(request.getNomeAmbulatorio()).get();
		a.setNomeAmbulatorio(request.getNomeAmbulatorio());
		ar.save(a);
	}
	
	public void calcella(String nome) throws NotFoundException {
		if(!ar.existsById(nome)) {
			throw new NotFoundException("Nome Ambulatorio NON esistente");
		}
		ar.deleteById(nome);
	}
	
	public List<Ambulatorio> findAll() {
		if(ar.findAll().isEmpty()) {
			throw new NoSuchElementException("LISTA VUOTA!");
		}
		return ar.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
}
