package com.wegneto.pastelariaonline.presentation.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wegneto.pastelariaonline.domain.Pedido;
import com.wegneto.pastelariaonline.domain.Resultado;
import com.wegneto.pastelariaonline.domain.service.PedidoService;
import com.wegneto.pastelariaonline.presentation.websocket.NotificacaoWebSocket;

@WebServlet(urlPatterns = "/pedido", loadOnStartup = 1)
public class EfetuarPedidoServlet extends HttpServlet {

	private static final long serialVersionUID = -3309626245848149687L;

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
			final InputStreamReader inputStreamReader = new InputStreamReader(req.getInputStream());
			final Pedido pedido = gson.fromJson(inputStreamReader, Pedido.class);
			pedidoService.registrar(pedido);
			notificacaoWebSocket.notificar();

			resp.setStatus(200);
			resp.getWriter().write(gson.toJson(new Resultado(true, "Pedido realizado com exito")));
		} catch (final RuntimeException e) {
			resp.sendError(500, e.getMessage());
		}
	}
}