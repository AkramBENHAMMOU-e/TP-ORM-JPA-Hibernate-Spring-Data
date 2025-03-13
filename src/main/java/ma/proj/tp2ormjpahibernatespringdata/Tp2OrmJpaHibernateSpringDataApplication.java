package ma.proj.tp2ormjpahibernatespringdata;

import ma.proj.tp2ormjpahibernatespringdata.entities.Patient;
import ma.proj.tp2ormjpahibernatespringdata.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

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
        };
    }

}
