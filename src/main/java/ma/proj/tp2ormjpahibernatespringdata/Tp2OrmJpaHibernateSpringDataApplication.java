package ma.proj.tp2ormjpahibernatespringdata;

import ma.proj.tp2ormjpahibernatespringdata.entities.Patient;
import ma.proj.tp2ormjpahibernatespringdata.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Tp2OrmJpaHibernateSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp2OrmJpaHibernateSpringDataApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            Patient p = new Patient(null, "Hassan", new Date(), false, 5);
            Patient p2 = new Patient(null, "Khalid", new Date(), false, 5);
            Patient p3 = new Patient(null, "Omar", new Date(), false, 5);
            Patient p4 = new Patient(null, "Salah", new Date(), false, 5);
            patientRepository.save(p);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);
            List<Patient> patients = patientRepository.findAll();
            System.out.println("Liste des patients : ");
            for (Patient patient : patients) {
                System.out.println(patient.toString());
            }
            System.out.println("*".repeat(50));
            System.out.println("Patient par ID : ");
            Optional patient = patientRepository.findById(1L);
            System.out.println(patient.toString());
            System.out.println("*".repeat(50));
            System.out.println("Patient par Nom : ");
            Patient patientByNom = patientRepository.findByNomContains("Hassan");
            System.out.println(patientByNom.toString());
            System.out.println("*".repeat(50));
            System.out.println("Update Patient : ");
            Patient patientToUpdate = patientRepository.findById(1L).get();
            System.out.println("patient before update"+patientToUpdate.toString());
            patientToUpdate.setNom("Hassan Updated");
            patientRepository.save(patientToUpdate);

            System.out.println("patient after update"+patientToUpdate.toString());

            System.out.println("*".repeat(50));
            System.out.println("Delete Patient : ");
            patientRepository.deleteById(1L);
            List<Patient> patientsAfterDelete = patientRepository.findAll();
            System.out.println("Liste des patients après suppression : ");
            for (Patient patientAfterDelete : patientsAfterDelete) {
                System.out.println(patientAfterDelete.toString());
            }

        };
    }

}
