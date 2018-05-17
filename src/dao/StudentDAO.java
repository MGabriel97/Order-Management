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

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class StudentDAO {

	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO student (name,address,email,age)"
			+ " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM student where id = ?";
	private final static String editStatementString = "UPDATE student SET name = ?, address= ?,email = ?,age = ?  WHERE id = ?;";
	private final static String deleteStatementString = "DELETE FROM student where id = ?";
	private static final String afisareStatementString = "SELECT * FROM student";

	public static Student findById(int studentId) {
		Student toReturn = null;

		Connection dbConnection = ConnectionFactory1.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, studentId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			toReturn = new Student(studentId, name, address, email, age);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory1.close(rs);
			ConnectionFactory1.close(findStatement);
			ConnectionFactory1.close(dbConnection);
		}
		return toReturn;
	}
	public static void deleteById(int studentId) {
		Student toReturn = null;

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
	public static void edit(int studentId, String name,String address,String email,int age) {
		Student toReturn = null;

		Connection dbConnection = ConnectionFactory1.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(editStatementString);
			findStatement.setString(1, name);
			findStatement.setString(2, address);
			findStatement.setString(3, email);
			findStatement.setLong(4, age);
			findStatement.setLong(5, studentId);
			findStatement.executeUpdate();
		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory1.close(rs);
			ConnectionFactory1.close(findStatement);
			ConnectionFactory1.close(dbConnection);
		}
	}

	public static int insert(Student student) {
		Connection dbConnection = ConnectionFactory1.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, student.getName());
			insertStatement.setString(2, student.getAddress());
			insertStatement.setString(3, student.getEmail());
			insertStatement.setInt(4, student.getAge());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory1.close(insertStatement);
			ConnectionFactory1.close(dbConnection);
		}
		return insertedId;
	}
	public static ResultSet rs1 = null;
	
	
	public static List<Student> afisareid() {
		List<Student> s1=new ArrayList<Student>();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch(ClassNotFoundException e) {
	         System.out.println("Class not found "+ e);
	      }
	      try {
	    	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "zyzz2011");
	         
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM student");
	         //System.out.println("id  name    job");
	         while (rs.next()) {
	        	
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String job = rs.getString("address");
	            String email = rs.getString("email");
	            int age = rs.getInt("age");
	            //System.out.println(id+"   "+name+"    "+job+email+age);
	            s1.add(new Student(id,name,job,email,age));
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