package interfata;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.StudentBLL;
import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class Tabel  extends Frame implements ActionListener  {
	int iesire=0;
	public JFrame frame;
	 DefaultTableModel model = new DefaultTableModel();
	    JTable jtbl = new JTable(model);
	JPanel p = new JPanel(); 
	JPanel p1 = new JPanel(); 
	JPanel p2 = new JPanel(); 
	JPanel p3 = new JPanel(); 	   
	JPanel p4 = new JPanel(); 
	JButton adunareClient = new JButton("Adauga Client ");
	

   public Tabel(int i) {
	   List<String> list1=new ArrayList<String>();
	   StudentBLL clienti=new StudentBLL();
	     Student cautat;
	    cautat=clienti.findStudentById(i);
	    list1=StudentDAO.retrieveProperties(cautat);
	    String col[] =new String[list1.size()] ;
	    String clientu[]=new String[list1.size()];
	    for(int i1=0;i1<list1.size();i1++)
	    {
	    	col[i1]=new String();
	    	col[i1]=list1.get(i1);
	    }
	    clientu=cautat.transform();
	   DefaultTableModel tableModel = new DefaultTableModel(col,0);
	   
	   JTable table = new JTable();
	   table.setModel(tableModel);
	   tableModel.addRow(col);
	   tableModel.addRow(clientu);
	  // tableModel.addRow();
	  
	   Container cnt = this.getContentPane();
	   frame = new JFrame ("CLienti"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   
	//panou4
	   p.add(table);
	   adunareClient.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }
	 public Tabel()
   {
	   List<String> list1=new ArrayList<String>();
	   StudentDAO clienti=new StudentDAO();
	   List<Student> cautat=new ArrayList<Student>();
	    cautat=clienti.afisareid();
	    list1=StudentDAO.retrieveProperties(cautat.get(0));
	    String col[] =new String[list1.size()] ;
	    String clientu[]=new String[list1.size()];
	    for(int i1=0;i1<list1.size();i1++)
	    {
	    	col[i1]=new String();
	    	col[i1]=list1.get(i1);
	    }
	   
	   DefaultTableModel tableModel = new DefaultTableModel(col,0);
	   
	   JTable table = new JTable();
	   table.setModel(tableModel);
	   tableModel.addRow(col);
	   for(int i1=0;i1<cautat.size();i1++)
	    {
		   clientu=cautat.get(i1).transform();
	    	tableModel.addRow(clientu);
	    }
	  
	  // tableModel.addRow();
	  
	   Container cnt = this.getContentPane();
	   frame = new JFrame ("CLienti"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   
	//panou4
	   p.add(table);
	   adunareClient.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }
	 public Tabel(String nume,String adresa,String email,int age)
	 {
		 StudentBLL clienti=new StudentBLL();
		 clienti.insertStudent(new Student(nume,adresa,email,age));
	 }
	 public Tabel(int i,int j)
	 {
		 StudentDAO clienti=new StudentDAO();
		 clienti.deleteById(i);
	 }
	 public Tabel(String nume,String adresa,String email,int age,int a,int b)
	 {
		 StudentDAO clienti=new StudentDAO();
		 clienti.edit(2, nume, adresa, email, age);
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
		
	}
}
}