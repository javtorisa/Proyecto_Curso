package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.ContenidoMuroDTO;
import com.plan.proyecto.beans.Usuario;
import com.plan.proyecto.servicios.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 */
@Controller
public class ControladorAmigos {

    @Autowired
    private ServicioUsuario servicio;

    @ModelAttribute("usuario")
    public Usuario getUsuario() {
        return new Usuario();
    }

    @ModelAttribute("contenidoMuroDTO")
    public ContenidoMuroDTO getContenidoMuro() {
        return new ContenidoMuroDTO();
    }

    @RequestMapping(value="/altaAmigo.html", method = RequestMethod.GET)
    public void controladorAltaAmigo(@RequestParam("idUsuario") Long idUsuario, Model model) {
        Usuario usuarioMuro = servicio.buscaUsuarioporId(idUsuario);
        model.addAttribute("usuario", usuarioMuro);
        List<Usuario> listaUsuarios = servicio.listaUsuariosNoAmigos(idUsuario);
        model.addAttribute("listaUsuarios", listaUsuarios);
        List<Usuario> listaAmigos = servicio.listaAmigos(idUsuario);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        model.addAttribute("error", " ");
    }

   
    @RequestMapping(value="/ponAmigo.html", method = RequestMethod.GET)
    public String controladorPonerAmigo(@RequestParam("idUsuario") Long idUsu, @RequestParam("idAmigo") Long idAmigo, Model model) {
        servicio.altaAmigo(idUsu, idAmigo);
        Usuario usuarioMuro = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", usuarioMuro);
        List<Usuario> listaUsuarios = servicio.listaUsuariosNoAmigos(idUsu);
        model.addAttribute("listaUsuarios", listaUsuarios);
        List<Usuario> listaAmigos = servicio.listaAmigos(idUsu);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        model.addAttribute("error", "AMIGO AÑADIDO");
        return "altaAmigo";
        
    }
    
    @RequestMapping(value="/quitoAmigo.html", method = RequestMethod.GET)
    public String controladorQuitarAmigo(@RequestParam("idUsuario") Long idUsu, @RequestParam("idAmigo") Long idAmigo, Model model) {
        servicio.bajaAmigo(idUsu, idAmigo);
        Usuario usuarioMuro = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", usuarioMuro);
        List<Usuario> listaUsuarios = servicio.listaUsuariosNoAmigos(idUsu);
        model.addAttribute("listaUsuarios", listaUsuarios);
        List<Usuario> listaAmigos = servicio.listaAmigos(idUsu);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        model.addAttribute("error", "AMIGO REMOVIDO");
        return "altaAmigo";

    }

}
