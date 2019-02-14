package com.bonobono.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bonobono.web03.service.SampleService;
import com.bonobono.web03.vo.Sample;

@Controller
public class SampleController {
	@Autowired 
	private SampleService sampleService;
	//1. 입력 폼
	@GetMapping("/addSample")	//addSample이란 요청을 받으면
	public String addSample() {
		return "addSample";		//view이름을 리턴, template폴더의 addSample.html로 포워딩한다
	}
	
	//2. 입력 액션
	@PostMapping("/addSampleAction")
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		//request.getParameter("sampleName")
		/* String sampleName을 만들고 request.getParameter값 sampleName을 가져온다 */
		sampleService.addSample(sampleName);
		return "redirect:/sampleList";	//response.sendRedirect
		//redirect라고 써있지 않으면 자동으로 forward된다
	}
	//3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {		//set.attribute 대신 Model
		List<Sample> listSample = sampleService.getSampleList();
		model.addAttribute("listSample", listSample);
		return "sampleList";
	}
	//4. 삭제 액션
	@GetMapping("/removeSample")
	public String removeSample(@RequestParam(value="sampleId") int sampleId) {
		//스프링의 특성상, vo에 있는 변수명과 동일하다면 
		//새로운 객체 Sample sample = new Sample();을 만들지 않아도
		//vo에 값을 담은 것과 동일한 효과를 낸다
		sampleService.removeSample(sampleId);
		return "redirect:/sampleList";		//response.sendRedirect 
	}
	//5. 수정 폼
	@GetMapping("/modifySample")
	public String getSampleOne(@RequestParam(value="sampleId") int sampleId, Model model) {
		Sample sample = sampleService.selectSampleOne(sampleId);
		model.addAttribute("sample", sample);
		return "/modifySample";
	}
	//6. 수정 액션
	@RequestMapping(value="/modifySampleAction", method=RequestMethod.POST)	//포스트방식으로 보낸 변수들의 값을 받는다
	public String updateSample(Sample sample) {	//Sample객체를 생성한다
		sampleService.modifySample(sample);
		return "redirect:/sampleList";
	}
	
}

