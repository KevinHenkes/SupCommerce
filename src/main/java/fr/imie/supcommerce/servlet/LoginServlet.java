package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.supcommerce.database.CrudManager;
import fr.imie.supcommerce.entity.Category;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session = req.getSession();
	String login = req.getParameter("login");
	session.setAttribute("User", login);
	resp.sendRedirect(req.getContextPath() + "/listProduct");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CrudManager crudManager = null;

	try {
	    Category category = new Category("lol");
	    Category category2 = new Category("lol2");

	    Product product1 = new Product("test1", "test lolokol", 5.56F);
	    Product product2 = new Product("test2", "test lolokol", 5.56F);

	    crudManager = new CrudManager(Category.class);
	    crudManager.add(category);
	    crudManager.add(category2);

	    product1.setCategory(category);

	    crudManager = new CrudManager(Product.class);
	    crudManager.add(product1);

	    product1.setCategory(category2);

	    crudManager.update(product1);

	    crudManager = new CrudManager(Category.class);

	    crudManager.findAll().forEach(item -> {
		System.out.println(((Category) item).getProducts());
	    });

	} catch (ClassCastException e) {
	    e.printStackTrace();
	}

	RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	rd.forward(req, resp);
    }
}
