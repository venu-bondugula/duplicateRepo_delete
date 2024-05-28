package com.tf.TweetAnalyzerSpringBatch.batch.step.common;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class TweetWriter implements ItemWriter<Tweet> {
    @Override
    public void write(List<? extends Tweet> items) {
    }
}

