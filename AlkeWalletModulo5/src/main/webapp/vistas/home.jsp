<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.Usuario"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Home</title>
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
    
     <h3>Realizar Depósito</h3>
    <form action="DepositoController" method="post">
        <label for="cantidad">Cantidad a depositar:</label>
        <input type="text" id="cantidad" name="cantidad" />
        <button type="submit">Depositar</button>
    </form>
    
    <h3>Realizar Retiro</h3>
    <form action="RetiroController" method="post">
        <label for="cantidad">Cantidad a retirar:</label>
        <input type="text" id="cantidad" name="cantidad" />
        <button type="submit">Retirar</button>
    </form>
    
</body>
</html>
