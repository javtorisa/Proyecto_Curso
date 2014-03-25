<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA DE USUARIO</title>
    </head>
    <body>
    <form:form commandName="usuario">
        <table>
            <tr>
                <td>NOMBRE:</td>
                <td>
                <form:input path="nombre"/>
                </td>
                <td>
                <h3 id="errorU">${errorU}</h3>
                </td>
            </tr>
            <tr>
                <td>APELLIDOS:</td>
                <td>
                <form:input path="apellidos"/>
                </td>
                <td>
                <h3 id="errorA">${errorA}</h3>
                </td>
            </tr>
            <tr>
                <td>PASSWORD:</td>
                <td>
                <form:input path="clave"/>
                </td>
                <td>
                <h3 id="errorC">${errorC}</h3>
            </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="ALTA"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
