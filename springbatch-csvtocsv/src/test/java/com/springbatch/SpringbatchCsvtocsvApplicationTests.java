package com.springbatch;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbatch.config.BatchConfiguration;
import com.springbatch.entity.Student;
import com.springbatch.step.Processor;
import com.springbatch.step.Reader;
import com.springbatch.step.Writer;

@RunWith(MockitoJUnitRunner.class)
public class SpringbatchCsvtocsvApplicationTests {
	@MockBean
	Reader reader;
	@MockBean
	SpringbatchCsvtocsvApplication test;
	@MockBean
	BatchConfiguration batchConfig;
	@MockBean
	ExecutionContext executionContext;

	@MockBean
	Writer writer;
	@MockBean
	Processor processor;

	@MockBean
	Job processJob;
	@MockBean
	JobExecution jobExecution;
	@MockBean
	Step step;
	@MockBean
	StepExecution stepExecution;
	@MockBean
	FlatFileItemWriter<Student> writerCsv;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	List<Student> employees = new ArrayList<>();
	Exception ex;

	@Test
	public void main() {
		SpringbatchCsvtocsvApplication.main(new String[] {});
	}

	/*
	 * @Test public void testBatchConfigReader() {
	 * 
	 * try { reader = new Reader(); assertNotNull(reader.read());
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
}
