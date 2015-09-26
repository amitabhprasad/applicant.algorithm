package com.bg.engine;

import java.util.List;

/**
 * 
 * @author amitpras
 *
 */
public class AssessmentObject {

	private double assessmentScore;
	
	private List<String> pros;
	
	private List<String> cons;
	
	public double getAssessmentScore() {
		return assessmentScore;
	}
	public void setAssessmentScore(double assessmentScore) {
		this.assessmentScore = assessmentScore;
	}
	public List<String> getPross() {
		return pros;
	}
	public void setPositivePoints(List<String> pros) {
		this.pros = pros;
	}
	public List<String> getCons() {
		return cons;
	}
	public void setNegativePoints(List<String> cons) {
		this.cons = cons;
	}
	
	
}
