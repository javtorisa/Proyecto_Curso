<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA AMIGO DEL MURO</title>
    </head>
    <body>
        <h1 align="center">eWALL de ${usuario.nombre}</h1>
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="40%">
                    <form:form>
                        <table width="35%"  border="1">
                            <c:forEach items="${listaUsuarios}" var="listaUsuarios">
                                <tr>
                                    <td>
                                        <a href= "ponAmigo.html?idUsuario=${usuario.id}&idAmigo=${listaUsuarios.id}">${listaUsuarios.nombre}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form:form>
                </td>
                <td width="20%">
                    <form:form>
                        <table width="30%"  border="1">
                            <tr>
                                <td colspan="3">
                                    <h3>${error}</h3>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="volverMuro.html?idUsuario=${usuario.id}">SALIR</a>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
                <td width="40%">
                    <form:form>
                        <table width="35%"  border="1">
                            <c:forEach items="${listaAmigos}" var="listaAmigos">
                                <tr>
                                    <td>
                                        <a href= "quitoAmigo.html?idUsuario=${usuario.id}&idAmigo=${listaAmigos.id}">${listaAmigos.nombre}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table>
    </body>
</html>
