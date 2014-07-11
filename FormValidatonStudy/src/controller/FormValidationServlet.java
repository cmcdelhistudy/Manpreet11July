package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormValidationServlet")
public class FormValidationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<String> challan = new ArrayList<String>();

		String uname = request.getParameter("username");
		String uage = request.getParameter("userage");

		if (uname.equals("")) {
			challan.add("User name is empty");
		}

		if (uage.equals("")) {
			challan.add("Age is empty");
		} else {
			try {
				int a = Integer.parseInt(uage);

				if (a < 0) {
					challan.add("Are you nuts ? How age can be -ve ");
				} else {
					if (a < 20) {
						challan.add("Abhi to tum bachce ho ! Go n play in park");
					}
					if (a > 60) {
						challan.add("Uncle you are too old.Go get some rest ");
					}
				}

			} catch (NumberFormatException nfe) {
				challan.add("Please enter valid age");
			}
		}

		if (challan.isEmpty()) {
			request.getRequestDispatcher("SuccessServlet").forward(request,
					response);
		} else {
			request.setAttribute("ERROR_LIST", challan);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
