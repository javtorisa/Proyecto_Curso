package com.plan.proyecto.dao;

import com.plan.proyecto.beans.ComentariosAmigos;
import com.plan.proyecto.beans.ContenidoMuro;
import java.util.List;

/**
 */
public interface MuroDao {

    List<ContenidoMuro> listaContenidoMuro(Long idUsuario);
    
    List<ComentariosAmigos> listaComentarios(Long idContenido);
    
    ContenidoMuro altaComentario(ContenidoMuro contenidoMuro);
    
    ContenidoMuro buscaContenidoPorId(Long idContenido);
    
}
