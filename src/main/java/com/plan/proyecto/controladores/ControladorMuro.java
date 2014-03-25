package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.ComentariosAmigos;
import com.plan.proyecto.beans.ContenidoMuro;
import com.plan.proyecto.beans.ContenidoMuroDTO;
import com.plan.proyecto.beans.Usuario;
import com.plan.proyecto.servicios.ServicioUsuario;
import java.util.Date;
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
public class ControladorMuro {

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

    @RequestMapping(value = "/altaUsuario.html", method = RequestMethod.GET)
    public void controladorGetAltaUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {

    }

    @RequestMapping(value = "/altaUsuario.html", method = RequestMethod.POST)
    public String controladorPostAltaUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario existeUsuario = servicio.buscaUsuario(usuario.getNombre());
        if (existeUsuario != null) {
            model.addAttribute("errorU", "USUARIO EXISTENTE");
            return "altaUsuario";
        }
        usuario.setFechaAlta(new Date());
        servicio.crearUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("vacio", true);
        model.addAttribute("vacioA", true);
        return "muroUsuario";
    }

    @RequestMapping(value = "/altaContenido.html", method = RequestMethod.POST)
    public String controladorAltaContenido(@ModelAttribute("contenidoMuroDTO") ContenidoMuroDTO contenidoMuroDTO, @RequestParam("idUsuario") Long idUsu, Model model) {
        contenidoMuroDTO.setIdUsu(idUsu);
        servicio.crearContenidoMuro(contenidoMuroDTO);
        Usuario existeUsuario = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", existeUsuario);
        List<ContenidoMuro> contenidoMuro = servicio.listaContenidoMuro(existeUsuario.getId());
        model.addAttribute("vacio", contenidoMuro.isEmpty());
        model.addAttribute("contenidoMuro", contenidoMuro);
        List<Usuario> listaAmigos = servicio.listaAmigos(idUsu);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        return "muroUsuario";
    }

    @RequestMapping(value = "/muroUsuario.html", method = RequestMethod.GET)
    public void controladorGetMuro() {

    }

    @RequestMapping(value = "/muroAmigo.html", method = RequestMethod.GET)
    public String controladorMuroAmigo(@RequestParam("idUsuario") Long idUsu, @RequestParam("idAmigo") Long idAmigo, Model model) {
        Usuario usuarioO = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuarioO", usuarioO);
        Usuario usuarioA = servicio.buscaUsuarioporId(idAmigo);
        model.addAttribute("usuarioA", usuarioA);
        List<ContenidoMuro> contenidoMuro = servicio.listaContenidoMuro(usuarioA.getId());
        model.addAttribute("vacio", contenidoMuro.isEmpty());
        model.addAttribute("contenidoMuro", contenidoMuro);
        List<Usuario> listaAmigos = servicio.listaAmigos(idAmigo);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        return "muroUsuarioAmigo";

    }

    @RequestMapping(value = "/editarContenido.html", method = RequestMethod.GET)
    public String controladorEditarContenido(@RequestParam("idUsuario") Long idUsu, @RequestParam("idContenido") Long idContenido, @RequestParam("idUsuarioA") Long idUsuA, Model model) {
        Usuario UsuarioMuro = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", UsuarioMuro);
        Usuario UsuarioA = servicio.buscaUsuarioporId(idUsuA);
        model.addAttribute("usuarioA", UsuarioA);
        ContenidoMuro contenidoMuro = servicio.buscaContenidoPorId(idContenido);
        model.addAttribute("contenidoMuro", contenidoMuro);
        List<ComentariosAmigos> comentariosAmigos = servicio.listaComentarios(idContenido);
        model.addAttribute("vacioC", comentariosAmigos.isEmpty());
        model.addAttribute("comentariosAmigos", comentariosAmigos);
        return "editarContenido";
    }

    @RequestMapping(value = "/altaComentario.html", method = RequestMethod.POST)
    public String controladorAltaComentario(@ModelAttribute("contenidoMuroDTO") ContenidoMuroDTO contenidoMuroDTO,
            @RequestParam("idUsuario") Long idUsu, @RequestParam("idContenido") Long idContenido, @RequestParam("idUsuarioA") Long idUsuA, Model model) {
        servicio.altaComentario(contenidoMuroDTO, idContenido, idUsu);
        Usuario UsuarioMuro = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", UsuarioMuro);
        Usuario UsuarioA = servicio.buscaUsuarioporId(idUsuA);
        model.addAttribute("usuarioA", UsuarioA);
        ContenidoMuro contenidoMuro = servicio.buscaContenidoPorId(idContenido);
        model.addAttribute("contenidoMuro", contenidoMuro);
        List<ComentariosAmigos> comentariosAmigos = servicio.listaComentarios(idContenido);
        model.addAttribute("vacioC", comentariosAmigos.isEmpty());
        model.addAttribute("comentariosAmigos", comentariosAmigos);
        return "editarContenido";
    }

    @RequestMapping(value = "/volverMuro.html", method = RequestMethod.GET)
    public String controladorVolverMuro(@RequestParam("idUsuario") Long idUsu, Model model) {
        Usuario UsuarioMuro = servicio.buscaUsuarioporId(idUsu);
        model.addAttribute("usuario", UsuarioMuro);
        List<ContenidoMuro> contenidoMuro = servicio.listaContenidoMuro(idUsu);
        model.addAttribute("vacio", contenidoMuro.isEmpty());
        model.addAttribute("contenidoMuro", contenidoMuro);
        List<Usuario> listaAmigos = servicio.listaAmigos(idUsu);
        model.addAttribute("vacioA", listaAmigos.isEmpty());
        model.addAttribute("listaAmigos", listaAmigos);
        return "muroUsuario";
    }

}
