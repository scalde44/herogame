package co.com.sofkau.model.generic;

public interface EventBus {

     void publish(DomainEvent event) ;

     void publishError(Throwable errorEvent);
}