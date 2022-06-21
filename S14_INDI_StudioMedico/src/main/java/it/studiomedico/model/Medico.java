package it.studiomedico.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Medico extends Persona {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String specialistica;
	
	@OneToOne(mappedBy = "medico")
	private Calendario calendario;
	
	@ManyToOne @JoinColumn
	private Ambulatorio ambulatorio;
	
	@OneToMany(mappedBy = "medico")
	private List<Referto> referto = new ArrayList<Referto>();
	
}
