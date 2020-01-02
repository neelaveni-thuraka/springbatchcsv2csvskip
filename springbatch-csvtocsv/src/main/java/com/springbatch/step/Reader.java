package com.springbatch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.springbatch.entity.Student;

public class Reader extends FlatFileItemReader<Student> {
	private static final Logger logger = LoggerFactory.getLogger(Reader.class);
	FlatFileItemReader<Student> reader;

	public Reader() {
		logger.info("--------------Reader----------");
		/*
		 * if (!batchJobState) {
		 * 
		 * FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		 * setResource(new ClassPathResource("studentin.csv"));
		 * DefaultLineMapper<Student> defLineMapStu = new DefaultLineMapper<Student>();
		 * DelimitedLineTokenizer dellinetoken = new DelimitedLineTokenizer();
		 * super.setLineMapper(defLineMapStu);
		 * 
		 * defLineMapStu.setLineTokenizer(dellinetoken);
		 * 
		 * dellinetoken.setNames(new String[] { "firstName", "middleName", "lastName",
		 * "school", "mathsMarks", "scienceMarks", "hindiMarks", "socialMarks",
		 * "englishMarks", "percantage", "grade" });
		 * 
		 * dellinetoken.setDelimiter(","); BeanWrapperFieldSetMapper<Student>
		 * beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		 * 
		 * beanWrapperFieldSetMapper.setTargetType(Student.class); batchJobState = true;
		 * 
		 * }
		 */
		reader = new FlatFileItemReader<>();
		setResource(new ClassPathResource("studentin.csv"));
		super.setLineMapper(new DefaultLineMapper<Student>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "middleName", "lastName", "school", "maths", "science",
								"hindi", "social", "english", "mathsMarks", "scienceMarks", "hindiMarks", "socialMarks",
								"englishMarks" });

					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {
					{
						setTargetType(Student.class);
					}
				});
			}
		});

	}

}
