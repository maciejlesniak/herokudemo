package pl.sparkidea.heroku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sparkidea.heroku.demo.dtos.DemoDto;
import reactor.core.publisher.Mono;

import java.util.Set;

@Profile("simple")
@RestController
public class SimpleController {

    private final String appName;
    private final String activeProfiles;
    private final String propertyFromAppProperties;
    private final String propertyFromTheSystem;

    @Autowired
    public SimpleController(
            @Value("${spring.application.name}") String appName,
            Environment environment,
            @Value("${app.property.inside:placeholder}") String propertyFromAppProperties,
            @Value("${app.property.sys:placeholder}") String propertyFromTheSystem) {

        this.appName = appName;
        this.activeProfiles = String.join(",", Set.of(environment.getActiveProfiles()));
        this.propertyFromAppProperties = propertyFromAppProperties;
        this.propertyFromTheSystem = propertyFromTheSystem;
    }

    @GetMapping(value = "/app")
    public Mono<DemoDto> getDemoDto() {
        return Mono.just(
                new DemoDto(appName, activeProfiles, propertyFromAppProperties, propertyFromTheSystem)
        );
    }


}
