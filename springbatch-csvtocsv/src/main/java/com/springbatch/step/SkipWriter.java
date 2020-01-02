package com.springbatch.step;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.entity.SkippedStudent;

public class SkipWriter extends FlatFileItemWriter<SkippedStudent> {

	ExecutionContext executionContext;

	@BeforeStep
	public void beforeSteps(StepExecution stepExecution) {
		this.executionContext = stepExecution.getExecutionContext();
	}

	public SkipWriter() {
		super.setResource(new FileSystemResource(
				"C:\\Users\\tneelave\\eclipse-workspace-latest\\springbatch-csvtocsv\\src\\main\\resources\\StudentSkipped.csv"));
		DelimitedLineAggregator<SkippedStudent> lineAggregator = new DelimitedLineAggregator<SkippedStudent>();
		lineAggregator.setDelimiter(",");

		BeanWrapperFieldExtractor<SkippedStudent> fieldExtractor = new BeanWrapperFieldExtractor<SkippedStudent>();
		fieldExtractor.setNames(new String[] { "skippedRecord" });
		lineAggregator.setFieldExtractor(fieldExtractor);
		super.setLineAggregator(lineAggregator);

	}

	@AfterStep
	public void afterSteps(StepExecution stepExecution) {
		executionContext = stepExecution.getExecutionContext();
		super.close();
	}
}
