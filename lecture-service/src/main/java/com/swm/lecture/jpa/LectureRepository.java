package com.swm.lecture.jpa;

import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<LectureEntity, Long> {
    LectureEntity findByLectureId(String lectureId);
}
