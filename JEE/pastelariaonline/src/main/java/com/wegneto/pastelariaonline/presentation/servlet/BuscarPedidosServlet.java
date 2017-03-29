package com.wegneto.pastelariaonline.presentation.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wegneto.pastelariaonline.domain.service.PedidoService;

@WebServlet(urlPatterns = "/pedidos", loadOnStartup = 1)
public class BuscarPedidosServlet extends HttpServlet {

	private static final long serialVersionUID = -5883823536178568608L;

	@EJB
	private PedidoService pedidoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try {
			resp.setStatus(200);
			resp.getWriter().write(pedidoService.pendentes().asJson());
		} catch (final RuntimeException e) {
			resp.sendError(500, e.getMessage());
		}
	}
}