package Juego;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import Modelo.confDB;
import Ventanas.Perfil;
import Ventanas.Registro;
import Ventanas.Juego;


/*
 * Definición de la clase mediante la palabra reservada Jugador 
 **/
public class JugadorDB{
	
	
	// Constructor
	// Punto de entrada que se ejecuta al crear un objeto de tipo Juagador
	//Conexion a la base de datos
		private Connection conexion;
		private Statement orden = null;
		private confDB con;
		
		public JugadorDB(Connection c) {
			this.conexion=c;
		}
		
		//Método que permite insertar un usuario en la base de datos
		public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad){
			try{
				
				orden = conexion.createStatement();
			    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad) " +
			                   "VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")";
			    orden.executeUpdate(sql);
			    System.out.println("Usuario registrado con exito");
			   }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
			   }catch(Exception e){
				      //Se produce cualquier otro error
				   System.out.println("EL ERROR ESTÁ AQUÍ");
				      e.printStackTrace();
			   }finally{
				      //Cerramos los recursos
				      try{
				         if(orden!=null)
				        	 conexion.close();
				      }catch(SQLException se){
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				}//end try
			
			
			
		}
		
		//Método que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
				public void buscarUsuario(JComboBox jc){
					ResultSet rs;
					try{
					  orden = conexion.createStatement();
				      String sql = "SELECT id, nombre, apellido1, apellido2, edad FROM usuarios";
				      rs = orden.executeQuery(sql);
				      //Cogemos los usuarios
				      while(rs.next()){
				    	  Jugador u=new Jugador();
				    	  u.setId(rs.getInt("id"));
					      u.setNombre(rs.getString("nombre"));
					      u.setApellido1(rs.getString("apellido1"));
					      u.setApellido2(rs.getString("apellido2"));
					      u.setEdad(rs.getInt("edad"));
					      jc.addItem(u);
				      }
				      
				      //Debemos cerrar la conexion
				      rs.close();
					}catch(SQLException se){
						      //Se produce un error con la consulta
						      se.printStackTrace();
					}catch(Exception e){
						      //Se produce cualquier otro error
						      e.printStackTrace();
					}finally{
					      //Cerramos los recursos
					      try{
					         if(orden!=null)
					        	 conexion.close();
					      }catch(SQLException se){
					      }
					      try{
					         if(conexion!=null)
					        	 conexion.close();
					      	 }catch(SQLException se){
					         se.printStackTrace();
					      	 }//end finally try
					}
					
				}
				
				

}