package com.test01;

public class Score {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {}
	
		
	public Score(String name, int kor, int eng, int math, int sum, double avg, String grade) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	public int getSum () {
		
		return kor+math+eng;
	}
	
	public double getAvg() {
		
		return getSum()/3.0;
	}
	
	public String getGgrade() {
		
		switch((int)getAvg()/10) {
		case 10: case 9: 
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		
		}
		
	}
	@Override
	public String toString() {
		return "이름: " + name + ", 국어점수: " + kor + ", 영어점수: " + eng + ", 수학점수: " + math + ", 총점: " + getSum() + ", 평균: "
				+ getAvg() + ", 성적: " + getGgrade() ;
	}
	
	
	

}
