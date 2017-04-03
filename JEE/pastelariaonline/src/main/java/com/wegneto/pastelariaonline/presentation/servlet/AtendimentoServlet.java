package com.wegneto.pastelariaonline.presentation.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wegneto.pastelariaonline.domain.Resultado;
import com.wegneto.pastelariaonline.domain.service.PedidoService;
import com.wegneto.pastelariaonline.presentation.websocket.NotificacaoWebSocket;

@WebServlet(urlPatterns = "/atendimento", loadOnStartup = 1)
public class AtendimentoServlet extends HttpServlet {

	private static final long serialVersionUID = 7479025501206838360L;

	@EJB
	private PedidoService pedidoService;

	@EJB
	private NotificacaoWebSocket notificacaoWebSocket;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		final Gson gson = new Gson();
		try {
			final Long id = Long.parseLong(req.getParameter("id"));
			pedidoService.atender(id, req.getSession().getId());
			notificacaoWebSocket.notificar();
			resp.setStatus(200);
			resp.getWriter().write(gson.toJson(new Resultado(true, "Atendimento registrado com sucesso")));
		} catch (final RuntimeException e) {
			resp.sendError(500, e.getMessage());
		}
	}
}