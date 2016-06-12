package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.JugadorDB;
import Modelo.confDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Definición de la clase mediante la palabra reservada Jugador 
 **/
public class Registro extends JFrame{
	
	
	//PROPIEDADES	
	private JPanel contentPane;
	JTextField textoNombre;
	JTextField textoApellido1;
	JTextField textoApellido2;
	JTextField textoEdad;
	//Creamos la referencia a Juego
	private Contenedor conten1;
	//Creamos la referencia a Login
	private Registro cerrar;
	
	//Manejador de la BBDD
	private confDB db;
	private JugadorDB udb;
	
	JButton botonDatos;

	
	
	// Constructor
	// Punto de entrada que se ejecuta al crear un objeto de tipo Juagador
	public Registro() {
			
		//Hacemos referencia cerrar
			cerrar=this;
		
		
		//Las propiedades de nuestra ventana
				setTitle("JUGADOR");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//Dimensiones de nuestra ventana		
				setBounds(100, 100, 450, 384);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		//Lo añadimos al JFrame		
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
		//Añadimos la etiqueta Título		
				JLabel etiquetaTitulo = new JLabel("DATOS DEL JUGADOR");
				etiquetaTitulo.setBounds(12, 13, 140, 16);
				contentPane.add(etiquetaTitulo);
				
		//Añadimos la etiqueta Nombre
				JLabel etiquetaNombre = new JLabel("Nombre");
				etiquetaNombre.setBounds(12, 61, 140, 16);
				contentPane.add(etiquetaNombre);
				
		//Añadimos la etiqueta Apellido1
				JLabel etiquetasApellido1 = new JLabel("Apellido1");
				etiquetasApellido1.setBounds(12, 108, 72, 16);
				contentPane.add(etiquetasApellido1);
				
		//Añadimos la etiqueta Apellido2
				JLabel etiquetasApellido2 = new JLabel("Apellido2");
				etiquetasApellido2.setBounds(12, 156, 72, 16);
				contentPane.add(etiquetasApellido2);
		
		//Añadimos la etiqueta Edad
				JLabel etiquetaEdad = new JLabel("Edad");
				etiquetaEdad.setBounds(12, 203, 72, 16);
				contentPane.add(etiquetaEdad);
				
		//Añadimos cuadro de texto Nombre
				textoNombre = new JTextField();
				textoNombre.setBounds(81, 58, 226, 22);
				contentPane.add(textoNombre);
				textoNombre.setColumns(10);
				
		//Añadimos cuadro de texto Apellidos1	
				textoApellido1 = new JTextField();
				textoApellido1.setColumns(10);
				textoApellido1.setBounds(81, 105, 226, 22);
				contentPane.add(textoApellido1);
				

		//Añadimos cuadro de texto Apellidos1					
				textoApellido2 = new JTextField();
				textoApellido2.setColumns(10);
				textoApellido2.setBounds(81, 153, 226, 22);
				contentPane.add(textoApellido2);
				
		//Añadimos cuadro de texto Edad		
				textoEdad = new JTextField();
				textoEdad.setColumns(10);
				textoEdad.setBounds(81, 200, 226, 22);
				contentPane.add(textoEdad);
		
		//Añadimos caja de texto Datos
				JTextArea textoDatos = new JTextArea();
				textoDatos.setBounds(12, 273, 408, 51);
				contentPane.add(textoDatos);
				
		//Añadimos botón de Datos
				botonDatos = new JButton("A JUGAR");
		//Evento addActionListener		
				botonDatos.addActionListener(new ActionListener() {
		//Acción del evento			
					public void actionPerformed(ActionEvent arg0) {
						
						if ((textoNombre.getText().length()==0)||(textoApellido1.getText().length()==0)||(textoApellido2.getText().length()==0)||(textoEdad.getText().length()==0)) {//comparamos si las cajas de texto están vacias
						
						textoDatos.setText("Algún campo por rellenar");
						
						}else{
							
							
							conten1=new Contenedor();
							
							//Insertamos los datos en la BBDD
							udb.insertarUsuario(textoNombre.getText(),textoApellido1.getText(),textoApellido2.getText(),Integer.valueOf(textoEdad.getText()));
							
					
							//Cerramos la ventana Login
							cerrar.setVisible(false);
							//Abrimos la ventana Juego
							conten1.setVisible(true);	
							
							//Enviamos los  datos a Perfil
							Perfil.CajaNombre.setText(textoNombre.getText());
							Perfil.CajaApellido1.setText(textoApellido1.getText());
							Perfil.CajaApellido2.setText(textoApellido2.getText());
							Perfil.CajaEdad.setText(textoEdad.getText());
							
							
						}
					}
				});
				botonDatos.setBounds(12, 235, 408, 25);
				contentPane.add(botonDatos);
			
			//Conexión a la BBDD
			db = new confDB();
			textoDatos.setText(db.conectar());
			udb = new JugadorDB(db.getConexion());
			
			
			
		
	}
	
}