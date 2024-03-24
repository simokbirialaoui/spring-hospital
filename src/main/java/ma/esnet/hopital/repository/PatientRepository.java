package ma.esnet.hopital.repository;

import ma.esnet.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends  JpaRepository<Patient,Long> {

    List<Patient> findByNomContains(String mc);
    Patient findByNom(String name);
    @Query("select p from Patient p where p.nom like :x")
    List<Patient> search(@Param("x") String mc);


}
