package praticasB.daroca.classes;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Analyst {

    @Id
    private UUID id;

    private String username;
    private String password;

    public Analyst(String user, String password){
        username = user;
        password = password;
    }
}



