package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.google.common.collect.ImmutableMap;

import domain.Part;

// QueryDSL with no generation https://stackoverflow.com/questions/15135572/is-it-possible-to-use-querydsl-without-generated-query-types
public class PartService {
	public PartService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		try {
			new Part();
			List<Class<?>> list = new ArrayList<>();
			list.add(Part.class);
			Map<String, Object> properties = ImmutableMap.<String, Object>builder()
					.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver")
					.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/corpterminal")
					.put("javax.persistence.jdbc.user", "observer")
					.put("javax.persistence.jdbc.password", "compaq")
					//.put(org.hibernate.jpa.AvailableSettings.LOADED_CLASSES, list)

					// .put("javax.persistence.jdbc.url", "jdbc:mysql://tm-corp.ru/CorpTerminal")
					// .put("javax.persistence.jdbc.user", "Observer")
					// .put("javax.persistence.jdbc.password", "CY73-YVRE-3FT2")

					// .put("javax.persistence.jdbc.url",
					// "jdbc:mysql://mikhailmineev.ru:3306/jpademo")
					// .put("javax.persistence.jdbc.user", "jpademo")
					// .put("javax.persistence.jdbc.password", "5xYB2e6T5Jo7ajA")

					// .put(AvailableSettings.DIALECT, Oracle12cDialect.class)
					// .put(AvailableSettings.HBM2DDL_AUTO, CREATE)
					// .put(AvailableSettings.SHOW_SQL, true)
					// .put(AvailableSettings.QUERY_STARTUP_CHECKING, false)
					// .put(AvailableSettings.GENERATE_STATISTICS, false)
					// .put(AvailableSettings.USE_REFLECTION_OPTIMIZER, false)
					// .put(AvailableSettings.USE_SECOND_LEVEL_CACHE, false)
					// .put(AvailableSettings.USE_QUERY_CACHE, false)
					// .put(AvailableSettings.USE_STRUCTURED_CACHE, false)
					// .put(AvailableSettings.STATEMENT_BATCH_SIZE, 20)
					.build();

			EntityManagerFactory emf = new HibernatePersistenceProvider()
					.createContainerEntityManagerFactory(new PersistenceUnitInfoImpl(), properties);
			EntityManager em = emf.createEntityManager();

			// JPAQuery<?> query = new JPAQuery<Void>(em);

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Part> select = cb.createQuery(Part.class);
			select.from(Part.class);
			/*
			 * select.where( cb.equal(root.get("id").get("userId"), "id");
			 */
			List<Part> parts = em.createQuery(select).getResultList();
			for (Part part : parts) {
				System.out.println(part);
			}

		} catch (org.hibernate.exception.JDBCConnectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Добавить запрос
	}
}
