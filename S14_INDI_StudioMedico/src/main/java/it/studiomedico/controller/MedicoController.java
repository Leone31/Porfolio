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
import it.studiomedico.dto.MedicoDTO;
import it.studiomedico.model.Medico;
import it.studiomedico.services.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired MedicoService ms;
	
	
	@Operation(summary = "Inserimento", description = "Inserisce un medico nel db")
	@ApiResponse(responseCode = "200", description = "Inserito con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nell'inserimento")
	@PostMapping
	public ResponseEntity<String> inserisci(@RequestBody MedicoDTO request) {
		ms.inserisci(request);
		return ResponseEntity.ok("Inserito correttamente!!!");
	}
	
	@Operation(summary = "Modifica", description = "Modifica il nome di un medico nel db")
	@ApiResponse(responseCode = "200", description = "Eseguito con successo")
	@ApiResponse(responseCode = "500", description = "Errore!")
	@PutMapping("/{id}")
	public ResponseEntity<String> modifica( @PathVariable int id, @RequestBody MedicoDTO request) {
		ms.modifica(request, id);
		return ResponseEntity.ok("Modificato con successo!!!");
	}
	
	@Operation(summary = "Eliminazione", description = "Elimina un medico dal db")
	@ApiResponse(responseCode = "200", description = "Eliminato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@DeleteMapping("/{email}")
	public ResponseEntity<String> elimina(@PathVariable String email) {
		ms.elimina(email);
		return ResponseEntity.ok("Eliminato con successo!!!");	
	}
	
	@Operation(summary = "Elenco completo", description = "Stampa tutti i medici del db")
	@ApiResponse(responseCode = "200", description = "Effettuato con successo nel db")
	@ApiResponse(responseCode = "500", description = "Errore nella cancellazione")
	@GetMapping("/trovatutti")
	public ResponseEntity<List<Medico>> trovaTutti() {
		return ResponseEntity.ok(ms.mostraTutti());
	}
	
}
