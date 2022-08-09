package com.swm.lecture.service;

import com.swm.lecture.dto.LectureDto;
import com.swm.lecture.jpa.LectureEntity;

public interface LectureService {
    LectureDto createLecture(LectureDto lectureDto);
    Iterable<LectureEntity> getAllLecture();
}
