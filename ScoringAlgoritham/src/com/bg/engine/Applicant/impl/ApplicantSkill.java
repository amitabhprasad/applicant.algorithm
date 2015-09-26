/**
 * 
 */
package com.bg.engine.Applicant.impl;

import java.util.List;
import com.bg.engine.ApplicantDetails;
import com.bg.engine.ApplicantModel.impl.ApplicantSkillModel;


/**
 * @author amitpras
 *
 */
public class ApplicantSkill implements ApplicantDetails{
	private List<ApplicantSkillModel> skillInstance;
	
	public List<ApplicantSkillModel> getSkillList(){
		return skillInstance;
	}
}
