package co.com.sofkau.websocket.controller;

import co.com.sofkau.model.generic.DomainEvent;
import co.com.sofkau.model.generic.SocketSendMessage;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ServerEndpoint("/game/events/{correlationId}")
public class WebSocketSendController implements SocketSendMessage {
    private static final Logger logger = Logger.getLogger(WebSocketSendController.class.getName());
    private static Map<String, Map<String, Session>> sessions;

    public WebSocketSendController() {
        if (Objects.isNull(sessions)) {
            sessions = new ConcurrentHashMap<>();
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("correlationId") String correlationId) {
        logger.info("Connect by " + correlationId);
        var map = sessions.getOrDefault(correlationId, new HashMap<>());
        map.put(session.getId(), session);
        sessions.put(correlationId, map);
    }

    @OnClose
    public void onClose(Session session, @PathParam("correlationId") String correlationId) {
        sessions.get(correlationId).remove(session.getId());
        logger.info("Desconnect by " + correlationId);

    }

    @OnError
    public void onError(Session session, @PathParam("correlationId") String correlationId, Throwable throwable) {
        sessions.get(correlationId).remove(session.getId());
        logger.log(Level.SEVERE, throwable.getMessage());

    }
    @Override
    public void send(String correlationId, String event) {
        if (Objects.nonNull(correlationId) && sessions.containsKey(correlationId)) {
            sessions.get(correlationId).values()
                    .forEach(session -> {
                        session.getAsyncRemote().sendText(event);
                    });
        }
    }
   /* private final WebSocketClient client;

    @Override
    public void send(String message) {
        client.execute(
                URI.create("ws://localhost:8080/events"),
                session -> session.send(
                        Mono.just(session.textMessage(message)))
        ).block();

    }*/
}
