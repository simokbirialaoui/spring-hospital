package ma.esnet.hopital.service;

import jakarta.transaction.Transactional;
import ma.esnet.hopital.entities.Consultation;
import ma.esnet.hopital.entities.Medecin;
import ma.esnet.hopital.entities.Patient;
import ma.esnet.hopital.entities.RendezVous;
import ma.esnet.hopital.repository.ConsultationRepository;
import ma.esnet.hopital.repository.MedecinRepository;
import ma.esnet.hopital.repository.PatientRepository;
import ma.esnet.hopital.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient SavePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin SaveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
