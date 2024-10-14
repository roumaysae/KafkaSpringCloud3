package ma.dataprotect.demospringcloudkafka.services;

import ma.dataprotect.demospringcloudkafka.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class PageEventService {

    @Bean //cette methode va retourner un consumer qui va consommer les messages envoyes par le producer en utilisant la programmation fonctionnelle et bean pour l'ajouter au contexte de spring
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("**************************");
            System.out.println(input.toString());
            System.out.println("**************************");
        };
    }//on a cree un consumer qui va consommer les messages envoyes par le producer en utilisant
    // la programmation fonctionnelle
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> new PageEvent(
                Math.random()>0.5?"PAGE1":"Page2",
                "user1",
                new java.util.Date(),
                new Random().nextInt(9000));
    } //on a cree un supplier qui va produire des messages en utilisant la programmation fonctionnelle dans chaque seconde on va produire un message
}
