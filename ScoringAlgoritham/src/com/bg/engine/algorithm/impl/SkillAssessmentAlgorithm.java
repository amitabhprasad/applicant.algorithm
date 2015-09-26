package com.bg.engine.algorithm.impl;

import java.util.List;
import java.util.Map;

import com.bg.engine.ApplicantDetails;
import com.bg.engine.AssessmentAlgorithm;
import com.bg.engine.AssessmentObject;
import com.bg.engine.JobRequirement;
import com.bg.engine.Applicant.impl.*;
import com.bg.engine.ApplicantModel.impl.ApplicantSkillModel;
import com.bg.engine.Requirement.impl.SkillRequirement;
import com.bg.engine.RequirementModel.impl.SkillRequirementModel;
//import com.bg.services.workflow.Context;

public class SkillAssessmentAlgorithm implements AssessmentAlgorithm {

	@Override
	public AssessmentObject doAlgorithum(JobRequirement requirement,ApplicantDetails applicantObject) {
		AssessmentObject assessmentObject = new AssessmentObject();
		SkillRequirement skillRequirement = (SkillRequirement)requirement;
		ApplicantSkill applicantSkill = (ApplicantSkill)applicantObject;
		//Context context = null;
		double applicantSkillScore = getApplicantSkillScore(skillRequirement.getSkillList(),applicantSkill.getSkillList());
		assessmentObject.setAssessmentScore(applicantSkillScore);
		return assessmentObject;
	}

	private double getApplicantSkillScore(List<SkillRequirementModel> reqSkillList,List<ApplicantSkillModel> applicantSkillList){
		double totalSkillScore = 0.0;
		
		for(SkillRequirementModel reqSkill : reqSkillList){
			int skillScore = 0;
			ApplicantSkillModel applicantSkill=getApplicantSkill(reqSkill,applicantSkillList);
			if(applicantSkill!=null){
				int jobSkillLevel = getJobRequiredSkillLevel(reqSkill);
				int applicantSkillLevel = getApplicantSkillLevel(applicantSkill);
				int skillLevelDifference = jobSkillLevel-applicantSkillLevel;
				int skillModifier = computeMatchingSkillModifiers(skillLevelDifference);
				skillScore = jobSkillLevel+skillModifier;
				
				totalSkillScore+=skillScore;
			}
			
		}
		
		return totalSkillScore/reqSkillList.size();
	}
	private ApplicantSkillModel getApplicantSkill(SkillRequirementModel reqSkill,List<ApplicantSkillModel> applicantSkillList) {
		for(ApplicantSkillModel applicantSkill : applicantSkillList){
			if(applicantSkill.getName() == reqSkill.getName()){
				return applicantSkill;
			}
		}
		return null;
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
	
	private int getApplicantSkillLevel(ApplicantSkillModel applicantSkill){
		int level = applicantSkill.getLevel();
		return level;
	}
	
	private int getJobRequiredSkillLevel(SkillRequirementModel reqSkillInstance){
		int level = reqSkillInstance.getLevel();
		return level;
	}
}
