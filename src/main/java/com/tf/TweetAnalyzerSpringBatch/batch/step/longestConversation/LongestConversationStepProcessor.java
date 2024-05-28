package com.tf.TweetAnalyzerSpringBatch.batch.step.longestConversation;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import com.tf.TweetAnalyzerSpringBatch.batch.models.TweetsPerConversationAggregator;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@StepScope
@Component
@AllArgsConstructor
public class LongestConversationStepProcessor implements ItemProcessor<Tweet, Tweet> {
    private final TweetsPerConversationAggregator tweetsPerConversationAggregator;

    @Override
    public Tweet process(Tweet tweet) {
        tweetsPerConversationAggregator.update(tweet);
        return tweet;
    }
}