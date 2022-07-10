package it.studiomedico.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) crea una sola tabella con gli attributi di padre e figli
//@DiscriminatorColumn(name = "tipologia") per dare il come alla colonna dtype
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
