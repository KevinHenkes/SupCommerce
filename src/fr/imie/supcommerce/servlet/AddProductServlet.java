package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.model.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet{

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
            ProductDao.addProduct(product);

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
