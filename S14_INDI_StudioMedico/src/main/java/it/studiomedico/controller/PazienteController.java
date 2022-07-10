package it.studiomedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.studiomedico.dto.AmbulatorioDTO;
import it.studiomedico.dto.PazienteDTO;
import it.studiomedico.model.Ambulatorio;
import it.studiomedico.model.Paziente;
import it.studiomedico.services.PazienteService;

@RestController
@RequestMapping("/paziente")
public class PazienteController {
	
	@Autowired PazienteService ps;
	
	@Operation(summary = "Inserimento", description = "Inserisce un paziente nel db")
	@ApiResponse(responseCode = "200", description = "Inserito con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nell'inserimento")
	@PostMapping
	public ResponseEntity<String> inserisci(@RequestBody PazienteDTO request) {
		ps.inserisci(request);
		return ResponseEntity.ok("Inserito correttamente!!!");
	}
	
	@Operation(summary = "Modifica", description = "Modifica il nome di un paziente nel db")
	@ApiResponse(responseCode = "200", description = "Eseguito con successo")
	@ApiResponse(responseCode = "500", description = "Errore!")
	@PutMapping("/{cf}")
	public ResponseEntity<String> modifica(@PathVariable String cf, @RequestBody PazienteDTO request) {
		ps.modifica(request);
		return ResponseEntity.ok("Modificato con successo!!!");
	}
	
	@Operation(summary = "Eliminazione", description = "Elimina un paziente nel db")
	@ApiResponse(responseCode = "200", description = "Eliminato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@DeleteMapping("/{cf}")
	public ResponseEntity<String> elimina(@PathVariable String cf) {
		ps.elimina(cf);
		return ResponseEntity.ok("Eliminato con successo!!!");	
	}
	
	@Operation(summary = "Elenco Completo", description = "Mostra l'elenco di tutti i pazienti presenti nel db")
	@ApiResponse(responseCode = "200", description = "Effettuato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@GetMapping("/trovatutti")
	public ResponseEntity<List<Paziente>> trovaTutti() {
		return ResponseEntity.ok(ps.findAll());
	}
	
	

}
