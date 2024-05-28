package com.tf.TweetAnalyzerSpringBatch.batch.step.mostTweetedUser;

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
public class MostTweetedUserStepConfig {
    @Bean(name = "MostTweetedUserStep")
    public Step mostTweetedUserStep(final StepBuilderFactory stepBuilderFactory,
                                    final MostTweetedUserStepProcessor mostTweetedUserStepProcessor,
                                    final TwitterDatasetCSVReader twitterDatasetCSVReader,
                                    final TweetWriter tweetWriter,
                                    final MostTweetedUserStepListener mostTweetedUserStepListener,
                                    @Value("${analytics.chunkSize}") final int chunkSize
    ) {
        return stepBuilderFactory.get("topTweetersStep")
                .<Tweet, Tweet>chunk(chunkSize)
                .reader(twitterDatasetCSVReader)
                .processor(mostTweetedUserStepProcessor)
                .writer(tweetWriter)
                .listener(mostTweetedUserStepListener)
                .build();
    }
}
