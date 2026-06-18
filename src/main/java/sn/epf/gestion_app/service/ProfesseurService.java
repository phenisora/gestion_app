package sn.epf.gestion_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.epf.gestion_app.model.Professeur;
import sn.epf.gestion_app.repository.ProfesseurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository repo;

    public List<Professeur> findAll() {
        return repo.findAll();
    }

    public Optional<Professeur> findById(Long id) {
        return repo.findById(id);
    }

    public Professeur sauvegarder(Professeur p) {
        return repo.save(p);
    }

    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}