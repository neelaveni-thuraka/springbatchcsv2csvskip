package com.springbatch.entity;

public class Student {

	private String firstName;
	private String middleName;
	private String lastName;
	private String school;
	private String maths;
	private String science;
	private String hindi;
	private String social;
	private String english;
	private float socialMarks;
	private float mathsMarks;
	private float scienceMarks;
	private float hindiMarks;
	private float englishMarks;
	private float totalMarks;
	private float percantage;
	private String grade;

	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public float getSocialMarks() {
		return socialMarks;
	}

	public void setSocialMarks(float socialMarks) {
		this.socialMarks = socialMarks;
	}

	public float getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(float mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public float getScienceMarks() {
		return scienceMarks;
	}

	public void setScienceMarks(float scienceMarks) {
		this.scienceMarks = scienceMarks;
	}

	public float getHindiMarks() {
		return hindiMarks;
	}

	public void setHindiMarks(float hindiMarks) {
		this.hindiMarks = hindiMarks;
	}

	public float getEnglishMarks() {
		return englishMarks;
	}

	public void setEnglishMarks(float englishMarks) {
		this.englishMarks = englishMarks;
	}

	public float getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(float totalMarks) {
		this.totalMarks = totalMarks;
	}

	public float getPercantage() {
		return percantage;
	}

	public void setPercantage(float percantage) {
		this.percantage = percantage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public String getHindi() {
		return hindi;
	}

	public void setHindi(String hindi) {
		this.hindi = hindi;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", school="
				+ school + ", maths=" + maths + ", science=" + science + ", hindi=" + hindi + ", social=" + social
				+ ", english=" + english + ", socialMarks=" + socialMarks + ", mathsMarks=" + mathsMarks
				+ ", scienceMarks=" + scienceMarks + ", hindiMarks=" + hindiMarks + ", englishMarks=" + englishMarks
				+ ", totalMarks=" + totalMarks + ", percantage=" + percantage + ", grade=" + grade + "]";
	}

}
