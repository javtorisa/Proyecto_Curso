package com.plan.proyecto.dao;

import com.plan.proyecto.beans.Usuario;
import java.util.List;

/**
 */
public interface UsuarioDao {

    Usuario guardarUsuario(Usuario usuario);

    Usuario buscaUsuario(String nombre);
    
    Usuario buscaUsuarioporId(Long idUsuario);

    List<Usuario> listaUsuarios();
    
    List<Usuario> listaUsuariosNoAmigos(Long idUsuario);
    
    List<Usuario> listaAmigos(Long idUsuario);
    
    List<Usuario> listaAmigosAccesibles(Long idUsuario);
    
    Usuario actualizaUsuario(Usuario usuario);
       
}
