package ma.esnet.hopital.repository;

import ma.esnet.hopital.entities.Patient;
import ma.esnet.hopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
