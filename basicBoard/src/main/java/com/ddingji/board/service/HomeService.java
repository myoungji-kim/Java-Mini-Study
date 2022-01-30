package com.ddingji.board.service;

import com.ddingji.board.dao.HomeDAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeService {
	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);

	@Resource(name="homeDAO")
	private HomeDAO homeDAO;

	public List<Map<String, Object>> select(Map<String, Object> map) {
		return homeDAO.select(map);
	}

	public Map<String, Object> selectOne(Map<String, Object> map) {
		return homeDAO.selectOne(map);
	}

	public int countAll() {
		return homeDAO.countAll();
	}

	public void update(Map<String, Object> map) {
		homeDAO.update(map);
	}

	public void insert(Map<String, Object> map) {
		homeDAO.insert(map);
	}

	public void delete(Map<String, Object> map) {
		homeDAO.delete(map);
	}


}
