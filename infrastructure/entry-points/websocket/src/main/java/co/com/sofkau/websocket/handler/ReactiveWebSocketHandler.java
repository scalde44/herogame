package co.com.sofkau.websocket.handler;

//@Component
public class ReactiveWebSocketHandler {/*implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        var msg = webSocketSession.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .log();
        return webSocketSession.send(msg.map(webSocketSession::textMessage));
    }*/
}