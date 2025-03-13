package ma.proj.tp2ormjpahibernatespringdata.repositories;

import ma.proj.tp2ormjpahibernatespringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNomContains(String hassan);

}
