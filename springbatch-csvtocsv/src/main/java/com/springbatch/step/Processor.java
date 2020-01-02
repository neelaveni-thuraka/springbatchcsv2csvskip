package com.springbatch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileParseException;

import com.springbatch.entity.Student;

public class Processor implements ItemProcessor<Student, Student> {
	private static final Logger logger = LoggerFactory.getLogger(Processor.class);

	@Override
	public Student process(Student student) throws Exception {
		logger.info("-----------processor data----------" + student);
		float average, percentage, totalMarks = 0;
		totalMarks = (student.getMathsMarks() + student.getScienceMarks() + student.getHindiMarks()
				+ student.getSocialMarks() + student.getEnglishMarks());
		setNames(new String[] { "totalMarks" });

		average = (totalMarks / 5);

		if (average > 80) {
			student.setGrade("A");
		} else if (average > 60 && average <= 80) {
			student.setGrade("B");

		} else if (average > 35 && average <= 60) {
			student.setGrade("C");
		} else {
			student.setGrade("D");
		}

		average = totalMarks / 5;
		percentage = (totalMarks / 500) * 100;
		student.setPercantage(percentage);
		student.setTotalMarks(totalMarks);
		if (((student.getEnglishMarks() >= 35) && (student.getMathsMarks() >= 35) && (student.getScienceMarks() >= 35)
				&& (student.getSocialMarks() >= 35) && (student.getHindiMarks() >= 35))) {
			logger.info("------------processor if-------------");

			return student;

		} else {
			System.out.println("----------in processor else---------" + student);
			throw new FlatFileParseException("Cannot parse line to JSON", null);
		}

	}

	private void setNames(String[] strings) {

	}

}
