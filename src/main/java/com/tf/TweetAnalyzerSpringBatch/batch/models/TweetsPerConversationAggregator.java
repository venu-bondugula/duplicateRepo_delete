package com.tf.TweetAnalyzerSpringBatch.batch.models;

import lombok.Getter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@StepScope
@Component
@Getter
public class TweetsPerConversationAggregator {
    private final Map<String, Integer> tweetsPerConversation = new HashMap<>();

    public void update(Tweet tweet) {
        tweetsPerConversation.merge(tweet.getConversationId(), 1, Integer::sum);
    }
}
