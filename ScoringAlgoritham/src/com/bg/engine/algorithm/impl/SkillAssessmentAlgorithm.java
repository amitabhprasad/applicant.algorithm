package com.bg.engine.algorithm.impl;

import java.util.List;
import java.util.Map;

import com.bg.engine.AssessmentAlgorithm;
import com.bg.engine.AssessmentObject;
import com.bg.engine.JobRequirement;
import com.bg.engine.applicant.impl.*;
import com.bg.engine.applicant.data.ApplicantSkill;
import com.bg.engine.config.AlgoConfig;
import com.bg.engine.config.Skillconfig;
import com.bg.engine.requirement.impl.SkillRequirement;
import com.bg.engine.requirementmodel.impl.SkillRequirementModel;
//import com.bg.services.workflow.Context;

public class SkillAssessmentAlgorithm implements AssessmentAlgorithm {

	@Override
	public AssessmentObject doAlgorithum(JobRequirement requirement,ApplicantDetails applicantObject,AlgoConfig configInstance) {
		AssessmentObject assessmentObject = new AssessmentObject();
		SkillRequirement skillRequirement = (SkillRequirement)requirement;
		//Context context = null;
		double applicantSkillScore = getApplicantSkillScore(skillRequirement.getSkillList(),applicantObject.getSkillList(),configInstance);
		assessmentObject.setAssessmentScore(applicantSkillScore);
		return assessmentObject;
	}

	private double getApplicantSkillScore(List<SkillRequirementModel> reqSkillList,List<ApplicantSkill> applicantSkillList,AlgoConfig configInstance){
		double totalSkillScore = 0.0;
		
		for(SkillRequirementModel reqSkill : reqSkillList){
			int skillScore = 0;
			ApplicantSkill applicantSkill=getApplicantSkill(reqSkill,applicantSkillList);
			if(applicantSkill!=null){
				int jobSkillLevel = getJobRequiredSkillLevel(reqSkill);
				int applicantSkillLevel = getApplicantSkillLevel(applicantSkill,configInstance);
				int skillLevelDifference = jobSkillLevel-applicantSkillLevel;
				int skillModifier = computeMatchingSkillModifiers(skillLevelDifference);
				skillScore = jobSkillLevel+skillModifier;
				
				totalSkillScore+=skillScore;
			}
			
		}
		
		return totalSkillScore/reqSkillList.size();
	}
	private ApplicantSkill getApplicantSkill(SkillRequirementModel reqSkill,List<ApplicantSkill> applicantSkillList) {
		for(ApplicantSkill applicantSkill : applicantSkillList){
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
	
	private int getApplicantSkillLevel(ApplicantSkill applicantSkill,AlgoConfig configInstance){
		int experience = applicantSkill.getExperience();
		for(Skillconfig range : configInstance.getSkillCofig()){
			if(range.isInRange(experience)){
				return range.getSkillPoint();
			}
		}
		return 0;
	}
	
	private int getJobRequiredSkillLevel(SkillRequirementModel reqSkillInstance){
		int level = reqSkillInstance.getLevel();
		return level;
	}
}
