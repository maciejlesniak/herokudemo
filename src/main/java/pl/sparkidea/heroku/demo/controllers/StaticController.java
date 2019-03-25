package pl.sparkidea.heroku.demo.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sparkidea.heroku.demo.dtos.DemoDto;
import reactor.core.publisher.Mono;

import java.util.Set;

@Profile("static")
@RestController
public class StaticController {

    private String activeProfiles;

    public StaticController(Environment environment) {
        this.activeProfiles = "-> " + String.join(":", Set.of(environment.getActiveProfiles()));
    }

    @GetMapping(value = "/app")
    public Mono<DemoDto> getDemoDto() {
        return Mono.just(
                new DemoDto("Some default app name ", activeProfiles, null, null)
        );
    }


}
