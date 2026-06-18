package sn.epf.gestion_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.epf.gestion_app.model.Professeur;
import sn.epf.gestion_app.service.ProfesseurService;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService service;

    // GET /api/professeurs → liste complète
    @GetMapping
    public List<Professeur> listerTous() {
        return service.findAll();
    }

    // GET /api/professeurs/42 → un professeur par id
    @GetMapping("/{id}")
    public ResponseEntity<Professeur> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(prof -> ResponseEntity.ok(prof))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/professeurs → créer un professeur
    @PostMapping
    public ResponseEntity<Professeur> creer(@RequestBody Professeur p) {
        Professeur sauvegarde = service.sauvegarder(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(sauvegarde);
    }

    // DELETE /api/professeurs/42 → supprimer
    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}