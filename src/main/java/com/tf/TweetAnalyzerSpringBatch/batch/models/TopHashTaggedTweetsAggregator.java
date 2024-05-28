package com.tf.TweetAnalyzerSpringBatch.batch.models;

import lombok.Getter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.PriorityQueue;

@StepScope
@Component
@Getter
public class TopHashTaggedTweetsAggregator {
    private final int count;
    private final PriorityQueue<Tweet> topHashTaggedTweets;

    public TopHashTaggedTweetsAggregator(@Value("${analytics.counter}") final int count) {
        this.count = count;
        this.topHashTaggedTweets = new PriorityQueue<>(count, Comparator.comparingLong(tweet -> tweet.getHashTags().size()));
    }

    public void update(Tweet tweet) {
        if (topHashTaggedTweets.isEmpty() || topHashTaggedTweets.size() < count) {
            topHashTaggedTweets.add(tweet);
            return;
        }
        if (topHashTaggedTweets.peek().getHashTags().size() > tweet.getHashTags().size())
            return;

        topHashTaggedTweets.poll();
        topHashTaggedTweets.add(tweet);
    }
}
