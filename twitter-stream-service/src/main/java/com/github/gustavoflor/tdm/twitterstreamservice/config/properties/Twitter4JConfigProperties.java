package com.github.gustavoflor.tdm.twitterstreamservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@ConfigurationProperties("twitter4j")
public record Twitter4JConfigProperties(@NotEmpty Set<String> keywords,
                                        boolean debug,
                                        @Valid @NotNull OAuth oauth) {
    public record OAuth(@NotBlank String consumerKey,
                        @NotBlank String consumerSecret,
                        @NotBlank String accessToken,
                        @NotBlank String accessTokenSecret) {
    }
}
