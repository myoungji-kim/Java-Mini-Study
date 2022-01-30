package com.ddingji.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("homeDAO")
public class HomeDAO  {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// Select All
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> select(Map<String, Object> map) {
		return  sqlSession.selectList("home.select", map);
	}

	// Select One - 게시글 수정 페이지용
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectOne(Map<String, Object> map) {
		// map 파라미터 넘겨줘야함!!!
		return  sqlSession.selectOne("home.selectOne", map);
	}

	@SuppressWarnings("unchecked")
	public int countAll() {
		return  sqlSession.selectOne("home.countAll");
	}

	@SuppressWarnings("unchecked")
	public void update(Map<String, Object> map) {
		sqlSession.update("home.update", map);
	}

	@SuppressWarnings("unchecked")
	public void insert(Map<String, Object> map) {
		sqlSession.insert("home.insert", map);
	}

	@SuppressWarnings("unchecked")
	public void delete(Map<String, Object> map) {
		sqlSession.delete("home.delete", map);
	}
}