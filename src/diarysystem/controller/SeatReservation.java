package diarysystem.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diarysystem.model.ReservationModel;

@WebServlet("/SeatReservation")
public class SeatReservation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ReservationModel reservation = new ReservationModel();

		/////////////////////////////////////////////////////
		//席をオブジェクト化してあげる。
		HashMap<String,String> seatData = reservation.getReservation();

		req.setAttribute("seat", seatData);


		RequestDispatcher dispatcher =
				req.getRequestDispatcher("WEB-INF/jsp/SeatReservation.jsp");
		dispatcher.forward(req, resp);
	}

}
