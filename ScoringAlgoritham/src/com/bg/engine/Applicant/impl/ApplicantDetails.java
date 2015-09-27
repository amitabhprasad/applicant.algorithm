package com.bg.engine.applicant.impl;

import java.util.List;

import com.bg.engine.applicant.data.ApplicantSkill;

/*
 * 
 * 
 */
public class ApplicantDetails {
	private List<ApplicantSkill> skillInstance;
	
	public List<ApplicantSkill> getSkillList(){
		return skillInstance;
	}
	
	public void setSkillList(List<ApplicantSkill> skillInstance){
		this.skillInstance = skillInstance;
	}
}
