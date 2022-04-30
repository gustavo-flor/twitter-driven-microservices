package com.github.gustavoflor.tdm.twitterstreamservice;

import com.github.gustavoflor.tdm.twitterstreamservice.config.properties.Twitter4JConfigProperties;
import com.github.gustavoflor.tdm.twitterstreamservice.listener.runner.TweetListenerRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Twitter4JConfigProperties.class)
@RequiredArgsConstructor
public class TwitterStreamServiceApplication implements CommandLineRunner {
    private final TweetListenerRunner tweetListenerRunner;

    public static void main(String[] args) {
        SpringApplication.run(TwitterStreamServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        tweetListenerRunner.start();
    }
}
