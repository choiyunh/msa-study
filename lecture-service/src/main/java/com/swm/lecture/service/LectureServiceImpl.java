package com.swm.lecture.service;

import com.swm.lecture.dto.LectureDto;
import com.swm.lecture.jpa.LectureEntity;
import com.swm.lecture.jpa.LectureRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class LectureServiceImpl implements LectureService{
    LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public LectureDto createLecture(LectureDto lectureDto) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        LectureEntity lectureEntity = modelMapper.map(lectureDto, LectureEntity.class);

        lectureRepository.save(lectureEntity);

        return null;
    }

    @Override
    public Iterable<LectureEntity> getAllLecture() {
        return lectureRepository.findAll();
    }
}
