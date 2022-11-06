package com.jpedroborges.fd.togglemanager.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Configuration
@ConfigurationProperties(prefix = "tla")
@PropertySource("classpath:configurations/tla.properties")
@Validated
@Data
public class TlaConfigurationProperties {
    @Pattern(regexp = "^(?:(?!\\{\\$tla\\}).)*\\{\\$tla\\}(?!.*\\{\\$tla\\}).*$")
    @Pattern(regexp = "^(?:(?!\\{\\$dc\\}).)*\\{\\$dc\\}(?!.*\\{\\$dc\\}).*$")
    @Pattern(regexp = "^(?:(?!\\{\\$env\\}).)*\\{\\$env\\}(?!.*\\{\\$env\\}).*$")
    @Pattern(regexp = "^(?:(?!\\{\\$az\\}).)*\\{\\$az\\}(?!.*\\{\\$az\\}).*$")
    @Pattern(regexp = "^(?:(?!\\{\\$machine\\}).)*\\{\\$machine\\}(?!.*\\{\\$machine\\}).*$")
    @NotBlank
    private String urlPattern;
    private String suffix;
}
