package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	
	EntityManagerFactory emf = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		emf = Persistence.createEntityManagerFactory("My-PU");
	}
	
	@Override
	public void destroy() {
		emf.close();
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product("Product", "Description product", 10.0F);
		EntityManager em = emf.createEntityManager();
 		EntityTransaction t = em.getTransaction();
 		try {
	    		t.begin();
	    		em.persist(product);
	    		t.commit();
 		} finally {
 		if (t.isActive()) t.rollback();
 			em.close();
 		}
		
		resp.getWriter().println("Product added !");
	}
}
