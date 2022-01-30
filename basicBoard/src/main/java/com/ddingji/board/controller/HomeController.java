package com.ddingji.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ddingji.board.dto.PageInfo;
import com.ddingji.board.dto.SetFileName;
import com.ddingji.board.service.HomeService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="homeService")
	private HomeService homeService;

	@Autowired
	ServletContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 * @param totalCount 
	 * @param pageNow 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return "login";
	}

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String loginAction(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id::::"+id);
		System.out.println("pw::::"+pw);

		session.setAttribute("sessionId", String.valueOf(id));
		/* session.setAttribute("sessionPw", pw); */

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/login";
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {

		String pageNum = request.getParameter("no");
		int cTotalCount = homeService.countAll();
		PageInfo paging = new PageInfo(cTotalCount, pageNum);

		// 세션 연습
		// 처음에 null로 받아주고 true 체크
		HttpSession session = request.getSession(true);
		if (session.getAttribute("sessionId") == null) {
			System.out.println("로그인 정보 없음");
			return "redirect:/login";
		}

		Map<String, Object> map = paging.getMapInfo();
		Map<String, Object> page = paging.getPageInfo();

		model.addAttribute("select", homeService.select(map));
		model.addAttribute("page", page);

		return "home";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request ) {
		String no = request.getParameter("no");
		/* model.addAttribute("attributeName", no); */

		HttpSession session = request.getSession(false);
		//session.setAttribute("sessionTest", String.valueOf("adf#"));

		// 세션 테스트
//		System.out.println(session.getAttribute("sessionTest"));

		if (no == null) {
			model.addAttribute("selectOne", null);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no", Integer.parseInt(no));
			model.addAttribute("selectOne", homeService.selectOne(map));
		}

		return "edit";
	}

	@RequestMapping(value = "/edit.action", method = RequestMethod.POST)
	public String editAction(Model model, HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		//session.setAttribute("sessionTest", String.valueOf("adf#"));

		// NO
		String no = request.getParameter("no");
		map.put("no", no);

		// TITLE
		String title = request.getParameter("title");
		map.put("title", title);

		// TEXT
		String text = request.getParameter("text");
		map.put("text", text);

		// FILE - 1
		String docPath = null;

		// // Multipart Request 가져오기 (enctype)
		MultipartHttpServletRequest fileRequest = (MultipartHttpServletRequest) request;
		// System.out.println("fileRequest: "+ fileRequest);
		// // 업로드 file 태그 정보 가져오기
		MultipartFile mf = fileRequest.getFile("file1");

		// 저장경로
		docPath = context.getRealPath("/resources/upload") + "/";

		// 경로 존재 유무 확인 후 생성
		File file = new File(docPath);
		if (!file.exists()) {
			//			logger.info("uploadPath create");
			file.mkdirs();
		}

		// 원본 파일명 가져오기 
		String fileNameOrig = mf.getOriginalFilename();
		System.out.println("filenameOrig(Before): " + fileNameOrig);

		// ----- 수정해야 하는 파트 -------

		// 파일명이 있을 경우 (업로드 파일이 있을 경우)
		if (!fileNameOrig.isEmpty()) {
			logger.info("uploadPath: {}", docPath);
			logger.info("upload start");
			
			// 중복 파일명 비교 및 변경
			SetFileName sfn = new SetFileName();
			fileNameOrig = sfn.getFileNameOrig(file, fileNameOrig);

			System.out.println("filenameOrig(After): " + fileNameOrig);

			// 저장경로 + 원본 파일명
			file = new File(docPath + fileNameOrig);
			try {
				mf.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// ----------------------------

		map.put("file1", fileNameOrig);

		// CRUD MODE
		String mode = request.getParameter("mode");
		System.out.println(mode);
		if (mode.equals("update")) {
			homeService.update(map);
		} else if (mode.equals("insert")) {
			homeService.insert(map);
		} else if (mode.equals("delete")) {
			homeService.delete(map);
		}

		return "redirect:/";
	}


	@RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
	public void favicon( HttpServletRequest request, HttpServletResponse reponse ) {
		try {
			reponse.sendRedirect("/resources/favicon.ico");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
