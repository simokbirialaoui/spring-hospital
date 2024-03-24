package ma.esnet.hopital.repository;

import ma.esnet.hopital.entities.Consultation;
import ma.esnet.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
