import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bll.StudentBLL;
import dao.AbstractDAO;

import dao.ProductDAO;
import dao.ProdusDAO;
import dao.StudentDAO;
import interfata.Controller;
import connection.ConnectionFactory1;
import model.Order;
import model.Product;
import model.Student;

public class sursa {
	public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
		ConnectionFactory1 dr = new ConnectionFactory1();
        //here i want to print that table rows into Console using this
        System.out.println(); // How do you print here that table rows?
        StudentBLL x=new StudentBLL();
        ProductDAO y=new ProductDAO();
        //x.insertStudent(new Student(2,"George","Oradea","George@yahoo.com",31));
        Student x11=new Student(1,"asd","asd","asd",20);
        //StudentDAO.retrieveProperties(y.afisareid());
      // y.afisareid();
        List<String> lines; 
      Controller x1=new Controller();
      
      
        
}
}