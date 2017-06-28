package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> values = new ArrayList<String>();
        String[] names = {"name", "description", "price"};

        for (int i = 0; i < names.length; i++) {
            if (req.getParameter(names[i]).equals("")) {
                resp.getWriter().print("The field ");
                for (int j = i; j < names.length; j++) {
                    resp.getWriter().print(names[j]);
                    if (j < (names.length - 1)) {
                        resp.getWriter().print(", ");
                    }
                }
                resp.getWriter().println(" is empty.");
                break;
            } else {
                values.add((String) req.getParameter(names[i]));
            }
        }

        if (values.size() == names.length) {
            Product product = new Product(values);
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

            resp.getWriter().println("Product added");
			resp.sendRedirect(req.getContextPath()+"/showProduct?id="+product.getId());
        }
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(req, resp);
	}
}
