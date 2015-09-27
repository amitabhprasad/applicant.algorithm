/**
 * 
 */
package com.bg.engine.requirementmodel.impl;

/**
 * @author amitpras
 *
 */
public class SkillRequirementModel {
	private String name;
	private int level;
	
	public String getName(){
		return name;
	}
	
	public int getLevel(){
		return level;
	}
	@Override
	public boolean equals(Object o) 
	{
	    if (o instanceof SkillRequirementModel) 
	    {
	    	SkillRequirementModel c = (SkillRequirementModel) o;
	    	if ( this.name.equals(c.name) )
	    		return true;
	    }
	    return false;
	}
}
