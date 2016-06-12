package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Juego.JugadorDB;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Juego extends JPanel{
	
	private JPanel contentPane;
	boolean comprobar = true; //para comprobar si se introduce número o signo +-
	private String a;// para enviar a la caja de texto cada número pulsado
	int contador=0;
	int operador; //Para controlar si es suma o resta
	int total=0; // Acumulado de las operaciones
	int aleverde1; //Almacenamos el número del dado1
	int alerojo1;//Almacenamos el número del dado2
	int alerojo2;//Almacenamos el número del dado3
	int alerojo3;//Almacenamos el número del dado4
	int aleazul1;//Almacenamos el número del dado5
	int aleazul2;//Almacenamos el número del dado6
	
	
	//Declaramos los arrays para las imágenes
	private ImageIcon[] dados3=new ImageIcon[3];//Dados del 1 al 3
	private ImageIcon[] dados6=new ImageIcon[6];//Dados del 1 al 6
	private ImageIcon[] dados12=new ImageIcon[12];//Dados del 1 al 12
	private ImageIcon dadogris; //Dado para sustituir cada vez que se realiza click en un dado
	
	
	//Declaramos el elemento generador de número pseudoaleatorios
	private Random aleatorio= new Random();
	
	
	//Etiquetas imagenes
	private JLabel labeldado1_rojo;
	private JLabel labeldado2_rojo;
	private JLabel labeldado3_rojo;
	private JLabel labeldado1_azul;
	private JLabel labeldado2_azul;
	private JLabel labeldado1_verde;
	
	//Etiqueta Saludo
	private JLabel etiquetaSaludo;
	
	//Caja texto del resultado
	private JTextField etiquetaoperaciones;
	
	//Etiqueta resultado
	private JLabel etiquetaresultado;
	
	//Boton repetir
	private JButton botonrepetir;
	
	//Botones de control
	private JButton botonsumar,botonrestar,botonMathdice;
	
	
	
	/**
	 * Create the frame.
	 */
	
	public Juego() {

		setLayout(null);
		
		//Etiqueta Saludo
		etiquetaSaludo = new JLabel();
		etiquetaSaludo.setText("BIENVENID@ AL JUEGO");
		etiquetaSaludo.setBounds(550, 13, 258, 16);
		add(etiquetaSaludo);

		//Etiqueta texto donde se introducen las sumas y restas
		etiquetaoperaciones = new JTextField();
		etiquetaoperaciones.setEditable(false);
		etiquetaoperaciones.setFont(new Font("Stencil", Font.PLAIN, 25));
		etiquetaoperaciones.setBounds(907, 208, 481, 76);
		add(etiquetaoperaciones);
		etiquetaoperaciones.setColumns(10);
		
		
		
		//Botón para SUMAR
		JButton botonsumar = new JButton("+");
		botonsumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comprobar==false){//para comprobar si el anterior es signo o número
				enviartexto("+");// volvemos a cambiar la variable
				operador=1;
				comprobar=true;
				}//if comprobar
			}
			
		});
		botonsumar.setFont(new Font("Stencil", Font.PLAIN, 25));
		botonsumar.setBounds(907, 91, 154, 104);
		add(botonsumar);
		
		
		
		//Botón para RESTAR
		JButton botonrestar = new JButton("-");
		botonrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobar==false){//para comprobar si el anterior es signo o número
				enviartexto("-");
				operador=0;
				comprobar=true;// volvemos a cambiar la variable
				}//if comprobar
			}
		});
		botonrestar.setFont(new Font("Stencil", Font.PLAIN, 25));
		botonrestar.setBounds(1234, 91, 154, 104);
		add(botonrestar);
		
		
		
		//Etiqueta para mostrar el resultado de las operaciones
		etiquetaresultado = new JLabel("");
		etiquetaresultado.setFont(new Font("Tahoma", Font.BOLD, 30));
		etiquetaresultado.setEnabled(false);
		etiquetaresultado.setBounds(907, 414, 494, 50);
		add(etiquetaresultado);
		
		//Cargamos las imagenes en los arrays
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_rojo.png"));
		}
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_azul.png"));
		}
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_verde.png"));
		}
		
	
	//Imagen gris para desactivar dado
			ImageIcon dadogris =new ImageIcon(getClass().getResource("img/dadogris.png"));
	
	//Etiquetas de las imagenes DADO ROJO del 1 al 3
			labeldado1_rojo = new JLabel();
			alerojo1= aleatorio.nextInt(3);// número aleatorio para el dado1 rojo	
			labeldado1_rojo.setIcon(dados3[alerojo1]);//pasamos la imagen correspondiente a la etiqueta dado 1 rojo
			labeldado1_rojo.setBounds(50, 50, 200, 200);
			add(labeldado1_rojo);
			
			
			labeldado2_rojo = new JLabel();
			alerojo2= aleatorio.nextInt(3);// número aleatorio para el dado2 rojo	
			labeldado2_rojo.setIcon(dados3[alerojo2]);//pasamos la imagen correspondiente a la etiqueta dado 2 rojo
			labeldado2_rojo.setBounds(300, 50, 200, 200);
			add(labeldado2_rojo);
			
			
			labeldado3_rojo = new JLabel();
			alerojo3= aleatorio.nextInt(3);// número aleatorio para el dado3 rojo	
			labeldado3_rojo.setIcon(dados3[alerojo3]);//pasamos la imagen correspondiente a la etiqueta dado 3 rojo
			labeldado3_rojo.setBounds(550, 50, 200, 200);
			add(labeldado3_rojo);
			
			
			
			//Etiquetas de las imagenes DADO AZUL del 1 al 6
			labeldado1_azul = new JLabel();
			aleazul1= aleatorio.nextInt(6);// número aleatorio para el dado1 azul	
			labeldado1_azul.setIcon(dados6[aleazul1]);//pasamos la imagen correspondiente a la etiqueta dado 1 azul
			labeldado1_azul.setBounds(50, 300, 200, 200);
			add(labeldado1_azul);
			
			
			labeldado2_azul = new JLabel();
			aleazul2= aleatorio.nextInt(6);// número aleatorio para el dado2 azul	
			labeldado2_azul.setIcon(dados6[aleazul2]);//pasamos la imagen correspondiente a la etiqueta dado 2 azul
			labeldado2_azul.setBounds(300, 300, 200, 200);
			add(labeldado2_azul);
			
			
			//Etiqueta de las imagenes DADO VERDE del 1 al 12
			labeldado1_verde = new JLabel();
			aleverde1= aleatorio.nextInt(12);// número aleatorio para el dado1 verde	
			labeldado1_verde.setIcon(dados12[aleverde1]);//pasamos la imagen correspondiente a la etiqueta dado 1 verde
			labeldado1_verde.setBounds(50,550,200, 200);
			add(labeldado1_verde);
		
		

		
				
				//Listener para el boton_Math Dice
				JButton botonMathdice = new JButton("MATHDICE");
				botonMathdice.addMouseListener(
						new MouseAdapter(){
							@Override
							public void mouseClicked(MouseEvent arg0){
								if(contador>1){
								String stringtotal = String.valueOf(total);
								etiquetaresultado.setText(stringtotal);
								botonrepetir.setEnabled(true);
								if (total==aleverde1+1){
									etiquetaresultado.setText("El resultado es "+stringtotal+" HAS GANADO");
								}
								
								else {
									etiquetaresultado.setText("INCORRECTO");
								}
							}
						}
					}
						
					);
				botonMathdice.setFont(new Font("Stencil", Font.PLAIN, 25));
				botonMathdice.setBounds(907, 325, 494, 76);
				add(botonMathdice);
				
				
				
				//Listener para el boton_REPETIR
				botonrepetir = new JButton("REPETIR");
				botonrepetir.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								inicializarBotones();
								botonrepetir.setEnabled(false);
							}
						
					});
				botonrepetir.setFont(new Font("Tahoma", Font.BOLD, 16));
				botonrepetir.setBounds(907, 562, 484, 59);
				add(botonrepetir);
				
				inicializarBotones();	
		
	}
	
	public void enviartexto (String a){
		
		etiquetaoperaciones.setText(etiquetaoperaciones.getText()+a);
			
	}
	
	//Metodo para realizar el cálculo
	public void calculo (int c, int cont){
		int suma=0;
		int resta=0;
		if (cont>1){
			if (operador==1){//Si operador es 1 es SUMA
				suma=total+c;
				total=suma;
			}else if(operador==0){//Si operador es 0 es RESTA
				resta=total-c;
				total=resta;
			}
			
		}else{
			
			total=c;}
		
		
		
	}
	
	public void inicializarBotones(){
		
		//Cargamos las imagenes en los arrays
			for(int i=0;i<dados3.length;i++){
				dados3[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_rojo.png"));
			}
			for(int i=0;i<dados6.length;i++){
				dados6[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_azul.png"));
			}
			for(int i=0;i<dados12.length;i++){
				dados12[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_verde.png"));
			}
			
		
		//Imagen gris para desactivar dado
				ImageIcon dadogris =new ImageIcon(getClass().getResource("img/dadogris.png"));
		
		//Etiquetas de las imagenes DADO ROJO del 1 al 3
				
				alerojo1= aleatorio.nextInt(3);// número aleatorio para el dado1 rojo	
				labeldado1_rojo.setIcon(dados3[alerojo1]);//pasamos la imagen correspondiente a la etiqueta dado 1 rojo
				String alearojo1string=String.valueOf(alerojo1);
				labeldado1_rojo.setName(alearojo1string);
				labeldado1_rojo.addMouseListener(new ListenerDados());
				
				alerojo2= aleatorio.nextInt(3);// número aleatorio para el dado2 rojo	
				labeldado2_rojo.setIcon(dados3[alerojo2]);//pasamos la imagen correspondiente a la etiqueta dado 2 rojo
				String alearojo2string=String.valueOf(alerojo2);
				labeldado2_rojo.setName(alearojo2string);
				labeldado2_rojo.addMouseListener(new ListenerDados());
				
				alerojo3= aleatorio.nextInt(3);// número aleatorio para el dado3 rojo	
				labeldado3_rojo.setIcon(dados3[alerojo3]);//pasamos la imagen correspondiente a la etiqueta dado 3 rojo
				String alearojo3string=String.valueOf(alerojo3);
				labeldado3_rojo.setName(alearojo3string);
				labeldado3_rojo.addMouseListener(new ListenerDados());
				
				//Etiquetas de las imagenes DADO AZUL del 1 al 6
			
				aleazul1= aleatorio.nextInt(6);// número aleatorio para el dado1 azul	
				labeldado1_azul.setIcon(dados6[aleazul1]);//pasamos la imagen correspondiente a la etiqueta dado 1 azul
				String aleazul1string=String.valueOf(aleazul1);
				labeldado1_azul.setName(aleazul1string);
				labeldado1_azul.addMouseListener(new ListenerDados());
				
				aleazul2= aleatorio.nextInt(6);// número aleatorio para el dado2 azul	
				labeldado2_azul.setIcon(dados6[aleazul2]);//pasamos la imagen correspondiente a la etiqueta dado 2 azul
				String aleazul2string=String.valueOf(aleazul2);
				labeldado2_azul.setName(aleazul2string);
				labeldado2_azul.addMouseListener(new ListenerDados());
				
				//Etiqueta de las imagenes DADO VERDE del 1 al 12
				
				aleverde1= aleatorio.nextInt(12);// número aleatorio para el dado1 verde	
				labeldado1_verde.setIcon(dados12[aleverde1]);//pasamos la imagen correspondiente a la etiqueta dado 1 verde
				

				
				//RESETEO VALORES
				comprobar = true; //para comprobar si se introduce número o signo +-
				contador=0;
				etiquetaoperaciones.setText("");
				etiquetaresultado.setText("");
				total=0; // Acumulado de las operaciones
		
			
	}
	
		
	
				//Implementación MouseListener a traves de Inner Class
				//CADA VEZ QUE SE REALIZA CLICK EN UN DADO
					private class ListenerDados implements MouseListener{

						@Override
						public void mouseClicked(MouseEvent e) {
							JLabel dado = (JLabel) e.getSource();
							int numeroDado=Integer.valueOf(dado.getName());
							if(comprobar==true){//para comprobar si el anterior es signo o número
								String dadostring = String.valueOf(numeroDado+1);
								a = dadostring;
								enviartexto(a);
								dado.removeMouseListener(this);
								dado.setIcon(dadogris);
								contador=contador+1;
								calculo(numeroDado+1,contador);
								comprobar=false;// volvemos a cambiar la variable
								}//if comprobar
							
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
		
		}

								
}

	