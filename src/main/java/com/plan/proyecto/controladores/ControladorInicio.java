package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.ContenidoMuro;
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

/**
 */
@Controller
@RequestMapping("/inicio.html")
public class ControladorInicio {

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
    
    @RequestMapping(method = RequestMethod.GET)
    public void controladorGetInicio() {

    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String controladorPostInicio(@ModelAttribute("usuario") Usuario usuario, Model model) {
//        String claveU = usuario.getClave();
//        Usuario existeUsuario = servicio.buscaUsuario(usuario.getNombre());
//        if (existeUsuario == null) {
//            model.addAttribute("errorU", "Usuario No Existe");
//            return "inicio";
//        } else {
//            if (!existeUsuario.getClave().equals(claveU)) {
//                model.addAttribute("errorC", "Usuario No Existe");
//                return "inicio";
//            } else {
//                model.addAttribute("usuario", existeUsuario);
//                List<ContenidoMuro> contenidoMuro = servicio.listaContenidoMuro(existeUsuario.getId());
//                model.addAttribute("vacio", contenidoMuro.isEmpty());
//                model.addAttribute("contenidoMuro", contenidoMuro);
//                List<Usuario> listaAmigos = servicio.listaAmigos(existeUsuario.getId());
//                model.addAttribute("vacioA", listaAmigos.isEmpty());
//                model.addAttribute("listaAmigos", listaAmigos);
//                List<Usuario> listaAmigosAcceso = servicio.listaAmigosAccesibles(existeUsuario.getId());
//                model.addAttribute("vacioAcceso", listaAmigosAcceso.isEmpty());
//                model.addAttribute("listaAmigosAcceso", listaAmigosAcceso);
//                return "muroUsuario";
//            }
//        }
//
//    }

}
