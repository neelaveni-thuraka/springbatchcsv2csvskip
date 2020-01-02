/*
 * package com.springbatch.entity;
 * 
 * import static org.junit.Assert.assertNotNull;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import org.mockito.MockitoAnnotations; import
 * org.mockito.junit.MockitoJUnitRunner; import
 * org.springframework.batch.item.ExecutionContext; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * @RunWith(MockitoJUnitRunner.class)
 * 
 * public class StudentTest {
 * 
 * @MockBean Student student;
 * 
 * @Before public void setup() { MockitoAnnotations.initMocks(this); }
 * 
 * @MockBean ExecutionContext executionContext;
 * 
 * @Test public void testPerson() { try { student = new Student();
 * student.setFirstName("Bhagya"); student.setMiddleName("nothing");
 * student.setLastName("gopanaboina"); student.setEnglishMarks(90);
 * student.setMathsMarks(89); student.setHindiMarks(99);
 * student.setScienceMarks(78); student.setSchool("govt");
 * student.setGrade("a1"); student.setPercantage(90);
 * student.setTotalMarks(567); student.setSocialMarks(65);
 * student.getFirstName(); student.getMiddleName(); student.getLastName();
 * student.getEnglishMarks(); student.getHindiMarks(); student.getMathsMarks();
 * student.getSchool(); student.getTotalMarks(); student.getGrade();
 * student.getPercantage(); student.getScienceMarks(); student.getSocialMarks();
 * assertNotNull(student.toString()); } catch (Exception e) {
 * e.printStackTrace(); } }
 * 
 * }
 */