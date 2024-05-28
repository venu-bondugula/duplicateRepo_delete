package com.tf.TweetAnalyzerSpringBatch.batch.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfiguration {
    @Bean
    public Job job(
            final JobBuilderFactory jobBuilderFactory,
            @Qualifier(value = "LongestConversationsStep") final Step longestConversationsStep,
            @Qualifier(value = "MostTweetedUserStep") final Step mostTweetedUserStep,
            @Qualifier(value = "MostLikedTweetsStep") final Step mostLikedTweetsStep,
            @Qualifier(value = "TopHashTaggedTweetsStep") final Step topHashTaggedTweetsStep
    ) {
        return jobBuilderFactory.get("twitterAnalyticsJob")
                .start(mostTweetedUserStep)
                .next(mostLikedTweetsStep)
                .next(longestConversationsStep)
                .next(topHashTaggedTweetsStep)
                .build();
    }
}
