
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author acer
 */
public class Calc extends JFrame implements ActionListener {
	JTextField txt[];
	JRadioButton btn[];
	JButton b;
	Container c;

	public Calc() {
		super();
		// set JFRame attriubets
		{
			c = getContentPane();
			c.setLayout(null);
			setBounds(20, 20, 400, 450);

		}
		JLabel lbl[] = new JLabel[3];
		txt = new JTextField[3];
		String str[] = { "First number ", "Second number ", "Result" };
		// initaizlition
		{
			for (int i = 0; i < 3; i++) {
				lbl[i] = new JLabel(str[i]);
				lbl[i].setSize(160, 60);
				txt[i] = new JTextField();
				txt[i].setSize(150, 30);
			}
			int y = 55;
			for (JTextField t : txt) {
				t.setLocation(200, y);
				y += 60;
				c.add(t);
			}
			y = 40;
			for (JLabel t : lbl) {
				t.setLocation(40, y);
				y += 60;
				c.add(t);
			}
			txt[2].setEditable(false);

		}
		JPanel pact = new JPanel();
		pact.setBounds(30, 240, 320, 80);
		pact.setBorder(BorderFactory.createTitledBorder("Operation"));

		btn = new JRadioButton[4];
		String s[] = { "add", "Sub", "Div", "Multi" };

		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < 4; i++) {
			btn[i] = new JRadioButton(s[i]);
			bg.add(btn[i]);
			pact.add(btn[i]);
		}
		b = new JButton("Calulate");
		b.addActionListener(this);
		b.setBounds(30, 340, 320, 40);

		c.add(b);
		c.add(pact);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b) {
				
				if(txt[0].getText().isEmpty() || txt[1].getText().isEmpty())
					return;
				int x = Integer.parseInt(txt[0].getText());
				int y = Integer.parseInt(txt[1].getText());
				

				for (int i = 0; i < 4; i++) {
					if (btn[i].isSelected()) {
						int z = 0;
						if (btn[i].getText().equals("add")) {
							z = x + y;
						}
						if (btn[i].getText().equals("Sub")) {
							z = x - y;
						}
						if (btn[i].getText().equals("Div")) {
							try {
								z = x / y;
							} catch (ArithmeticException ex) {
								JOptionPane.showMessageDialog(null, "no div by zreo");
							}

						}
						if (btn[i].getText().equals("Multi")) {
							z = x * y;
						}
						txt[2].setText(z + "");
					}
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		// catch (ArithmeticException ex) {
		// JOptionPane.showMessageDialog(null, "no div by zreo");
		// }

	}

}
