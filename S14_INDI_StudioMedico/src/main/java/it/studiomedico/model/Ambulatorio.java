package it.studiomedico.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ambulatorio {

	@Id	
	private String nomeAmbulatorio;
	
	@OneToMany(mappedBy = "ambulatorio")
	private List<Calendario> calendario = new ArrayList<Calendario>();
	
	@OneToMany(mappedBy = "ambulatorio")
	private List<Medico> medici = new ArrayList<Medico>();
	
}
