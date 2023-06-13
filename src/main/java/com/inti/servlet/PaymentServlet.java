package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inti.model.CB;
import com.inti.model.Payment;
import com.inti.model.Paypal;
import com.inti.util.TraitementBDD;

/**
 * 
 * Permet de réaliser le payment
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TraitementBDD tbdd = new TraitementBDD();
		Payment p1 = null;
		
		if(request.getParameter("typeP").equals("Paypal"))
		{
			p1 = new Paypal(Double.parseDouble(request.getParameter("montant")), LocalDate.now(), 
					Integer.parseInt(request.getParameter("numPaypal")));
		}
		else if(request.getParameter("typeP").equals("CB"))
		{
			p1 = new CB(Double.parseDouble(request.getParameter("montant")), LocalDate.now(), 
					Long.parseLong(request.getParameter("numeroCB")), LocalDate.parse(request.getParameter("dateE")));
		}
		else
		{
			p1 = new Payment(Double.parseDouble(request.getParameter("montant")), LocalDate.now());
		}
		
		tbdd.enregistrerPayment(p1);
		
		response.sendRedirect("index.jsp");
	}

}
