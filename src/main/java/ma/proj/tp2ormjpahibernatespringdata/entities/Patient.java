package ma.proj.tp2ormjpahibernatespringdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;
@Entity @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    Date dateNaissance;
    Boolean malade;
    int score;

}
