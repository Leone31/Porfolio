package it.studiomedico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paziente extends Persona{

	@Id
	private String codiceFiscale;
	
	@OneToOne(mappedBy = "paziente")
	private Referto referto;
	
}
