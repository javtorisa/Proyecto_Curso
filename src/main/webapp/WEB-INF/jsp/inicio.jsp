<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAGINA DE INICIO DEL MURO</title>
        <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
        <script type="text/javascript">
            function loginUsuario() {
                $.ajax({
                    url: "login.html",
                    type: "GET",
                    data: {
                        nombre: $("#nombre").val(),
                        clave: $("#clave").val()
                    },
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    dataType: "json",
                    success: function(usuario) {
                        $("#respuesta").html(usuario);
                        //var usuario = JSON.stringify(json.data);
                        //$("#nombre").html(usuario.nombre);
                    }
                });
            }
            ;

            function alta() {
                var html = "<table border 1>";
                html += "<tr>";
                html += "<td>Nombre</td>";
                html += "<td><input type='text' id='nombreAlta'/></td>";
                html += "</tr><tr>";
                html += "<td>Apellidos</td>";
                html += "<td><input type='text' id='apellidoAlta'/></td>";
                html += "</tr><tr>";
                html += "<td>Clave</td>";
                html += "<td><input type='text' id='claveAlta'/></td>";
                html += "</tr><tr>";
                html += "<td></td>";
                html += "<td><button onclick='altaUsuario()'>ALTA USUARIO</button></td>";
                $("#camposAlta").html(html);
            }
            ;
            function altaUsuario() {
                $.ajax({
                url: "altaNuevoUsuario.html",
                        type: "GET",
                        data: {
                        nombre: $("#nombreAlta").val(),
                                apellido: $("#apellidoAlta").val(),
                                clave: $("#claveAlta").val()
                        },
                        dataType: "json",
                        success: function(json) {
                        $("#nombre").val() = json.nombre,
                                $("#clave").val() = " "
                        }
                });
                        $("#camposAlta").html(" ");
            }
            ;</script>
    </head>
    <body>
        <div id="camposUsuario">
            <table>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td>
                        <input type="text" id="nombre"/>
                    </td>
                    <td>
                        <h3 id="errorU">${errorU}</h3>
                    </td>
                    <td>Clave:</td>
                    <td>
                        <input type="password" id="clave"/>
                    </td>
                    <td>
                        <h3 id="errorC">${errorC}</h3>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <button onclick="loginUsuario()">Login</button>
                    </td>
                </tr>
            </table>
            <br/><br/><br/><br/>
            <table>
                <tr>
                    <td colspan="3">
                        <button onclick="alta()">ALTA USUARIO</button>
                    </td>
                </tr>
            </table>
        </div>
        <div id="respuesta"></div>
        <div id="camposAlta"></div>
    </body>
</html>
