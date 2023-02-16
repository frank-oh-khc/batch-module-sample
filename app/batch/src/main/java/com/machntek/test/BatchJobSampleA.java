package com.machntek.test;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BatchJobSampleA {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final FeedService feedService;

  @Bean
  public Job sampleAJob() {
    return jobBuilderFactory.get(JobPool.SAMPLE_A.getJobName())
        .start(sampleAStep())
        .build();
  }

  @Bean
  @JobScope
  public Step sampleAStep() {
    return stepBuilderFactory.get("sampleAStep")
        .tasklet(((contribution, chunkContext) -> {
          System.out.println("##########");
          System.out.println("sample A Step is called!!");
          System.out.println("##########");

          feedService.doSomething();
          return RepeatStatus.FINISHED;
        }))
        .allowStartIfComplete(true)
        .build();
  }

}
