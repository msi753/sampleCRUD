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
		List<Sample> listSample = sampleMapper.sampleList();
		return listSample;		
	}
	public Sample selectSampleOne(int sampleId) {
		Sample sample = sampleMapper.selectSampleOne(sampleId);
		return sample;	
		}	
	public int addSample(String sampleName) {
		int result = 0;
		result = sampleMapper.insertSample(sampleName);
		System.out.println(result + " <-result");
		return result;		
	}	
	public int removeSample(int sampleId) {
		int result = 0;
		result = sampleMapper.deleteSample(sampleId);
		System.out.println(result + " <-result");
		return result;		
	}	
	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
		//update쿼리문을 실행한 후 결과를 리턴한다(성공:1, 실패:0)
	}
}

