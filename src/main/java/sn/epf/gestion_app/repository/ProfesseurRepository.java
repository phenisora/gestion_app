package sn.epf.gestion_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.epf.gestion_app.model.Professeur;

public interface ProfesseurRepository 
    extends JpaRepository<Professeur, Long> {

}