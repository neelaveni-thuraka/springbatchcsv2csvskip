package com.springbatch.step;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.entity.Student;

public class FailStudentWriter extends FlatFileItemWriter<Student> {

	ExecutionContext executionContext;

	@BeforeStep
	public void beforeSteps(StepExecution stepExecution) {
		this.executionContext = stepExecution.getExecutionContext();
	}

	public FailStudentWriter() {
		super.setResource(new FileSystemResource(
				"C:\\Users\\tneelave\\eclipse-workspace-latest\\springbatch-csvtocsv\\src\\main\\resources\\StudentFailed.csv"));
		DelimitedLineAggregator<Student> lineAggregator = new DelimitedLineAggregator<Student>();
		lineAggregator.setDelimiter(",");

		BeanWrapperFieldExtractor<Student> fieldExtractor = new BeanWrapperFieldExtractor<Student>();
		fieldExtractor.setNames(new String[]  { "firstName", "middleName", "lastName", "school", "maths", "science",
			"hindi", "social", "english", "mathsMarks", "scienceMarks", "hindiMarks", "socialMarks", "englishMarks",
			"totalMarks", "percantage", "grade" });
		lineAggregator.setFieldExtractor(fieldExtractor);
		super.setLineAggregator(lineAggregator);

	}

	@AfterStep
	public void afterSteps(StepExecution stepExecution) {
		executionContext = stepExecution.getExecutionContext();
		super.close();
	}

}
