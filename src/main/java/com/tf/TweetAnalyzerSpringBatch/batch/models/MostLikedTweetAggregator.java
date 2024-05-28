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
public class MostLikedTweetAggregator {
    private final int count;

    private final PriorityQueue<Tweet> mostLikedTweets;

    public MostLikedTweetAggregator(@Value("${analytics.counter}") final int count) {
        this.count = count;
        this.mostLikedTweets = new PriorityQueue<>(count, Comparator.comparingLong(Tweet::getLikeCount));
    }

    public void update(Tweet tweet) {
        if (mostLikedTweets.isEmpty() || mostLikedTweets.size() < count) {
            mostLikedTweets.add(tweet);
            return;
        }
        if (mostLikedTweets.peek().getLikeCount() > tweet.getLikeCount())
            return;

        mostLikedTweets.poll();
        mostLikedTweets.add(tweet);
    }
}
