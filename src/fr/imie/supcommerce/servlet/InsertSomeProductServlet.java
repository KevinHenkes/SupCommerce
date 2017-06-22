package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.model.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		
		Product p = new Product("Product", "Description product", 10.0F);
		ProductDao.addProduct(p);
		
		resp.getWriter().println("Product added !");
	}

	
	
}
