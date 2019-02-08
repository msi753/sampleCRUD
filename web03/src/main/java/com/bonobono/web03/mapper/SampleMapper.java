package com.bonobono.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bonobono.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	//sampleName을 Sample객체에 담은 후 그 값을 입력받아 인서트하는 메서드
	int insertSample(Sample sample);
	List<Sample> sampleList();
}
