package sn.epf.gestion_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.epf.gestion_app.model.Etudiant;
import sn.epf.gestion_app.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService service;

    // GET /api/etudiants → liste complète
    @GetMapping
    public List<Etudiant> listerTous() {
        return service.findAll();
    }

    // GET /api/etudiants/42 → un étudiant par id
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(etudiant -> ResponseEntity.ok(etudiant))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/etudiants → créer un étudiant
    @PostMapping
    public ResponseEntity<Etudiant> creer(@RequestBody Etudiant e) {
        Etudiant sauvegarde = service.sauvegarder(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(sauvegarde);
    }

    // PUT /api/etudiants/42 → modifier un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> modifier(@PathVariable Long id,
                                              @RequestBody Etudiant e) {
        return service.findById(id)
                .map(etudiant -> {
                    e.setId(id);
                    return ResponseEntity.ok(service.sauvegarder(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/etudiants/42 → supprimer
    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}