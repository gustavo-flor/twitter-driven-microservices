package com.github.gustavoflor.tdm.twitterstreamservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Slf4j
@Component
public class TweetListener extends StatusAdapter {
    @Override
    public void onStatus(final Status status) {
        log.info("Tweet received with text = {}", status.getText());
    }
}
