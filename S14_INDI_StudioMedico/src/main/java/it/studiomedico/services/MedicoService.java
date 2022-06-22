package it.studiomedico.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import it.studiomedico.dto.MedicoDTO;
import it.studiomedico.model.Ambulatorio;
import it.studiomedico.model.Medico;
import it.studiomedico.repository.AmbulatorioRepository;
import it.studiomedico.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired MedicoRepository mr;
	@Autowired AmbulatorioRepository ar;
	
	public void inserisci(MedicoDTO request) throws EntityExistsException {
		if(mr.existsByEmail(request.getEmail())) {
			throw new EntityExistsException("Email gia presente");
		}
		Medico m = new Medico();
		Ambulatorio a = ar.findById(request.getNomeAmbulatorio()).get();
		BeanUtils.copyProperties(request, m);
		m.setAmbulatorio(a);
		mr.save(m);
	}
	
	public void modifica(MedicoDTO request, int id) throws NotFoundException {
		if(!mr.existsByEmail(request.getEmail())) {
			throw new NotFoundException("Email NON presente");
		}
		Medico m = mr.findById(id).get();
		Ambulatorio a = ar.findById(request.getNomeAmbulatorio()).get();
		BeanUtils.copyProperties(request, m);
		m.setAmbulatorio(a);
		mr.save(m);
	}
	
	public void elimina(String email) throws NotFoundException {
		if(!mr.existsByEmail(email)) {
			throw new NotFoundException("Email NON presente");
		}
		mr.deleteByEmail(email);
	}
	
	public List<Medico> mostraTutti() throws NoSuchElementException {
		if(ar.findAll().isEmpty()) {
			throw new NoSuchElementException ("LISTA VUOTA!");
		}
		return (List<Medico>) mr.findAll();
	}
	
}
