package com.bonobono.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonobono.web03.mapper.SampleMapper;
import com.bonobono.web03.vo.Sample;

//Service도 bean빈의 한 종류
@Service	
public class SampleService {
	@Autowired 
	private SampleMapper sampleMapper;
	
	public List<Sample> getSampleList() {
		return null;		
	}
	public List<Sample> getSampleOne() {
		return null;		
	}	
	public int addSample(Sample sample) {
		int result = 0;
		result = sampleMapper.insertSample(sample);
		System.out.println(result + " <-result");
		return result;		
	}	
	public int removeSample(Sample sample) {
		return 1;		
	}	
	public int modifySample(Sample sample) {
		return 1;		
	}
}
