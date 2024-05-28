package com.tf.TweetAnalyzerSpringBatch.batch.step.common;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@StepScope
@Component
public class CustomLineMapper extends DefaultLineMapper<Tweet> {
    public CustomLineMapper(TweetFieldSetMapper tweetFieldSetMapper) {
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setStrict(false);

        this.setLineTokenizer(delimitedLineTokenizer);
        this.setFieldSetMapper(tweetFieldSetMapper);
    }
}
