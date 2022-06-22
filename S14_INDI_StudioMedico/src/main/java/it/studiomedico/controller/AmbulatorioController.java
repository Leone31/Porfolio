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
import it.studiomedico.model.Ambulatorio;
import it.studiomedico.services.AmbulatorioService;

@RestController
@RequestMapping("/ambulatorio")
public class AmbulatorioController {

	@Autowired AmbulatorioService as;
	
	
	@Operation(summary = "Inserimento", description = "Inserisce un ambulatorio nel db")
	@ApiResponse(responseCode = "200", description = "Inserito con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nell'inserimento")
	@PostMapping
	public ResponseEntity<String> inserisci(@RequestBody AmbulatorioDTO request) {
		as.inserisci(request);
		return ResponseEntity.ok("Inserito correttamente!!!");
	}
	
	@Operation(summary = "Modifica un ambulatorio", description = "Modifica il nome di un ambulario nel db")
	@ApiResponse(responseCode = "200", description = "Eseguito con successo")
	@ApiResponse(responseCode = "500", description = "Errore!")
	@PutMapping("/{nome}")
	public ResponseEntity<String> modifica( @PathVariable String nome, @RequestBody AmbulatorioDTO request) {
		as.modifica(request);
		return ResponseEntity.ok("Modificato con successo!!!");
	}
	
	@Operation(summary = "Elimina un ambulatorio", description = "Elimina un ambulatorio nel db")
	@ApiResponse(responseCode = "200", description = "Eliminato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@DeleteMapping("/{nome}")
	public ResponseEntity<String> elimina(@PathVariable String nome) {
		as.calcella(nome);
		return ResponseEntity.ok("Eliminato con successo!!!");	
	}
	
	@Operation(summary = "Stampa tutti gli ambulatori", description = "Stampa tutti gli ambulatori del db")
	@ApiResponse(responseCode = "200", description = "Effettuato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@GetMapping("/trovatutti")
	public ResponseEntity<List<Ambulatorio>> trovaTutti() {
		return ResponseEntity.ok(as.mostraTutti());
	}
	
}
