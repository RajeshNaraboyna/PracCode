package hibernateTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.dcl.Message;

public class SampleDclTest {

	/*
	 * @Test(dependsOnMethods = "saveMessage") public void readMessage1() {
	 * final String SELECT = "SELECT id, text FROM messages"; final String
	 * JDBCURL = "jdbc:h2:./db1"; List<Message> list = new ArrayList<>(); try
	 * (Connection connection = DriverManager.getConnection(JDBCURL, "sa", ""))
	 * { try (PreparedStatement ps = connection.prepareStatement(SELECT)) { try
	 * (ResultSet rs = ps.executeQuery()) { while (rs.next()) { Message message
	 * = new Message(); message.setId(rs.getLong(1));
	 * message.setText(rs.getString(2)); list.add(message); }
	 * 
	 * assertEquals(list.size(), 1); for (Message m : list) {
	 * System.out.println(m); } } } } catch (SQLException e) {
	 * e.printStackTrace(); throw new RuntimeException(e); } }
	 */
	private SessionFactory factory = null;

	@BeforeClass
	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	@Test
	public void saveMessage() {

	}

	@Test(dependsOnMethods = "saveMessage")
	public void readMessage() {
		try (Session session = factory.openSession()) {
			org.hibernate.Transaction transaction = session.getTransaction();
			transaction.begin();
			session.save(new Message("1234"));
			transaction.commit();
			List<Message> list = session.createQuery("from Message", Message.class).list();

			assertEquals(list.size(), 1);
			for (Message m : list) {
				System.out.println(m);
			}
		}
	}

}
