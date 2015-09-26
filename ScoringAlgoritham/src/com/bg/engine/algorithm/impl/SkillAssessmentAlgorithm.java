package com.bg.engine.algorithm.impl;

import java.util.List;
import java.util.Map;

import com.bg.engine.AssessmentAlgorithm;
import com.bg.engine.AssessmentObject;
import com.bg.engine.JobRequirement;
import com.bg.engine.impl.SkillRequirement;

public class SkillAssessmentAlgorithm implements AssessmentAlgorithm {

	@Override
	public AssessmentObject doAlgorithum(JobRequirement requirement) {
		AssessmentObject assessmentObject = new AssessmentObject();
		//SkillRequirement skillRequirement = (SkillRequirement)requirement;
		//Context context = null;
		double applicantSkillScore = getApplicantSkillScore(null);
		assessmentObject.setAssessmentScore(applicantSkillScore);
		return assessmentObject;
	}

	private double getApplicantSkillScore(List<String> skills){
		double totalSkillScore = 0.0;
		
		for(String skill : skills){
			int skillScore = 0;
			int jobSkillLevel = getJobRequiredSkillLevel();
			int applicantSkillLevel = getApplicantSkillLevel();
			int skillLevelDifference = jobSkillLevel-applicantSkillLevel;
			int skillModifier = computeMatchingSkillModifiers(skillLevelDifference);
			skillScore = jobSkillLevel+skillModifier;
			
			totalSkillScore+=skillScore;
		}
		
		return totalSkillScore/skills.size();
	}
	private int computeMatchingSkillModifiers(int skillLevelDifference){
		int skillModifier = 0;
				
			if(skillLevelDifference==0){
			
			}
			else if(skillLevelDifference>0){
				//applicant skill is less qualified then required for this skill
				skillModifier-=10;
			}
			else{
				//applicant's skill is more then required
				skillModifier+=2;
			}
		
		return skillModifier;
	}
	
	private int getApplicantSkillLevel(){
		return 3;
	}
	
	private int getJobRequiredSkillLevel(){
		return 4;
	}
}
