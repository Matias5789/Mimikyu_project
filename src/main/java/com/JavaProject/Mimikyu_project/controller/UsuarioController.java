package com.JavaProject.Mimikyu_project.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaProject.Mimikyu_project.Model.Usuario;
import com.JavaProject.Mimikyu_project.Model.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(Model model,@ModelAttribute Usuario usuario) {
        UsuarioService cs = context.getBean(UsuarioService.class);
        cs.inserirUsuario(usuario);
        return "sucesso";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        List<Map<String, Object>> lista = usuarioService.listarUsuario();
        model.addAttribute("lista", lista);
        return "listar";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Model model){
        UsuarioService cs = context.getBean(UsuarioService.class);
        Map<String,Object> Usuario = cs.obterUsuario(id).get(0);
        String nome = (String) Usuario.get("nome");
        String sobren = (String) Usuario.get("sobren");
        String email = (String) Usuario.get("email");
        model.addAttribute("usuario", new Usuario(nome,sobren,email));
        model.addAttribute("nome", nome);
        model.addAttribute("sobren", sobren);
        model.addAttribute("email", email);
        return "atualiza";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id
        , Model model
        , @ModelAttribute Usuario usu){
            UsuarioService cs = context.getBean(UsuarioService.class);
            cs.atualizarUsuario(id, usu);
            return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id){
        UsuarioService cs = context.getBean(UsuarioService.class);
        cs.apagarUsuario(id);
        return "redirect:/listar";
    }
}
