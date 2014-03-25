package com.plan.proyecto.dao;

import com.plan.proyecto.beans.ComentariosAmigos;
import com.plan.proyecto.beans.ContenidoMuro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public class MuroDaoSimple implements MuroDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ContenidoMuro> listaContenidoMuro(Long idUsuario) {
        Query q = em.createQuery("select c from ContenidoMuro c where c.usuario.id=:id");
        q.setParameter("id", idUsuario);
        return q.getResultList();
    }

    @Override
    public List<ComentariosAmigos> listaComentarios(Long idContenido) {
        Query q = em.createQuery("select c from ComentariosAmigos c where c.contenidoMuro.id=:id");
        q.setParameter("id", idContenido);
        return q.getResultList();

    }
    
    @Override
    public ContenidoMuro buscaContenidoPorId(Long idContenido) {
        return em.find(ContenidoMuro.class, idContenido);
    }

    @Override
    public ContenidoMuro altaComentario(ContenidoMuro contenidoMuro) {
        return contenidoMuro;
    }

}
