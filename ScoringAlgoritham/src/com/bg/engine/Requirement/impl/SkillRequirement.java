package com.bg.engine.Requirement.impl;

import java.util.List;
import com.bg.engine.JobRequirement;
import com.bg.engine.RequirementModel.impl.*;

/**
 * 
 * @author amitpras
 *
 * Carries details from Job Profiles and populated skill requirements if any for the given profile
 * This class should also populate  weightage those requirements should have over the Job Score.
 * 
 * Should be populated with data from following table ???
 */
public class SkillRequirement implements JobRequirement {
	private List<SkillRequirementModel> skillInstance;
	
	public List<SkillRequirementModel> getSkillList(){
		return skillInstance;
	}
}
