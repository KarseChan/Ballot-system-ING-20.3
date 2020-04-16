package com.Karse.event.controller;

import com.Karse.event.service.MatchService;
import com.Karse.event.service.impl.MatchServiceImpl;

/**
 * 
 * @author Karse
 *
 */
public class MatchController {
	
	private static MatchService matchService= new MatchServiceImpl();
	
	/**
	 * ±»»¸ÃÌº”
	 * @param team1
	 * @param team2
	 * @param time
	 * @param price
	 * @return
	 */
	public boolean addMatch(String team1,String team2,String time,String price){
		 boolean addMatch = matchService.addMatch(team1, team2, time, price);
			return addMatch;
	}
}

