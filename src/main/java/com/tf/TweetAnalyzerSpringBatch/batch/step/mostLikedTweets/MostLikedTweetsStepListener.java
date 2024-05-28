package com.tf.TweetAnalyzerSpringBatch.batch.step.mostLikedTweets;

import com.tf.TweetAnalyzerSpringBatch.batch.models.MostLikedTweetAggregator;
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
public class MostLikedTweetsStepListener implements StepExecutionListener {
    private final MostLikedTweetAggregator mostLikedTweetAggregator;

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        PriorityQueue<Tweet> mostLikedTweetsInReverseOrder = mostLikedTweetAggregator.getMostLikedTweets();
        ArrayList<Tweet> mostLikedTweets = new ArrayList<>();
        while (!mostLikedTweetsInReverseOrder.isEmpty()) {
            mostLikedTweets.add(0, mostLikedTweetsInReverseOrder.poll());
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Tweets with highest number of likes");
        System.out.println("------------------------------------------------------");
        mostLikedTweets.forEach(System.out::println);
        System.out.println("=======================================================");
        return ExitStatus.COMPLETED;
    }
}
