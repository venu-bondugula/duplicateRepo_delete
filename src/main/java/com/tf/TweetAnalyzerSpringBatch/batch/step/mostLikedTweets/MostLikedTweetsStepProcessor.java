package com.tf.TweetAnalyzerSpringBatch.batch.step.mostLikedTweets;

import com.tf.TweetAnalyzerSpringBatch.batch.models.MostLikedTweetAggregator;
import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@StepScope
@Component
@AllArgsConstructor
public class MostLikedTweetsStepProcessor implements ItemProcessor<Tweet, Tweet> {
    private final MostLikedTweetAggregator mostLikedTweetAggregator;

    @Override
    public Tweet process(Tweet tweet) {
        mostLikedTweetAggregator.update(tweet);
        return tweet;
    }
}
