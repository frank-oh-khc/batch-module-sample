package com.machntek.test;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BatchJobSampleB {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final FeedService feedService;

  @Bean
  public Job sampleBJob() {
    return jobBuilderFactory.get(JobPool.SAMPLE_B.getJobName())
        .incrementer(new CustomJobParametersIncrementer())
        .start(sampleBStep())
        .build();
  }

  @Bean
  public Step sampleBStep() {
    return stepBuilderFactory.get("sampleBStep")
        .tasklet(((contribution, chunkContext) -> {
          System.out.println("##########");
          System.out.println("sample B Step is called!!");
          System.out.println("##########");

          feedService.doSomething();
          return RepeatStatus.FINISHED;
        }))
        .allowStartIfComplete(true)
        .build();
  }

}
