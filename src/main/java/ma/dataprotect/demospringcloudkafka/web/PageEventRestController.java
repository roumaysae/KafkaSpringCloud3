package ma.dataprotect.demospringcloudkafka.web;

import ma.dataprotect.demospringcloudkafka.entities.PageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class PageEventRestController {
    @Autowired
    private StreamBridge streamBridge; //l'utilisation de streamBridge pour envoyer les messages vers le topic, on a injecte le bean StreamBridge

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name) {
        PageEvent pageEvent = new PageEvent(name, "user1", new Date(),
                new Random().nextInt(9000));
        streamBridge.send(topic, pageEvent);
        return pageEvent;
    }
}
