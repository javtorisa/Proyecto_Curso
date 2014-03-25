<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR CONTENIDO DEL MURO</title>
    </head>
    <body>
        <h1 align="center">eWALL de ${usuario.nombre}</h1>
        <c:if test="${usuario.id != usuarioA.id}">
            <h2 align="center">COTILLEANDO eWALL de ${usuarioA.nombre}</h2>
        </c:if>
        <br/>
        <h2 align="center">CONTENIDO A EDITAR ${contenidoMuro.objetoMuro}</h1>
        <h3 align="center">TITULO ${contenidoMuro.comentario}</h3>
        <table>
            <form:form>
                <tr>
                    <td>COMENTARIOS:</td>
                </tr>        
                <c:if test="${vacioC == true}">
                    <tr>
                        <td>
                            <h2>SIN COMENTARIOS</h2>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${vacioC == false}">
                    <c:forEach items="${comentariosAmigos}" var="comentariosAmigos">
                        <tr>
                            <td>
                                COMENTARIO: ${comentariosAmigos.comentarioAmigo}
                            </td>
                            <td>
                                FECHA: ${comentariosAmigos.fechaComentario}
                            </td>
                            <td>
                                QUIEN: ${comentariosAmigos.usuarioComenta}
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>            
            </form:form>
        </table>
        <br/><br/>
        <form:form commandName="contenidoMuroDTO" 
                   action="altaComentario.html?idUsuario=${usuario.id}&idContenido=${contenidoMuro.id}&idUsuarioA=${usuarioA.id}">
            <table border="2">
                <tr>
                    <td>Contenido:</td>
                    <td>
                        <form:input path="comentarioAmigo"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="ALTA"/>
                    </td>
                </tr>
            </table>
        </form:form>
        <br/><br/>
        <table width="10%"  border="1">
            <tr>
            <c:if test="${usuario.id != usuarioA.id}">
                <a href= "muroAmigo.html?idUsuario=${usuario.id}&idAmigo=${usuarioA.id}">VOLVER</a>
            </c:if>
            <c:if test="${usuario.id == usuarioA.id}">
                <td>
                    <a href="volverMuro.html?idUsuario=${usuario.id}">VOLVER</a>
                </td>
            </c:if>
            </tr>
        </table>
    </body>
</html>
