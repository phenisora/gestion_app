package sn.epf.gestion_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.epf.gestion_app.model.Etudiant;

public interface EtudiantRepository 
    extends JpaRepository<Etudiant, Long> {

}