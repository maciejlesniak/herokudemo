package pl.sparkidea.heroku.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoDto {

    private final String appName;
    private final String springProfile;
    private final String inside;
    private final String sys;

    public DemoDto(
            String appName,
            String springProfile,
            String inside,
            String sys) {
        this.appName = appName;
        this.springProfile = springProfile;
        this.inside = inside;
        this.sys = sys;
    }

    public String getAppName() {
        return appName;
    }

    public String getSpringProfile() {
        return springProfile;
    }

    public String getInside() {
        return inside;
    }

    public String getSys() {
        return sys;
    }
}
