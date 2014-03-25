package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.Usuario;
import com.plan.proyecto.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class ControladorWeb {

    @Autowired
    private ServicioUsuario servicio;

    @RequestMapping(value = "/login.html", produces = "application/json")
    public Usuario loginUsuario(@RequestParam("nombre") String nombre, @RequestParam("clave") String clave) {
        Usuario existeUsuario = servicio.buscaUsuario(nombre);
        if (existeUsuario == null) {
            existeUsuario.setNombre("Usuario No Existe");
            return existeUsuario;
        } else {
            if (!existeUsuario.getClave().equals(clave)) {
                existeUsuario.setClave("Clave incorrecta");
                return existeUsuario;
            } else {
                return existeUsuario;
            }
        }

    }

    @RequestMapping(value = "/altaNuevoUsuario.html", method = RequestMethod.GET)
    public Usuario altaNuevoUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("clave") String clave) {
        Usuario existeUsuario = servicio.buscaUsuario(nombre);
        if (existeUsuario == null) {
            existeUsuario.setNombre("Usuario No Existe");
            return existeUsuario;
        } else {
            if (!existeUsuario.getClave().equals(clave)) {
                existeUsuario.setClave("Clave incorrecta");
                return existeUsuario;
            } else {
                return existeUsuario;
            }
        }

    }

}
