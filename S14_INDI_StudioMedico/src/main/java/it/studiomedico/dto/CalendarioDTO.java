package it.studiomedico.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CalendarioDTO {

	final static String DATE_PATTERN = "dd/MM/yyyy";
	
	
	private String nomeAmbulatorio;
	
	@Schema(example = "dd/MM/yyyy", type = "string")
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDate dataTurno;
	
	
}
