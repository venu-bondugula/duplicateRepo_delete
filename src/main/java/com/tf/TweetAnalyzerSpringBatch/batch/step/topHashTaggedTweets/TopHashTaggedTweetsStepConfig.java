package com.tf.TweetAnalyzerSpringBatch.batch.step.topHashTaggedTweets;

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
public class TopHashTaggedTweetsStepConfig {
    @Bean(name = "TopHashTaggedTweetsStep")
    public Step topHashTaggedTweetsStep(final StepBuilderFactory stepBuilderFactory,
                                        final TwitterDatasetCSVReader twitterDatasetCSVReader,
                                        final TopHashTaggedTweetsStepProcessor topHashTaggedTweetsStepProcessor,
                                        final TweetWriter tweetWriter,
                                        final TopHashTaggedTweetsStepListener topHashTaggedTweetsStepListener,
                                        @Value("${analytics.chunkSize}") final int chunkSize
    ) {
        return stepBuilderFactory.get("topHashTaggedTweetsStep")
                .<Tweet, Tweet>chunk(chunkSize)
                .reader(twitterDatasetCSVReader)
                .processor(topHashTaggedTweetsStepProcessor)
                .writer(tweetWriter)
                .listener(topHashTaggedTweetsStepListener)
                .build();
    }
}
