package it.studiomedico.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Persona {

	private String nome;
	private String cognome;
	private int eta;
	private LocalDate dataDiNascita;
	@Enumerated(EnumType.STRING)
	private Genere genere;
	private String indirizzo;
	private String email;

	
}
