package co.com.sofkau.rabbit.bus;

import co.com.sofkau.rabbit.generic.SuccessNotificationSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queues.game.name}", durable = "true"),
            exchange = @Exchange(value = "${queues.exchange}", type = "topic"),
            key = "${queues.game.routing.key}"
    ))
    public void recievedMessageJuego(Message<String> message) {
        var successNotification = SuccessNotificationSerializer.instance().deserialize(message.getPayload());
        var event = successNotification.deserializeEvent();
        log.info("Llego este evento: {}", event);
    }
}