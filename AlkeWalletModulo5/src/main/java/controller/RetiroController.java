package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionBD.ConexionBD;
import dao.DaoUsuario;

@WebServlet("/RetiroController")
public class RetiroController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ConexionBD conexionBD = new ConexionBD();
    	Connection conexion = conexionBD.establecerConexion();

    	DaoUsuario daoUsuario = new DaoUsuario(conexion);
    	request.setAttribute("saldo", daoUsuario.retiroFondos(0));
    	
    	System.out.println(daoUsuario.retiroFondos(0)); 			
		
		RequestDispatcher rd=request.getRequestDispatcher("vistas/home.jsp");  
        rd.forward(request, response);  		
        
	}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }
    
}
