package com.tf.TweetAnalyzerSpringBatch.batch.step.mostTweetedUser;

import com.tf.TweetAnalyzerSpringBatch.batch.models.TweetsPerUserAggregator;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@StepScope
public class MostTweetedUserStepListener implements StepExecutionListener {
    @Value("${analytics.counter}")
    private int count;

    private final TweetsPerUserAggregator tweetsPerUserAggregator;

    public MostTweetedUserStepListener(TweetsPerUserAggregator tweetsPerUserAggregator) {
        this.tweetsPerUserAggregator = tweetsPerUserAggregator;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        Map<String, Integer> tweetsPerUser = tweetsPerUserAggregator.getTweetsPerUser();
        List<Map.Entry<String, Integer>> mostTweetedUsers = tweetsPerUser.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(count)
                .toList();
        System.out.println("------------------------------------------------------");
        System.out.println("Users with highest number of tweets");
        System.out.println("<Username>=<Number of tweets tweeted>");
        System.out.println("------------------------------------------------------");
        mostTweetedUsers.forEach(System.out::println);
        System.out.println("=======================================================");
        return ExitStatus.COMPLETED;
    }
}
