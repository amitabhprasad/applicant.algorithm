/**
 * 
 */
package com.bg.engine;

import com.bg.engine.applicant.impl.ApplicantDetails;
import com.bg.engine.config.AlgoConfig;

/**
 * @author amitpras
 *
 */
public interface AssessmentAlgorithm {

	public AssessmentObject doAlgorithum(JobRequirement requirement,ApplicantDetails applicantObject,AlgoConfig configInstance);
}
