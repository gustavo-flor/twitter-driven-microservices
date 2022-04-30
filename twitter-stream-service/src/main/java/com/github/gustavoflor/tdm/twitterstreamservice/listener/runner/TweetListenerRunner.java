package com.github.gustavoflor.tdm.twitterstreamservice.listener.runner;

import com.github.gustavoflor.tdm.twitterstreamservice.config.properties.Twitter4JConfigProperties;
import com.github.gustavoflor.tdm.twitterstreamservice.listener.TweetListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
public class TweetListenerRunner implements ListenerRunner {
    private final Twitter4JConfigProperties twitter4JConfigProperties;
    private final TweetListener tweetListener;
    private final TwitterStreamFactory twitterStreamFactory;

    private TwitterStream twitterStream;

    @Override
    public void start() {
        final FilterQuery filterQuery = new FilterQuery(twitter4JConfigProperties.keywords().toArray(String[]::new));
        twitterStream = twitterStreamFactory.getInstance().addListener(tweetListener).filter(filterQuery);
    }

    @PreDestroy
    @Override
    public void shutdown() {
        twitterStream.shutdown();
    }
}
