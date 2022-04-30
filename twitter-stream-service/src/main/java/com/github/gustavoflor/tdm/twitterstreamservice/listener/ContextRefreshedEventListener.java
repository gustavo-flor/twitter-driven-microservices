package com.github.gustavoflor.tdm.twitterstreamservice.listener;

import com.github.gustavoflor.tdm.twitterstreamservice.listener.runner.TweetListenerRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private final TweetListenerRunner tweetListenerRunner;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        tweetListenerRunner.start();
    }
}
