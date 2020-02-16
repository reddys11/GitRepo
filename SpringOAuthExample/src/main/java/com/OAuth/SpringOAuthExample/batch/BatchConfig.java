package com.OAuth.SpringOAuthExample.batch;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
//@EnableScheduling
public class BatchConfig {

@Autowired
private StepBuilderFactory stepBuilderFactory;

@Autowired
private JobBuilderFactory jobBuilderFactory;

@Autowired
private JobLauncher l_objJobLauncher;

@Autowired
private Job job;

private static final Logger LOGGER=LoggerFactory.getLogger(BatchConfig.class);

//@Scheduled(cron="*/60 * * * * *")
public BatchStatus perform()  
    {
	Map<String, JobParameter> l_hmParams = new HashMap<>();
	l_hmParams.put("time", new JobParameter(System.currentTimeMillis()));
    JobParameters parameters = new JobParameters(l_hmParams);
    String l_sMethodName="perform";
    JobExecution l_objJobExecution;
    BatchStatus l_objBatchStatus = null;
	try {
		l_objJobExecution = l_objJobLauncher.run(job, parameters);
		System.out.println("JobExecution toString: "+l_objJobExecution.toString());
		System.out.println("JobExecution: " + l_objJobExecution.getStatus());
		LOGGER.info("Batch is Running...");
	    l_objBatchStatus=l_objJobExecution.getStatus();
	    if(l_objBatchStatus!=null && l_objBatchStatus.toString().equalsIgnoreCase("completed")) {
	    	LOGGER.info("Batch Execution is completed.");
	    }
	    LOGGER.info("Batch Execution is completed.");   
	    return l_objBatchStatus;       
    }catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
			| JobParametersInvalidException e) {
    	LOGGER.error("Exception occured in"+l_sMethodName+"::"+e.getMessage());
	}
	return l_objBatchStatus;

    }
@Bean
public Job job(Step placementStep) {
	System.out.println("******Job Bean*******");
	return jobBuilderFactory.get("job")
		    .incrementer(new RunIdIncrementer())
		    .flow(placementStep)
		    .end()
		    .build();
	}

@Bean
public Step placementStep(ItemWriter<Object> p_objItemwriter,ItemReader<Object> p_objItemReader) {
	System.out.println("******Step Bean*******");
	  return stepBuilderFactory.get("placementSteps")
	    .<Object, Object> chunk(10)
	    .reader(p_objItemReader)
	   // .processor(l_objItemProcessor)
	    .writer(p_objItemwriter)
	    .build();
	}

}
