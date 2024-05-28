package com.tf.TweetAnalyzerSpringBatch.batch.models;

import lombok.Getter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@StepScope
@Component
@Getter
public class TweetsPerUserAggregator {
    private final Map<String, Integer> tweetsPerUser = new HashMap<>();

    public void update(Tweet tweet) {
        tweetsPerUser.merge(tweet.getUserName(), 1, Integer::sum);
    }
}
