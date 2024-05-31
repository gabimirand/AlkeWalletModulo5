package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionBD.ConexionBD;
import dao.DaoUsuario;

@WebServlet("/SaldoController")
public class SaldoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        
        ConexionBD conexionBD = new ConexionBD();
    	Connection conexion = conexionBD.establecerConexion();
    	
    	DaoUsuario daoUsuario = new DaoUsuario(conexion);
    	request.setAttribute("saldo", daoUsuario.consultaSaldo());
    	
    	System.out.println(daoUsuario.consultaSaldo()); 			
		
		RequestDispatcher rd=request.getRequestDispatcher("vistas/saldo.jsp");  
        rd.forward(request, response);  		
        
	}
	


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {         
                
     ServletResponse response = null;
			// TODO Auto-generated method stub
     		response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
             
             
             ConexionBD conexionBD = new ConexionBD();
         	Connection conexion = conexionBD.establecerConexion();
         	
         	
         	DaoUsuario selectQuery= new DaoUsuario(conexion);
            selectQuery.consultaSaldo();
         	
         	
     		DaoUsuario DaoUsuario = new DaoUsuario(conexion);
     		ServletRequest request = null;
			request.setAttribute("saldo", DaoUsuario.consultaSaldo());  
     		
	    	System.out.println(DaoUsuario.consultaSaldo()); 			

             //request.setAttribute("run",misession.getAttribute("run"));  
     		// se redirige a la pantalla listado
     		RequestDispatcher rd=request.getRequestDispatcher("vistas/saldo.jsp");  
             rd.forward(request, response);  
     	}
}


