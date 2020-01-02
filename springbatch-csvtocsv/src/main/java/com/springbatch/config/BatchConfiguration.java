package com.springbatch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.entity.Student;
import com.springbatch.listener.ItemSkipListener;
import com.springbatch.listener.JobCompletionListener;
import com.springbatch.step.FailStudentWriter;
import com.springbatch.step.Processor;
import com.springbatch.step.Reader;
import com.springbatch.step.SkipWriter;
import com.springbatch.step.Writer;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);

	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	ItemSkipListener itemSkipListener;

	@Autowired
	public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
	}

	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	SkipWriter skiptWriter() {
		return new SkipWriter();
	}
	@Bean
	FailStudentWriter failStudentWriter() {
		return new FailStudentWriter();
	}

	@Bean
	public Reader reader() throws Exception {
		return new Reader();
	}

	@Bean
	public Writer writer() {
		return new Writer();
	}

	@Bean
	public Processor processor() {
		return new Processor();
	}

	@Bean("processJob1")
	public Job processJob1(Step orderStep7) throws Exception {
		logger.info("===============in job method========");
		return jobBuilderFactory.get("processJob1").incrementer(new RunIdIncrementer()).flow(orderStep7())
				.on(ExitStatus.COMPLETED.getExitCode()).end().from(orderStep7()).on(ExitStatus.FAILED.getExitCode())
				.fail().end().listener(listener()).build();
	}

	/*
	 * @Bean
	 * 
	 * public Step orderStep7() throws Exception {
	 * logger.info("===============in step method========"); return
	 * stepBuilderFactory.get("orderStep7").<Student,
	 * Student>chunk(1).reader(reader()).processor(processor())
	 * .writer(writer()).build(); }
	 */
	@Bean
	public Step orderStep7() throws Exception {
		return stepBuilderFactory.get("orderStep7").<Student, Student>chunk(10).reader(reader()).faultTolerant()
				.skip(FlatFileParseException.class).skipLimit(10).listener(itemSkipListener).processor(processor())
				.writer(writer()).stream(skiptWriter()).stream(failStudentWriter()).build();
	}

	@Bean
	public JobCompletionListener listener() {

		return new JobCompletionListener();
	}
}
