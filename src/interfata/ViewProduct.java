package interfata;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.StudentDAO;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ViewProduct  extends Frame implements ActionListener  {
	int iesire=0;
	public JFrame frame;
	 DefaultTableModel model = new DefaultTableModel();
	    JTable jtbl = new JTable(model);
	JPanel p = new JPanel(); 
	JPanel p1 = new JPanel(); 
	JPanel p2 = new JPanel(); 
	JPanel p3 = new JPanel(); 	   
	JPanel p4 = new JPanel(); 
	JPanel p5 = new JPanel(); 
	JButton adunareClient = new JButton("Gaseste produsul ");
	JButton afisareClienti = new JButton("Afiseaza produsele ");
	JButton inserareClient = new JButton("Insereaza produs ");
	JButton stergereClient = new JButton("Stergere produs ");
	JButton editareClient = new JButton("editare produs ");
	JTextField idClientt = new JTextField(5);
	JTextField idClientSters = new JTextField(5);
	JTextField afisClientt = new JTextField(25);
	JTextField nameClient = new JTextField(20);
	JTextField addressClient = new JTextField(10);
	JTextField emailClient = new JTextField(20);
	JTextField ageClient = new JTextField(5);
	
	JTextField idClientEdit = new JTextField(5);
	JTextField nameClientEdit = new JTextField(10);
	JTextField adresClientEdit = new JTextField(15);
	JTextField emailClientEdit = new JTextField(15);
	JTextField ageClientEdit = new JTextField(5);
	

   public ViewProduct() {
	   Container cnt = this.getContentPane();
	   frame = new JFrame ("Polinom"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   

	//panou4
	   p4.add(adunareClient);
	   p4.add(idClientt);
	   p1.add(stergereClient);
	   p1.add(idClientSters);
	   p3.add(afisareClienti);
	   p2.add(inserareClient);
	   p2.add(nameClient);
	   p2.add(addressClient);
	   p2.add(emailClient);
	   p5.add(idClientEdit);
	   p5.add(nameClientEdit);
	   p5.add(adresClientEdit);
	   p5.add(ageClientEdit);
	   p5.add( editareClient);
	   p5.add(p1);
	   p.add(p1);
	   p.add(p2);
	   p.add(p3);
	   p.add(p4);
	   p.add(p5);
	   editareClient.addActionListener(this);
	   adunareClient.addActionListener(this);
	   inserareClient.addActionListener(this);
	   afisareClienti.addActionListener(this);
	   stergereClient.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }


private Container getContentPane() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void actionPerformed(ActionEvent evt) {
	// TODO Auto-generated method stub
	if(evt.getSource()==adunareClient)
	{
		int i=Integer.parseInt(idClientt.getText());
		//System.out.println(i);
		TabelProdus t1=new TabelProdus(i);
		
	}
	if(evt.getSource()==afisareClienti)
	{
		//System.out.println(i);
		//Tabel t2=new Tabel();
		TabelProdus t1=new TabelProdus();
	}
	if(evt.getSource()==inserareClient)
	{
		String s1=nameClient.getText();
		int s2=Integer.parseInt(addressClient.getText());
		int s3=Integer.parseInt(emailClient.getText());
		//String s3=emailClient.getText();
		
		//System.out.println(i);
		//Tabel t2=new Tabel();
		TabelProdus t1=new TabelProdus(s1,s2,s3);
	}
	if(evt.getSource()==stergereClient)
	{
		int i=Integer.parseInt(idClientSters.getText());
		TabelProdus t2=new TabelProdus(i,0);
	}
	if(evt.getSource()==editareClient)
	{
		int i1=Integer.parseInt(idClientEdit.getText());
		String s1=nameClientEdit.getText();
		int i2=Integer.parseInt(adresClientEdit.getText());
		int i3=Integer.parseInt(ageClientEdit.getText());
		TabelProdus t2=new TabelProdus(s1,i2,i3,i1);
	}
}
}