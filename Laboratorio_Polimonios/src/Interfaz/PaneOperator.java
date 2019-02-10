package Interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PaneOperator extends JPanel implements ActionListener{

	private JButton insert;
	private Principal V;
	
	public PaneOperator (Principal v) {
	
		V=v;
		
		insert= new JButton("Insertar");
		insert.setFont(new Font("Arial Rounded MT Bold", 15,15));
		insert.setBackground(Color.WHITE);
		
		add(insert);
		
		
		
	//	insert.setBorder(BorderFactory.createLineBorder(Color.RED));
        insert.setBorder(new LineBorder(Color.RED));

		
		
		insert.addActionListener(this);
		insert.setActionCommand("insertar");
	}

	
	public JButton getInsert() {
		return insert;
	}


	public void setInsert(JButton insert) {
		this.insert = insert;
	}


	public Principal getV() {
		return V;
	}


	public void setV(Principal v) {
		V = v;
	}


	@Override
	public void actionPerformed(ActionEvent g) {
	
		String e = g.getActionCommand();
		
		if(e.equalsIgnoreCase("insertar")){
			
			V.getInformation();
		}
		
	}
	
}
