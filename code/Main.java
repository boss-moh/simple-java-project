import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	Container c ;
	JButton btn ;
	JComboBox<String> selecter ;
	Clicker click = new Clicker() ;
	boolean b1 , b2;
	JFrame f1,f2;
	
	public Main()
	{
		super();
		
		// set of Jframe
		{

			setBounds(100, 200, 300, 300);
			c= getContentPane();
			setLayout(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);

			
		}
		// setter of combobox
		{
			selecter = new JComboBox<String>();
			selecter.setBounds(50, 100, 120, 30);
			selecter.addItem("Calculator");
			selecter.addItem("Metric converter");
		}
		// button
		{
			btn = new JButton("go");
			btn.setBounds(180, 100, 80, 30);
			btn.addActionListener(click);
		}
		
		//add
		{

			c.add(btn);
			c.add(selecter);
			
		}
		setVisible(true);
	}
	
	class Clicker implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String str = (String)selecter.getSelectedItem();
			if(str.equals("Calculator"))
			{
				if(!b1)
				{
					f1 = new Calc();
					b1 = true;
				}
				else {
					f1.setVisible(true);
				}
			}
			
			else
			{
				if(!b2)
				{
					f2 = new Converter("Converter");
					b2 = true;
				}
				else {
					f2.setVisible(true);
				}
			}
			
		}
		
	}
}
