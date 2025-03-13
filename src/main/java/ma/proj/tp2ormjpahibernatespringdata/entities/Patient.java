package ma.proj.tp2ormjpahibernatespringdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.util.Date;
@Entity @AllArgsConstructor @NoArgsConstructor @ToString @Getter @Setter
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    Date dateNaissance;
    Boolean malade;
    int score;

}
