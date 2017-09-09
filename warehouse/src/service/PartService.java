package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import domain.Part;
import ru.bmstu.rk9.rao.lib.persistence.RaoEntityManager;

public class PartService {
	
	private EntityManager em;
	
	public PartService() {
		/*
		 * //Исходный сервер
		 * EntityManager em = new
		 * RaoEntityManager().setUrl("jdbc:mysql://tm-corp.ru/CorpTerminal").setUser(
		 * "Observer").setPassword("CY73-YVRE-3FT2").addLoadedClasses(Part.class).
		 * createEntityManager();
		 */
		/*
		 * Локальный сервер
		 * EntityManager em = new
		 * RaoEntityManager().setUrl("jdbc:mysql://localhost:3306/corpterminal").
		 * setUser( "observer").setPassword("compaq").addLoadedClasses(Part.class).
		 * createEntityManager();
		 */
		
		// Сервер с внешним доступом
		em = new RaoEntityManager().addLoadedClasses(Part.class).createEntityManager();

	}
	
	public List<Part> getAllParts(){
		// JPAQuery<?> query = new JPAQuery<Void>(em);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Part> select = cb.createQuery(Part.class);
		select.from(Part.class);
		// select.where( cb.equal(root.get("id").get("userId"), "id");
		return em.createQuery(select).getResultList();
		
	}
}
