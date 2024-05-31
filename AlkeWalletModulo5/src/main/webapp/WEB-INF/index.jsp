<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Bienvenido a la Wallet</h1>
    <%
    List<Usuario> lista = (List<Usuario>) request.getAttribute("Usuario");
    if (lista != null && !lista.isEmpty()) {
        out.print("Hay un total de " + lista.size() + " cuenta(s) asociada(s) al cliente.");
    } else {
        out.print("No hay cuentas asociadas al cliente.");
    }
    %>
    <table class="table table-striped table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Nombre de Usuario</th>
                <th>Saldo</th>
            </tr>
        </thead>
        <tbody>
            <%
            if (lista != null) {
                for (Usuario usuario : lista) {
            %>
            <tr>
                <td><%= usuario.getUser_id() %></td>
                <td><%= usuario.getNombre_usuario() %></td>
                <td><%= usuario.getSaldo() %></td>
            </tr>
            <%
                }
            }
            %>
        </tbody>
    </table>
</body>
</html>
