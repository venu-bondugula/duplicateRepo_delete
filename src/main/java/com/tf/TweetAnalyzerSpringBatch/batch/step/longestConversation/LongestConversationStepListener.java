package com.tf.TweetAnalyzerSpringBatch.batch.step.longestConversation;

import com.tf.TweetAnalyzerSpringBatch.batch.models.TweetsPerConversationAggregator;
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
public class LongestConversationStepListener implements StepExecutionListener {
    @Value("${analytics.counter}")
    private int count;

    private final TweetsPerConversationAggregator tweetsPerConversationAggregator;

    public LongestConversationStepListener(TweetsPerConversationAggregator tweetsPerConversationAggregator) {
        this.tweetsPerConversationAggregator = tweetsPerConversationAggregator;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        Map<String, Integer> tweetsPerConversation = tweetsPerConversationAggregator.getTweetsPerConversation();
        List<Map.Entry<String, Integer>> conversationWithHighestNumberOfTweets = tweetsPerConversation.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(count)
                .toList();
        System.out.println("------------------------------------------------------");
        System.out.println("IDs of conversations with highest number of tweets");
        System.out.println("<Conversation Id>=<Number of tweets part of this conversation>");
        System.out.println("------------------------------------------------------");
        conversationWithHighestNumberOfTweets.forEach(System.out::println);
        System.out.println("=======================================================");
        return ExitStatus.COMPLETED;
    }
}
