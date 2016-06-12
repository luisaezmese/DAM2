package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Ventanas.Perfil;
import Juego.JugadorDB;
import Modelo.confDB;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	
	//Manejador de la BBDD
	private confDB db;
	private JugadorDB udb;
	
	//JCOMBOBOX de jugadores
	JComboBox comboBox;
	
	//Cerrar ventana login
	private Login cerrar;
	
	//Ventana Contenedor
	private Contenedor conten1;
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Login() {
		cerrar=this;
		
		
		//TITULO DE LA VENTANA
		setTitle("LOGIN");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//ETIQUETA USUARIO
		JLabel labelUsuario = new JLabel("USUARIO:");
		labelUsuario.setBounds(30, 24, 103, 16);
		contentPane.add(labelUsuario);
		
		//BOTON ENTRAR
		JButton botonEntrar = new JButton("ENTRAR");
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conten1= new Contenedor();//Creamos Contenedor
				conten1.setVisible(true);//Hacemos visible la ventana Contenedor
				p1.rellenaDatos(j1);//Rellenamos datos de Perfil
			}
		});
		botonEntrar.setBounds(142, 106, 97, 25);
		contentPane.add(botonEntrar);
		
		//BOTON REGITRAR NUEVO USUARIO
		JButton botonNuevoUsuario = new JButton("Registrar nuevo usuario");
		botonNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro ventanaRegistro = new Registro();
				ventanaRegistro.setVisible(true);
				cerrar.setVisible(false);
			}
		});
		botonNuevoUsuario.setBounds(102, 144, 185, 25);
		contentPane.add(botonNuevoUsuario);
		
		//LISTA USUARIOS JCOMBOBOX
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				j1= (Jugador)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(134, 21, 259, 22);
		contentPane.add(comboBox);
		
		
		
		
		//Conexión a la BBDD
		db = new confDB();
		db.conectar();
		udb = new JugadorDB(db.getConexion());
		
		//Añadimos todos los usuarios de la BBDD
		udb.buscarUsuario(comboBox);
		
	}
	
	Jugador j1 = new Jugador();
	Perfil p1 = new Perfil ();
}

