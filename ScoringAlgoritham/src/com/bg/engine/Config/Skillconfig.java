package com.bg.engine.config;

/*
 * 
 * 
 */
public class Skillconfig {
	private int minExp;
	private int maxExp;
	private int skillPoints;
	public int getSkillPoint(){
		return skillPoints;
	}
	public boolean isInRange(int monthOfExp){
		if(monthOfExp>minExp && monthOfExp<maxExp){
			return true;
		}
		return false;
	}
}
