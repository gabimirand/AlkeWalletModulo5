package controller;

import java.sql.Connection;
import java.util.Scanner;

import conexionBD.ConexionBD;
import dao.DaoUsuario;
import model.Usuario;


public class MainWallet {
    public static void main(String[] args) {
    	ConexionBD conexionBD = new ConexionBD();
    	Connection conexion = conexionBD.establecerConexion();
    	    	
    	int accion = 0;
    	
        Scanner scanner = new Scanner(System.in);
        while (accion != 4)
        {
	        System.out.print("Introduce:  1 - Saldo. | 2- Realizar depósito. | 3- Retiro de fondos. | 4- Salir. ");
	        accion = scanner.nextInt();
	        
	        if (accion == 1) {
		        if (conexion != null) {
		        	  DaoUsuario selectQuery= new DaoUsuario(conexion);
		          	  System.out.println("--------------------- Consulta de Saldo ------------------------");
		              selectQuery.consultaSaldo();
		          	  System.out.println("----------------------------------------------------------------------");
		        }
		        accion = 0;
	        }else if(accion == 2) {	        	
	        	  DaoUsuario selectQuery= new DaoUsuario(conexion);
	          	  System.out.println("--------------------- Depósito ------------------------");
	        	  System.out.print("Ingrese la cantidad a depositar en tu cuenta: ");
                  double cantidadDepositar = scanner.nextDouble();
	        	  selectQuery.realizarDeposito(cantidadDepositar);
	          	  System.out.println("¡DEPÓSITO REALIZADO CON ÉXITO! Se ha depositado $" + cantidadDepositar);
	              selectQuery.consultaSaldo();
	          	  System.out.println("----------------------------------------------------------------------");
	        }else if(accion == 3) {	        	
	        	  DaoUsuario selectQuery= new DaoUsuario(conexion);
	          	  System.out.println("--------------------- Giro ------------------------");
	        	  System.out.print("Ingrese la cantidad a retirar de tu cuenta: ");
                double cantidadRetiro = scanner.nextDouble();
	        	  selectQuery.retiroFondos(cantidadRetiro);
	          	  System.out.println("¡DEPÓSITO REALIZADO CON ÉXITO! Se ha depositado $" + cantidadRetiro);
	              selectQuery.consultaSaldo();
	          	  System.out.println("----------------------------------------------------------------------");
	        }else if(accion == 4) {
	        	System.out.print("¡Adiós!");
		    }
        }
    }
    
}
