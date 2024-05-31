package controller;

import dao.DaoUsuario;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionBD.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");  
        response.getWriter(); 
    	
        ConexionBD conexionBD = new ConexionBD();
    	Connection conexion = conexionBD.establecerConexion();

    	DaoUsuario daoUsuario = new DaoUsuario(conexion);
    	List<Usuario> listaUsuarios = daoUsuario.obtenerTodos();
		request.setAttribute("cuenta", daoUsuario.obtenerTodos()); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/home.jsp");
        dispatcher.forward(request, response);
    }
}
