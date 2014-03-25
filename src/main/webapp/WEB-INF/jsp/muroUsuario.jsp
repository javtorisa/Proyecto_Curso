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
        <h1 align="center">eWALL de ${usuario.nombre}</h1>
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="30%">
                    <form:form commandName="contenidoMuroDTO" 
                               action="altaContenido.html?idUsuario=${usuario.id}">
                        <table border="2">
                            <tr>
                                <td>Contenido:</td>
                                <td>
                                    <form:input path="objetoMuro"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Comentario:</td>
                                <td>
                                    <form:input path="comentario"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <input type="submit" value="ALTA"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
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
                                                <a href= "editarContenido.html?idUsuario=${usuario.id}&idContenido=${contenidoMuro.id}&idUsuarioA=${usuario.id}">EDITAR</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </form:form>
                </td>
                <td width="15%">
                    <form:form >
                        <table border="1" bordercolor="blue">
                            <thead>
                                <tr>
                                    <th scope="col">AMIGOS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <a href="altaAmigo.html?idUsuario=${usuario.id}">MENU AMIGOS</a>
                                    </td>
                                </tr>
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
                <td width="15%">
                    <form:form>
                        <table border="1" bordercolor="green">
                            <thead>
                                <tr>
                                    <th scope="col">MURO DE ...</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${vacioAcceso == true}">
                                    <tr>
                                        <td>
                                            <h2>SIN ACCESOS</h2>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${vacioAcceso == false}">
                                    <c:forEach items="${listaAmigosAcceso}" var="listaAmigosAcceso">
                                        <tr>
                                            <td>
                                                <a href= "muroAmigo.html?idUsuario=${usuario.id}&idAmigo=${listaAmigosAcceso.id}">${listaAmigosAcceso.nombre}</a>
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
    </body>
</html>
