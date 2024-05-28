package com.tf.TweetAnalyzerSpringBatch.batch.step.common;

import com.tf.TweetAnalyzerSpringBatch.batch.models.Tweet;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@StepScope
@Component
public class TweetFieldSetMapper implements FieldSetMapper<Tweet> {
    @Override
    public Tweet mapFieldSet(FieldSet fieldSet) {
        return Tweet.builder()
                .tweetId(fieldSet.readString(1))
                .userName(fieldSet.readString(3))
                .likeCount(fieldSet.readInt(10))
                .conversationId(fieldSet.readString(12))
                .hashTags(toHashTags(fieldSet.readString(18)))
                .hasTagCount(fieldSet.readInt(19))
                .build();
    }

    private List<String> toHashTags(String hashTagString) {
        if (hashTagString.length() == 2)
            return Collections.emptyList();
        hashTagString = hashTagString.substring(1, hashTagString.length() - 1);
        hashTagString = hashTagString.replaceAll("\"", "");
        hashTagString = hashTagString.replaceAll("'", "");
        hashTagString = hashTagString.replaceAll(",", "");
        return Arrays.stream(hashTagString.split("#")).filter(s -> !s.isEmpty()).toList();
    }
}
