package com.tf.TweetAnalyzerSpringBatch.batch.step.common;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@StepScope
@Component
public class TwitterDatasetCSVReader extends FlatFileItemReader<Tweet> {
    public TwitterDatasetCSVReader(final CustomLineMapper customLineMapper,
                                   @Value("${analytics.twitterDatasetCSVFilePath}") final String path) {
        this.setName("twitterDatasetCSVReader");
        this.setLinesToSkip(1); // Skip the header line of csv file
        this.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy()); // This is needed for malformed csv files
        this.setLineMapper(customLineMapper);
        this.setResource(new FileSystemResource(path));
    }
}