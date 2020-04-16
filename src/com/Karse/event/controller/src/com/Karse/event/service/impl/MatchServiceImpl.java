package com.Karse.event.service.impl;

import com.Karse.event.dao.MatchDao;
import com.Karse.event.dao.impl.MatchDaoImpl;
import com.Karse.event.service.MatchService;

/**
 * 
 * @author Karse
 *
 */
public class MatchServiceImpl implements MatchService{
	
	private static MatchDao matchDao = new MatchDaoImpl();
	
	
	@Override
	public boolean addMatch(String team1, String team2, String time, String price) {
		if(team1 == null||team2 == null||time == null){
			System.out.println("请求参数有误");
		}
		boolean addMatch = matchDao.addMatch(team1, team2, time, price);
		return addMatch;
		
	}
}
