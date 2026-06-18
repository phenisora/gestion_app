package sn.epf.gestion_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.epf.gestion_app.model.Etudiant;
import sn.epf.gestion_app.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository repo;

    public List<Etudiant> findAll() {
        return repo.findAll();
    }

    public Optional<Etudiant> findById(Long id) {
        return repo.findById(id);
    }

    public Etudiant sauvegarder(Etudiant e) {
        return repo.save(e);
    }

    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}