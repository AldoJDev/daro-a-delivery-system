package praticasB.daroca.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class AutenticationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String autenticar(String usuario, String senha) {
        return jdbcTemplate.queryForObject(
                "EXEC autenticarAnalista ?, ?",
                new Object[]{usuario, senha}, String.class);
    }
}




