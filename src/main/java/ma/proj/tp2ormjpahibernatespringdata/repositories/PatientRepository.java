package ma.proj.tp2ormjpahibernatespringdata.repositories;

import ma.proj.tp2ormjpahibernatespringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
