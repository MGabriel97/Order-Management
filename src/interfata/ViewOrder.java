package interfata;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.table.DefaultTableModel;

import dao.ProductDAO;
import dao.ProdusDAO;
import dao.StudentDAO;
import model.Order;
import model.Product;
import model.Student;

import javax.print.Doc;
import javax.print.DocPrintJob;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ViewOrder   extends Frame implements ActionListener   {
	public static final String RESULT
    = "results/part1/chapter01/hello_mirrored_top.pdf";
	int cantitate=0;
	int ver;
	int verificare=1;
	Product produs;
	Student client;
	int iesire=0;
	StudentDAO x=new StudentDAO();
	ProductDAO y=new ProductDAO();
	public JFrame frame;
	 DefaultTableModel model = new DefaultTableModel();
	    JTable jtbl = new JTable(model);
	JPanel p = new JPanel(); 
	JPanel p1 = new JPanel(); 
	JPanel p2 = new JPanel(); 
	JPanel p3 = new JPanel(); 	   
	JPanel p4 = new JPanel(); 
	JPanel p5 = new JPanel(); 
	JButton alegeClient = new JButton("Alege clientul ");
	JButton alegeProdus = new JButton("Alege produsul ");
	JButton alegeCantitate = new JButton("Cantitatea ");
	JButton adaugaComanda = new JButton("Adauga ");

	JTextField idClient = new JTextField(5);
	JTextField idProdus = new JTextField(5);
	JTextField idCantitate = new JTextField(5);

	

	

   public ViewOrder() {

	   frame = new JFrame ("Polinom"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   

	//panou4
	   p4.add(alegeClient);
	   p4.add(idClient);
	   p3.add(alegeProdus);
	   p3.add(idProdus);
	   p2.add(alegeCantitate);
	   p2.add(idCantitate);
	   p1.add( adaugaComanda);
	   p5.add(p1);
	   p.add(p1);
	   p.add(p2);
	   p.add(p3);
	   p.add(p4);
	   p.add(p5);
	   adaugaComanda.addActionListener(this);
	   alegeCantitate.addActionListener(this);
	   alegeClient.addActionListener(this);
	   alegeProdus.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }


@Override
public void actionPerformed(ActionEvent evt) {
	// TODO Auto-generated method stub
	if(evt.getSource()==alegeClient)
	{
		int i=Integer.parseInt(idClient.getText());
		//System.out.println(i);
		
		//Student client=new Student(10,"asd","asd","asd",23);
		 client=new Student(x.findById(i).getId(),x.findById(i).getName(),x.findById(i).getAddress(),x.findById(i).getEmail(), x.findById(i).getAge());

	}
	if(evt.getSource()==alegeProdus)
	{
		int i=Integer.parseInt(idProdus.getText());
		//System.out.println(i);
		
		//Student client=new Student(10,"asd","asd","asd",23);
	    produs=new Product(y.findById(i).getId(),y.findById(i).getName(),y.findById(i).getPret(),y.findById(i).getCantitate());
		cantitate=y.findById(i).getCantitate();
		
	}
	if(evt.getSource()==alegeCantitate)
	{
		ver=Integer.parseInt(idCantitate.getText());
		if(ver>cantitate)
		{ verificare=0;
			System.out.println("under stock");
		}
		
	}
	if(evt.getSource()==adaugaComanda)
	{
		 ProdusDAO or=new ProdusDAO();
	     or.insert(new Order(client.getName(), produs.getId(), ver));
	     y.edit(produs.getId(), produs.getName(), produs.getPret(), produs.getCantitate()-ver);
	   //Set the Printer class
	     String x=new String();
	     byte data[]= {(byte)produs.getId()};
	     x=client.getName()+produs.getId()+ver;
	     try (PrintWriter out = new PrintWriter("filename.txt")) {
	    	    out.println("Clientul"+client.toString()+"a comandat"+ver+"din produsul"+produs.toString());
	    	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	     
	}
	
}
}