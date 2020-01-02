package com.springbatch.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbatch.entity.SkippedStudent;
import com.springbatch.entity.Student;
import com.springbatch.step.FailStudentWriter;
import com.springbatch.step.SkipWriter;

@Component
public class ItemSkipListener implements SkipListener<Student, Student> {

	@Autowired
	SkipWriter skipWriter;

	@Autowired
	FailStudentWriter failStudentWriter;

	ExecutionContext executionContext;

	@Override
	public void onSkipInRead(Throwable t) {
		System.out.println("--------Skip Read--------" + ((FlatFileParseException) t).getInput());
		try {
			SkippedStudent ss = new SkippedStudent();
			ss.setSkippedRecord(((FlatFileParseException) t).getInput());
			skipWriter.write(Arrays.asList(ss));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSkipInWrite(Student item, Throwable t) {
		System.out.println("------------in Skip Write------");
	}

	@Override
	public void onSkipInProcess(Student item, Throwable t) {
		System.out.println("-------in Skip Process ----" + item);
		List<Student> list = new ArrayList<Student>();
		list.add(item);
		try {
			failStudentWriter.write(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
