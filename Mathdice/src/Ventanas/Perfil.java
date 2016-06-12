package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import Ventanas.Registro;
import Juego.Jugador;
import Juego.JugadorDB;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Perfil extends JPanel {
	static JTextField CajaApellido1;
	static JTextField CajaEdad;
	static JTextField CajaApellido2;
	static JTextField CajaNombre;
	JLabel imagenPerfil;

	/**
	 * Create the panel.
	 */
	public Perfil() {
		setLayout(null);
		
	
		
		//ETIQUETA NOMBRE
		JLabel EtiquetaNombre = new JLabel("Nombre");
		EtiquetaNombre.setBounds(306, 24, 56, 16);
		add(EtiquetaNombre);
		//CAJA NOMNBRE
		CajaNombre = new JTextField();
		CajaNombre.setEditable(false);
		CajaNombre.setColumns(10);
		CajaNombre.setBounds(306, 42, 116, 22);
		add(CajaNombre);
		
		//ETIQUETA 1er APELLIDO
		JLabel EtiquetaApellido1 = new JLabel("1er Apellido");
		EtiquetaApellido1.setBounds(306, 77, 80, 16);
		add(EtiquetaApellido1);
		//CAJA 1er APELLIDO
		CajaApellido1 = new JTextField();
		CajaApellido1.setEditable(false);
		CajaApellido1.setColumns(10);
		CajaApellido1.setBounds(306, 95, 116, 22);
		add(CajaApellido1);
		
		//ETIQUETA 2º APELLIDO
		JLabel EtiquetaApellido2 = new JLabel("2\u00BA Apellido");
		EtiquetaApellido2.setBounds(444, 77, 80, 16);
		add(EtiquetaApellido2);
		//CAJA 2º APELLIDO
		CajaApellido2 = new JTextField();
		CajaApellido2.setEditable(false);
		CajaApellido2.setColumns(10);
		CajaApellido2.setBounds(444, 95, 116, 22);
		add(CajaApellido2);
		
	
		//ETIQUETA EDAD
		JLabel EtiquetaEdad = new JLabel("Edad");
		EtiquetaEdad.setBounds(306, 145, 56, 16);
		add(EtiquetaEdad);
		//CAJA EDAD
		CajaEdad = new JTextField();
		CajaEdad.setEditable(false);
		CajaEdad.setColumns(10);
		CajaEdad.setBounds(306, 163, 116, 22);
		add(CajaEdad);
		
		imagenPerfil = new JLabel();
		try{
		ImageIcon imagen= new ImageIcon(getClass().getResource("img/hombre1.jpg"));
		imagenPerfil.setIcon(imagen);
		}catch(Exception e){
		System.out.println("La imagen no existe");
		e.printStackTrace();
		}
		imagenPerfil.setBounds(38, 45, 200, 216);
		add(imagenPerfil);
		
		
		
	}
	public void rellenaDatos(Jugador j1){
		
		CajaNombre.setText(j1.getNombre());
		CajaApellido1.setText(j1.getApellido1());
		CajaApellido2.setText(j1.getApellido2());
		CajaEdad.setText(String.valueOf(j1.getEdad()));
	
	}
	
}
