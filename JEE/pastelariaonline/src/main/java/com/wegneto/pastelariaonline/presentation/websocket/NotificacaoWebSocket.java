package com.wegneto.pastelariaonline.presentation.websocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wegneto.pastelariaonline.domain.service.PedidoService;

@Singleton
@ServerEndpoint("/notificacao")
public class NotificacaoWebSocket {

	private Queue<Session> queue = new ConcurrentLinkedQueue<Session>();

	private final Logger logger = LoggerFactory.getLogger(NotificacaoWebSocket.class);

	@EJB
	private PedidoService pedidoService;

	public void notificar() {
		try {
			for (final Session s : queue) {
				if (s.isOpen()) {
					s.getBasicRemote().sendText(pedidoService.pendentes().asJson());
				}
			}
		} catch (final IOException e) {
			logger.error("Ocorreu um erro ao enviar a mensagem:", e);
		}
	}

	@OnOpen
	public void open(final Session session) {
		queue.add(session);
	}

	@OnClose
	public void close(final Session session) {
		queue.remove(session);
	}

	@OnError
	public void onError(final Session session, final Throwable cause) {
		queue.remove(session);
	}
}