package interfata;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller extends Frame implements ActionListener {
	int iesire=0;
	public JFrame frame;
	JPanel p = new JPanel(); 
	JPanel p1 = new JPanel(); 
	JPanel p2 = new JPanel(); 
	JPanel p3 = new JPanel(); 	   
	JPanel p4 = new JPanel(); 
	JButton client = new JButton("student ");
	JButton produs = new JButton("produs ");
	JButton order = new JButton("order ");


   public Controller() {
	   frame = new JFrame ("Polinom"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   

	//panou4
	   p2.add(order);
	   p4.add(client);
	   p3.add(produs);
	   p.add(p1);
	   p.add(p2);
	   p.add(p3);
	   p.add(p4);
	   order.addActionListener(this);
	   client.addActionListener(this);
	   produs.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }

@Override
public void actionPerformed(ActionEvent evt) {
	// TODO Auto-generated method stub
	if(evt.getSource()==client)
	{
		View v1=new View();
	}
	if(evt.getSource()==produs)
	{
		ViewProduct v1=new ViewProduct();
	}
	if(evt.getSource()==order)
	{
		ViewOrder v1=new ViewOrder();
	}
}
}