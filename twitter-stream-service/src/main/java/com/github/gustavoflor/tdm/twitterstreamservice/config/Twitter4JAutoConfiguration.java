package com.github.gustavoflor.tdm.twitterstreamservice.config;

import com.github.gustavoflor.tdm.twitterstreamservice.config.properties.Twitter4JConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@RequiredArgsConstructor
public class Twitter4JAutoConfiguration {
    private final Twitter4JConfigProperties twitter4JConfigProperties;

    @Bean
    public TwitterStreamFactory twitterStreamFactory() {
        return new TwitterStreamFactory(configurationBuilder().build());
    }

    private ConfigurationBuilder configurationBuilder() {
        return new ConfigurationBuilder()
                .setDebugEnabled(twitter4JConfigProperties.debug())
                .setOAuthConsumerKey(twitter4JConfigProperties.oauth().consumerKey())
                .setOAuthConsumerSecret(twitter4JConfigProperties.oauth().consumerSecret())
                .setOAuthAccessToken(twitter4JConfigProperties.oauth().accessToken())
                .setOAuthAccessTokenSecret(twitter4JConfigProperties.oauth().accessTokenSecret());
    }
}
