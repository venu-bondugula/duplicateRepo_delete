package com.tf.TweetAnalyzerSpringBatch.batch.step.topHashTaggedTweets;

import com.tf.TweetAnalyzerSpringBatch.batch.models.TopHashTaggedTweetsAggregator;
import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@StepScope
@Component
@AllArgsConstructor
public class TopHashTaggedTweetsStepProcessor implements ItemProcessor<Tweet, Tweet> {
    private final TopHashTaggedTweetsAggregator topHashTaggedTweetsAggregator;

    @Override
    public Tweet process(Tweet tweet) {
        topHashTaggedTweetsAggregator.update(tweet);
        return tweet;
    }
}
