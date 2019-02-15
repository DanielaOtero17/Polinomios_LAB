package Interfaz;

 import javax.swing.*;
 import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class ButtonsPane extends JPanel implements ActionListener {

	private Principal V;
	private JButton clean, calculate, random;
	public final static  String CLEAN = "Limpiar";
	
	
	public ButtonsPane(Principal v) {
		
		V=v;
		clean = new JButton("Limpiar");
		calculate = new JButton("Calcular");
		random = new JButton("Generar Aleatorio");
		
		clean.setBackground(new Color(226, 33, 9));
		random.setBackground(new Color(226, 33, 9));
		calculate.setBackground(new Color(226, 33, 9));
		
		clean.setForeground(Color.white);
		random.setForeground(Color.white);
		calculate.setForeground(Color.white);
		
		clean.setFont(new Font("Arial Rounded MT Bold",15,15));
		calculate.setFont(new Font("Arial Rounded MT Bold",15,15));
		random.setFont(new Font("Arial Rounded MT Bold",15,15));
		
		clean.addActionListener(this);
		clean.setActionCommand("Limpiar");
		calculate.addActionListener(this);
		calculate.setActionCommand("Calcular");
		random.setActionCommand("Aleatorio");
		random.addActionListener(this);
		
		setLayout(new GridLayout(1,3));
		
		add(clean);
		add(random);
		add(calculate);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String g = e.getActionCommand();
		if(g.equals(CLEAN)) {
			V.cleanTextArea();
			System.out.println("hola");
			
		}else if(g.equals("Aleatorio")) {
			
			V.getRandom();
			
		}else if(g.equals("Calcular")) {
			
			try {
				V.calculate();
			} catch (HeadlessException | IOException e1) {
				
				e1.printStackTrace();
			}
		}
			
		
	}
	
	
	
}
