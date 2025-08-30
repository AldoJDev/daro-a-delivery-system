package praticasB.daroca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import praticasB.daroca.Services.AutenticationService;


@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private AutenticationService autenticacaoService;

    @GetMapping("/getLogin")
    public String mostrarFormularioLogin() {
        return "Formulário de login"; // Retorna uma string representando o formulário de login
    }

    @PostMapping("/postLogin")
    public String autenticarUsuario(@RequestParam String usuario, @RequestParam String senha) {
        if (autenticacaoService.autenticar(usuario, senha).equals("Autenticado")) {
            return "Usuário autenticado com sucesso"; // Retorna uma string indicando autenticação bem-sucedida
        } else {
            return "Credenciais inválidas"; // Retorna uma string indicando credenciais inválidas
        }
    }

    @GetMapping("/pagina-autenticada")
    public String mostrarPaginaAutenticada() {
        return "Essa é a página autenticada"; // Retorna uma string representando a página autenticada
    }
}