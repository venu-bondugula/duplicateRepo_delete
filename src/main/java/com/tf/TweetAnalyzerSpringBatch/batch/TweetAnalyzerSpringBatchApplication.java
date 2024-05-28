package com.tf.TweetAnalyzerSpringBatch.batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class TweetAnalyzerSpringBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(TweetAnalyzerSpringBatchApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(final JobLauncher jobLauncher, final Job job) {
        return args -> jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
    }
}