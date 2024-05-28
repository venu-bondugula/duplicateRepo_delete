package com.tf.TweetAnalyzerSpringBatch.batch.step.mostLikedTweets;

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
public class MostLikedTweetsStepConfig {

    @Bean(name = "MostLikedTweetsStep")
    public Step mostLikedTweetsStep(final StepBuilderFactory stepBuilderFactory,
                                    final TwitterDatasetCSVReader twitterDatasetCSVReader,
                                    final MostLikedTweetsStepProcessor mostLikedTweetsStepProcessor,
                                    final TweetWriter tweetWriter,
                                    final MostLikedTweetsStepListener mostLikedTweetsStepListener,
                                    @Value("${analytics.chunkSize}") final int chunkSize
    ) {
        return stepBuilderFactory.get("mostLikedTweetsStep")
                .<Tweet, Tweet>chunk(chunkSize)
                .reader(twitterDatasetCSVReader)
                .processor(mostLikedTweetsStepProcessor)
                .writer(tweetWriter)
                .listener(mostLikedTweetsStepListener)
                .build();
    }
}
