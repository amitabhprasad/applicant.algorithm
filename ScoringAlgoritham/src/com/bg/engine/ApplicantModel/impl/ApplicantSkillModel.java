/**
 * 
 */
package com.bg.engine.ApplicantModel.impl;

/**
 * @author amitpras
 *
 */
public class ApplicantSkillModel {
	private String name;
	private int experience;
	private int level;
	public String getName(){
		return name;
	}
	
	public int getExperience(){
		return experience;
	}
	
	public int getLevel(){
		if(experience>=0 && experience<=2){
			level = 1;
		}else if (experience>2 && experience<=3){
			level = 2;
		}
		else if (experience>3 && experience<=5){
			level = 3;
		}
		else if (experience>5 && experience<=10){
			level = 4;
		}
		else if (experience>10){
			level = 5;
		}
		return level;
	}
	@Override
	public boolean equals(Object o) 
	{
	    if (o instanceof ApplicantSkillModel) 
	    {
	    	ApplicantSkillModel c = (ApplicantSkillModel) o;
	    	if ( this.name.equals(c.name) )
	    		return true;
	    }
	    return false;
	}
}
