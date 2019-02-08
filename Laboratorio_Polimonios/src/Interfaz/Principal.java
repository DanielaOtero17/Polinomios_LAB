package Interfaz;

import java.awt.*;

import javax.swing.*;


public class Principal extends JFrame {
	
	
	private ButtonsPane buttons;
	private PaneOperator operator;
	private JTextField zeros;
	
	public Principal(){
		
		buttons = new ButtonsPane(this);
		operator = new PaneOperator(this);
		zeros = new JTextField("Ceros Poliómicos");
	
	zeros.setPreferredSize(new Dimension(300,100));
		zeros.setEnabled(false);

		setSize(600,200);
		setResizable(false);
		setTitle("LABORATORIO ******* AED ****** POLINOMIOS ****** BIENVENIDO");
		setLayout(new BorderLayout());
		
		add(buttons,BorderLayout.SOUTH);
		add(operator,BorderLayout.EAST);
		add(zeros,BorderLayout.CENTER);
		
		pack();
	}
	
	public static void main(String []args){
		
		Principal main = new Principal();
		main.setVisible(true);
		
	}

}
