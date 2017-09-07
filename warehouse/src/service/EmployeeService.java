package service;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQuery;

public class EmployeeService {
	public EmployeeService() {
		System.out.println("Loading driver...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		Properties properties = new Properties();
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://127.0.0.1:3306/yourdatabase");
		properties.put("javax.persistence.jdbc.user", "jpademo"); // if needed
		properties.put("javax.persistence.jdbc.password", "5xYB2e6T5Jo7ajA"); // if needed

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee", properties);
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unused")
		JPAQuery<?> query = new JPAQuery<Void>(em);
		// TODO Добавить запрос

		// emf.setPersistenceProviderClass(org.eclipse.persistence.jpa.PersistenceProvider.class);
		// //If your using eclipse or change it to whatever you're using
		// emf.setPackagesToScan("domain"); //The packages to search for Entities, line
		// required to avoid looking into the persistence.xml
		// emf.setPersistenceUnitName(SysConstants.SysConfigPU);
		// emf.setJpaPropertyMap(properties);
		// emf.setLoadTimeWeaver(new ReflectiveLoadTimeWeaver()); //required unless you
		// know what your doing
	}
}
