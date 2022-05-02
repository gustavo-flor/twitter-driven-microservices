package com.github.gustavoflor.tdm.twitterstreamservice;

import com.github.gustavoflor.tdm.twitterstreamservice.config.properties.Twitter4JConfigProperties;
import com.github.gustavoflor.tdm.twitterstreamservice.integration.twitter.listener.runner.ListenerRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(Twitter4JConfigProperties.class)
@RequiredArgsConstructor
public class TwitterStreamServiceApplication implements CommandLineRunner {
    private final List<ListenerRunner> listenerRunners;

    public static void main(String[] args) {
        SpringApplication.run(TwitterStreamServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        listenerRunners.forEach(ListenerRunner::start);
    }
}
