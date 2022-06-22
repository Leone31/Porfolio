package it.studiomedico.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import it.studiomedico.model.Genere;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicoDTO {

	final static String DATE_PATTERN = "dd/MM/yyyy" ;


	private String nome;
	private String cognome;
	@Enumerated(EnumType.STRING)
	private Genere genere;
	private int eta;
	@Schema(example = "dd/MM/yyyy",type = "string")
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDate dataDiNascita;
	private String indirizzo;
	private String email;
	private String specialistica;
	private String nomeAmbulatorio;
	
}