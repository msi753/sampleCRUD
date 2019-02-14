package com.bonobono.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bonobono.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	//sampleName을 Sample객체에 담은 후 그 값을 입력받아 인서트하는 메서드
	int insertSample(String sampleName);
	//sampleList를 보여주기 위한 메서드(리턴값은 배열)
	List<Sample> sampleList();
	//sampleId에 해당하는 값을 삭제하는 메서드
	int deleteSample(int sampleId);
	//sampleId에 해당하는 값을 하나 골라서 sample객체에 담는 메서드
	Sample selectSampleOne(int sampleId);
	//sample객체에 담긴 값을 업데이트하는 메서드
	int updateSample(Sample sample);
}

