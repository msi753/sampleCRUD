package com.bonobono.web03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bonobono.web03.service.SampleService;

@Controller
public class SampleController {
	@Autowired 
	private SampleService sampleservice;
	//1. 입력 폼
	@GetMapping("/addSample")	//addSample이란 요청을 받으면
	public String addSample() {
		return "addSample";		//view이름을 리턴, template폴더의 addSample.html로 포워딩한다
		
	}
	
	//2. 입력 액션
	@PostMapping
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		//request.getParameter("sampleName")
		/* String sampleName을 만들고 request.getParameter값 sampleName을 가져온다 */
		return "redirect:/sampleList";	//response.sendRedirect
		//redirect라고 써있지 않으면 자동으로 forward된다
	}
	//3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {		//set.attribute 대신 Model
		return "sampleList";
		
	}
	//4. 삭제 액션
	
	//5. 수정 폼
	
	//6. 수정 액션
	
}
