package com.machntek.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class CustomJobParametersIncrementer implements JobParametersIncrementer {

  @Override
  public JobParameters getNext(JobParameters parameters) {

    String id = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    return new JobParametersBuilder().addString("date", id).toJobParameters();
  }
}
