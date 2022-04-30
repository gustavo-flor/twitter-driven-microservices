package com.github.gustavoflor.tdm.twitterstreamservice.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ConfigurationProperties("twitter")
@Getter
@RequiredArgsConstructor
public class TwitterConfigProperties {
    private final Set<String> keywords;
}
