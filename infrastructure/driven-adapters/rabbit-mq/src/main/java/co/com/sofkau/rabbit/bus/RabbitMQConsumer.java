package co.com.sofkau.rabbit.bus;

import co.com.sofkau.rabbit.generic.SuccessNotificationSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQConsumer {
    private final EventListenerSubscriber eventListenerSubscriber;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queues.game.name}", durable = "true"),
            exchange = @Exchange(value = "${queues.exchange}", type = "topic"),
            key = "${queues.game.routing.key}"
    ))
    public void recievedMessageJuego(Message<String> message) throws IOException {
        var successNotification = SuccessNotificationSerializer.instance().deserialize(message.getPayload());
        var event = successNotification.deserializeEvent();
        log.info("Llego este evento: {}", event);
        this.eventListenerSubscriber.onNext(event);
    }
}