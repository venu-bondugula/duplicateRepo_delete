package com.tf.TweetAnalyzerSpringBatch.batch.step.longestConversation;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import com.tf.TweetAnalyzerSpringBatch.batch.step.common.TweetWriter;
import com.tf.TweetAnalyzerSpringBatch.batch.step.common.TwitterDatasetCSVReader;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class LongestConversationStepConfig {
    @Bean(name = "LongestConversationsStep")
    public Step longestConversationsStep(final StepBuilderFactory stepBuilderFactory,
                                         final TwitterDatasetCSVReader twitterDatasetCSVReader,
                                         final LongestConversationStepProcessor longestConversationStepProcessor,
                                         final TweetWriter tweetWriter,
                                         final LongestConversationStepListener longestConversationStepListener,
                                         @Value("${analytics.chunkSize}") final int chunkSize) {
        return stepBuilderFactory.get("topTweetersStep")
                .<Tweet, Tweet>chunk(chunkSize)
                .reader(twitterDatasetCSVReader)
                .processor(longestConversationStepProcessor)
                .writer(tweetWriter)
                .listener(longestConversationStepListener)
                .build();
    }
}
