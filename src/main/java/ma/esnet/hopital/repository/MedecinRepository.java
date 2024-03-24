package ma.esnet.hopital.repository;

import ma.esnet.hopital.entities.Medecin;
import ma.esnet.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
