package com.tf.TweetAnalyzerSpringBatch.batch.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@ToString
public class Tweet {
    private final String tweetId;
    private final String userName;
    private final long likeCount;
    private final String conversationId;
    private final List<String> hashTags;
    private final int hasTagCount;
}
