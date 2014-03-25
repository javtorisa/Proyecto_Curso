<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">eWALL de ${usuarioO.nombre}</h1>
        <h2 align="center">COTILLEANDO eWALL de ${usuarioA.nombre}</h2>
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="55%">
                    <form:form>
                        <table border="1" bordercolor="red">
                            <thead>
                                <tr>
                                    <th scope="col">MURO</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${vacio == true}">
                                    <tr>
                                        <td>
                                            <h2>El usuario no tiene contenidos</h2>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${vacio == false}">
                                    <c:forEach items="${contenidoMuro}" var="contenidoMuro">
                                        <tr>
                                            <td>
                                                <p> Contenido: ${contenidoMuro.objetoMuro} <br/>
                                                    Comentarios: ${contenidoMuro.comentario} <br/>
                                                    (Fecha alta: ${contenidoMuro.fechaAlta}) <br/>
                                                    (id:${contenidoMuro.id})
                                                </p>
                                            </td>
                                            <td>
                                                <a href= "editarContenido.html?idUsuario=${usuarioO.id}&idContenido=${contenidoMuro.id}&idUsuarioA=${usuarioA.id}">EDITAR</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </form:form>
                </td>
                <td width="25%">
                    <form:form >
                        <table border="1" bordercolor="green">
                            <thead>
                                <tr>
                                    <th scope="col">AMIGOS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${vacioA == true}">
                                    <tr>
                                        <td>
                                            <h2>SIN AMIGOS</h2>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${vacioA == false}">
                                    <c:forEach items="${listaAmigos}" var="listaAmigos">
                                        <tr>
                                            <td>
                                                ${listaAmigos.nombre}
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table>
        <br/><br/><br/>
        <div>
            <a href="volverMuro.html?idUsuario=${usuarioO.id}">SALIR</a>
        </div>
    </body>
</html>
