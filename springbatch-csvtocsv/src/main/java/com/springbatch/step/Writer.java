package com.springbatch.step;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.entity.Student;

public class Writer implements ItemWriter<Student> {

	ExecutionContext executionContext;

	@BeforeStep
	public void beforeSteps(StepExecution stepExecution) {
		executionContext = stepExecution.getExecutionContext();
	}

	@Override
	public void write(List<? extends Student> students) throws Exception {
		FlatFileItemWriter<Student> writer = new FlatFileItemWriter<Student>();
		writer.setResource(new FileSystemResource(
				"C:\\Users\\tneelave\\eclipse-workspace-latest\\springbatch-csvtocsv\\src\\main\\resources\\studentout.csv"));
		writer.open(executionContext);
		writer.setAppendAllowed(true);
		DelimitedLineAggregator<Student> lineAggregator = new DelimitedLineAggregator<Student>();
		lineAggregator.setDelimiter(",");

		BeanWrapperFieldExtractor<Student> fieldExtractor = new BeanWrapperFieldExtractor<Student>();
		fieldExtractor.setNames(new String[] { "firstName", "middleName", "lastName", "school", "maths", "science",
				"hindi", "social", "english", "mathsMarks", "scienceMarks", "hindiMarks", "socialMarks", "englishMarks",
				"totalMarks", "percantage", "grade" });

		lineAggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(lineAggregator);

		System.out.println("========studentsin========" + students.get(0));
		writer.write(students);
		writer.close();

	}

}
