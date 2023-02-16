package com.machntek.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JobPool {
  SAMPLE_A("sampleA"),
  SAMPLE_B("sampleB");

  private String jobName;

}
