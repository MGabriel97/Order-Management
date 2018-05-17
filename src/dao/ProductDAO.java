package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.result.Field;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import connection.ConnectionFactory1;
import model.Student;
import model.Product;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ProductDAO {

	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (name,pret,cantitate)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM product where id = ?";
	private final static String editStatementString = "UPDATE product SET name = ?, pret= ?,cantitate = ?   WHERE id = ?;";
	private final static String deleteStatementString = "DELETE FROM product where id = ?";
	private static final String afisareStatementString = "SELECT * FROM product";

	public static Product findById(int studentId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory1.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, studentId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int pret = rs.getInt("pret");
			int cantitate = rs.getInt("cantitate");
			toReturn = new Product(studentId, name, pret,cantitate);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"productDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory1.close(rs);
			ConnectionFactory1.close(findStatement);
			ConnectionFactory1.close(dbConnection);
		}
		return toReturn;
	}
	public static void deleteById(int studentId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory1.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(deleteStatementString);
			findStatement.setLong(1, studentId);
			findStatement.executeUpdate();
		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory1.close(rs);
			ConnectionFactory1.close(findStatement);
			ConnectionFactory1.close(dbConnection);
		}
	}
	public static void edit(int studentId, String name,int pret,int cantitate) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory1.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(editStatementString);
			findStatement.setString(1, name);
			findStatement.setLong(2, pret);
			findStatement.setLong(3, cantitate);
			findStatement.setLong(4, studentId);
			findStatement.executeUpdate();
		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory1.close(rs);
			ConnectionFactory1.close(findStatement);
			ConnectionFactory1.close(dbConnection);
		}
	}

	public static int insert(Product produs) {
		Connection dbConnection = ConnectionFactory1.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, produs.getName());
			insertStatement.setInt(2, produs.getPret());
			insertStatement.setInt(3, produs.getCantitate());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory1.close(insertStatement);
			ConnectionFactory1.close(dbConnection);
		}
		return insertedId;
	}
	public static ResultSet rs1 = null;
	
	
	public static List<Product> afisareid() {
		List<Product> s1=new ArrayList<Product>();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch(ClassNotFoundException e) {
	         System.out.println("Class not found "+ e);
	      }
	      try {
	    	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "zyzz2011");
	         
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM product");
	         //System.out.println("id  name    job");
	         while (rs.next()) {
	        	
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            int pret = rs.getInt("pret");
	            int cantitate = rs.getInt("cantitate");
	           // System.out.println(id+"   "+name+"    "+j);
	            s1.add(new Product(id,name,pret,cantitate));
	         }
	      } catch(SQLException e) {
	         System.out.println("SQL exception occured" + e);
	      }
	      return s1;
	   }
	public static List<String> retrieveProperties(Object object)
	{
		List<String> list1=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		for(java.lang.reflect.Field field : object.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			Object value;
			try {
				list1.add(field.getName());
				value=field.get(object);
				list2.add( value.toString());
				System.out.println(field.getName()+"="+value);
			}catch(IllegalArgumentException e) {
				e.printStackTrace();
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return list1;
	}
	 public ResultSet getResultSet() {
         return rs;
   }
	private static ResultSet rs = null;
}