package com.github.gustavoflor.tdm.twitterstreamservice.listener.runner;

import com.github.gustavoflor.tdm.twitterstreamservice.config.TwitterConfigProperties;
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
    private final TwitterConfigProperties twitterConfigProperties;
    private final TweetListener tweetListener;

    private TwitterStream twitterStream;

    @Override
    public void start() {
        final FilterQuery filterQuery = new FilterQuery(twitterConfigProperties.getKeywords().toArray(String[]::new));
        twitterStream = TwitterStreamFactory.getSingleton().addListener(tweetListener).filter(filterQuery);
    }

    @PreDestroy
    @Override
    public void shutdown() {
        twitterStream.shutdown();
    }
}
