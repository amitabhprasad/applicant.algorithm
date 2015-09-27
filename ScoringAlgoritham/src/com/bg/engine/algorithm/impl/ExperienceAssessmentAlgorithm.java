/**
 * 
 */
package com.bg.engine.algorithm.impl;

import java.util.List;

import com.bg.engine.AssessmentAlgorithm;
import com.bg.engine.AssessmentObject;
import com.bg.engine.JobRequirement;
import com.bg.engine.algorithm.data.Employer;

/**
 * @author amitpras
 *
 */
public class ExperienceAssessmentAlgorithm implements AssessmentAlgorithm {

	/* (non-Javadoc)
	 * @see com.bg.engine.AssessmentAlgorithm#doAlgorithum(com.bg.engine.JobRequirement)
	 */
	@Override
	public AssessmentObject doAlgorithum(JobRequirement requirement) {
		List<Employer> employers=null;
		// remove last employer from the last by sorting starting and end date
		
		 List<String>competitorCompanies=null;
		 AssessmentObject expAssessmentObject = new AssessmentObject();
		Employer lastEmployer=null;
		
		double empDurationModifier = getEmployementDurationModifier(employers);
		
		double knownEmployerAssessment = getModifierforKnownEmployer(employers,competitorCompanies);
		double lastCompModifier = getModifierForLastCompany(lastEmployer,competitorCompanies);
		
		double experienceAssessment = lastCompModifier+knownEmployerAssessment+empDurationModifier;
		expAssessmentObject.setAssessmentScore(experienceAssessment);
		return expAssessmentObject;
	}
	
	private double getModifierForLastCompany(Employer lastEmployer,List<String>competitorCompanies){
		double lastCompModifier = 0;
		boolean isWorkingforCompetatiors = false;
		if(competitorCompanies.contains(lastEmployer.getEmployerName())){
			isWorkingforCompetatiors = true;
		}
		double lastJobTenure = computeEmploymentTenure(lastEmployer.getStartingDate(), lastEmployer.getEndDate());
		// his last job is < 12 months
		if(lastJobTenure<12){
			lastCompModifier+=-1;
		}
		if(lastJobTenure>12 && isWorkingforCompetatiors){
			lastCompModifier+=1;
		}
		return lastCompModifier;
	}
	private double getModifierforKnownEmployer(List<Employer> employers, List<String>competitorCompanies){
		// get last 
		double knownCompanyModifiers = 0;
		
		for(Employer employer : employers){
			if(competitorCompanies.contains(employer.getEmployerName())){
				knownCompanyModifiers+=1;
			}
		}
		return knownCompanyModifiers;
	}
	
	private double getEmployementDurationModifier(List<Employer> employers){
		// get employment history form applicant details and check for each employer duration
		double durationModifier = 0.0;
		int tenure = 0;
		for(Employer employer : employers){
			// ensure last job is not part of this loop, one of the possible way is to sort employer list by 
			// starting date and end date and do not use last employer
			tenure += computeEmploymentTenure(employer.getStartingDate(), employer.getEndDate());
		}
		
		double averageTenure = tenure/employers.size();
		if(averageTenure<12){
			durationModifier += -2;
		}
		
		return durationModifier;
	}
	
	// may need some data from screening question, or use current 
	private double isCurrentlyEmployed(){
		boolean employed = false;
		return employed ? -1 : 0;
		
	}
	
	/**
	 * 
	 * @param startingDate
	 * @param endDate
	 * @return tenure in month
	 */
	private int computeEmploymentTenure(String startingDate, String endDate){
		
		// compute date in month using starting and endig date
		// if ending date is not specified then this job is assumed to be current Job and duration should be computed using todays date 
		return 0;
	}
}
