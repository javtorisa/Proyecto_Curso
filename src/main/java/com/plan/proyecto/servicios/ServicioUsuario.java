package com.plan.proyecto.servicios;

import com.plan.proyecto.beans.ComentariosAmigos;
import com.plan.proyecto.beans.ContenidoMuro;
import com.plan.proyecto.beans.ContenidoMuroDTO;
import com.plan.proyecto.beans.Usuario;
import java.util.List;

/**
 */
public interface ServicioUsuario {

    Usuario crearUsuario(Usuario Usuario);

    void crearContenidoMuro(ContenidoMuroDTO contenidoMuroDTO);

    void altaComentario(ContenidoMuroDTO contenidoMuroDTO, Long idContenido, Long idUsu);

    Usuario buscaUsuario(String nombre);

    Usuario buscaUsuarioporId(Long idUsuario);

    ContenidoMuro buscaContenidoPorId(Long idContenido);

    List<Usuario> listaUsuarios();

    List<Usuario> listaUsuariosNoAmigos(Long idUsuario);

    List<ContenidoMuro> listaContenidoMuro(Long idUsuario);

    List<Usuario> listaAmigos(Long idUsuario);

    List<Usuario> listaAmigosAccesibles(Long idUsuario);

    List<ComentariosAmigos> listaComentarios(Long idContenido);

    void altaAmigo(Long idUsuario, Long idAmigo);

    void bajaAmigo(Long idUsuario, Long idAmigo);

}
