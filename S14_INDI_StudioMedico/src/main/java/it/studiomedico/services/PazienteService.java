package it.studiomedico.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import it.studiomedico.dto.PazienteDTO;
import it.studiomedico.model.Paziente;
import it.studiomedico.repository.PazienteRepository;

@Service
public class PazienteService {

	
	@Autowired PazienteRepository pr;
	
	public void inserisci(PazienteDTO request) {
		if(pr.existsById(request.getCodiceFiscale())) {
			throw new EntityExistsException();
		}
		Paziente p = new Paziente();
		BeanUtils.copyProperties(request, p);
		pr.save(p);
	}
	
	public void modifica(PazienteDTO request) {
		if(!pr.existsById(request.getCodiceFiscale())) {
			throw new NotFoundException("Il Codice Fiscale NON esiste");
		}
		Paziente p = pr.findById(request.getCodiceFiscale()).get();
		BeanUtils.copyProperties(request, p);
		pr.save(p);
	}
	
	public void elimina(String cf) {
		if(!pr.existsById(cf)) {
			throw new NotFoundException("Il Codice Fiscale NON funziona");
		}
		pr.deleteById(cf);
	}
	
	public List<Paziente> findAll() {
		if(pr.findAll().isEmpty()) {
			throw new NoSuchElementException("LISTA VUOTA!");
		}
		return pr.findAll();
	}
	
	
	
}
