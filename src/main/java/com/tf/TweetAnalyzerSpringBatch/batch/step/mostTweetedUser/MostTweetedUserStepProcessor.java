package com.tf.TweetAnalyzerSpringBatch.batch.step.mostTweetedUser;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import com.tf.TweetAnalyzerSpringBatch.batch.models.TweetsPerUserAggregator;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@StepScope
@Component
@AllArgsConstructor
public class MostTweetedUserStepProcessor implements ItemProcessor<Tweet, Tweet> {
    private final TweetsPerUserAggregator tweetsPerUserAggregator;

    @Override
    public Tweet process(Tweet tweet) {
        tweetsPerUserAggregator.update(tweet);
        return tweet;
    }
}