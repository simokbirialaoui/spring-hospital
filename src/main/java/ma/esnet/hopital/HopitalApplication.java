package ma.esnet.hopital;

import ma.esnet.hopital.entities.*;
import ma.esnet.hopital.repository.ConsultationRepository;
import ma.esnet.hopital.repository.MedecinRepository;
import ma.esnet.hopital.repository.PatientRepository;
import ma.esnet.hopital.repository.RendezVousRepository;
import ma.esnet.hopital.service.IHospitalService;
import ma.esnet.hopital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {


    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, UserService userService) {
        return args -> {
            Stream.of("mohammed", "hanan", "mehdi").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.SavePatient(patient);

            });
            Stream.of("jhon", "hinata", "ilyas").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name + "@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                hospitalService.SaveMedecin(medecin);

            });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("mohammed");
            Medecin medecin = medecinRepository.findByNom("jhon");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);
            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ....");
            hospitalService.saveConsultation(consultation);

            User user1 = new User();
            user1.setUsername("ahmed");
            user1.setPassword("123456");
            userService.addNewUser(user1);
            User user2 = new User();
            user2.setUsername("khadija");
            user2.setPassword("abcdef");
            userService.addNewUser(user2);
            User user3 = new User();
            user3.setUsername("khawla");
            user3.setPassword("aaazzz");
            userService.addNewUser(user3);


            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role = new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });
            userService.addRoleToUser("khadija", "STUDENT");
            userService.addRoleToUser("khadija", "USER");
            userService.addRoleToUser("khawla", "USER");
            userService.addRoleToUser("ahmed", "ADMIN");
            try {
                User user = userService.authenticate("khadija", "abcdef");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("ROLES=>");
                user.getRoles().forEach(r -> System.out.println("role=>" + r));

            } catch (Exception exception) {
                exception.printStackTrace();
            }


        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        patientRepository.save(new Patient(null,"mohammed",new Date(98, 2, 24),true,10));
//        patientRepository.save(new Patient(null,"hanan",new Date(94, 10, 30),true,8));
//        patientRepository.save(new Patient(null,"mehdi",new Date(90, 9, 11),false,2));
//        List<Patient> Patients = patientRepository.findAll();
//        Patients.forEach(p->{
//            System.out.println(p.toString());
//        });
//
//        Patient patient= patientRepository.findById(Long.valueOf(1)).get();
//
//        System.out.println("*************");
//        System.out.println(patient.getId());
//        System.out.println(patient.getNom());
//        System.out.println(patient.getScore());
//        System.out.println("*************");
//        List<Patient> patientList = patientRepository.findByNameContains("a");
//        patientList.forEach(p-> System.out.println(p));
//        System.out.println("*************");
//        List<Patient> patientList2 = patientRepository.search("%d%");
//        patientList2.forEach(p-> System.out.println(p));
//        System.out.println("*************");
//        List<Patient> patientList3 = patientRepository.findByScoreGreaterThan(3);
//        patientList3.forEach(p-> System.out.println(p));
//        System.out.println("***************");
//        List<Patient> patientsList4=patientRepository.searchByScore(9);
//        patientsList4.forEach(p->System.out.println(p));
//
//
//    }
}
