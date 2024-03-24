package ma.esnet.hopital.service;

import ma.esnet.hopital.entities.Consultation;
import ma.esnet.hopital.entities.Medecin;
import ma.esnet.hopital.entities.Patient;
import ma.esnet.hopital.entities.RendezVous;

public interface IHospitalService {
    Patient SavePatient(Patient patient);

    Medecin SaveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);

}
