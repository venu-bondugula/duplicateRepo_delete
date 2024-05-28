package com.tf.TweetAnalyzerSpringBatch.batch.step.topHashTaggedTweets;

import com.tf.TweetAnalyzerSpringBatch.batch.models.TopHashTaggedTweetsAggregator;
import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.PriorityQueue;

@Component
@StepScope
@AllArgsConstructor
public class TopHashTaggedTweetsStepListener implements StepExecutionListener {
    private final TopHashTaggedTweetsAggregator topHashTaggedTweetsAggregator;

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        PriorityQueue<Tweet> topHashTaggedTweetsInReverseOrder = topHashTaggedTweetsAggregator.getTopHashTaggedTweets();
        ArrayList<Tweet> topHashTaggedTweets = new ArrayList<>();
        while (!topHashTaggedTweetsInReverseOrder.isEmpty()) {
            topHashTaggedTweets.add(0, topHashTaggedTweetsInReverseOrder.poll());
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Tweets with highest number of hashtags");
        System.out.println("------------------------------------------------------");
        topHashTaggedTweets.forEach(System.out::println);
        System.out.println("=======================================================");
        return ExitStatus.COMPLETED;
    }
}
