package com.swm.lecture.controller;

import com.swm.lecture.dto.LectureDto;
import com.swm.lecture.service.LectureService;
import com.swm.lecture.vo.RequestLecture;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture_service")
public class LectureController {
    Environment env;
    LectureService lectureService;

    @Autowired
    public LectureController(Environment env, LectureService lectureService) {
        this.env = env;
        this.lectureService = lectureService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in lecture service on PORT %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/lecture")
    public String createLecture(@RequestBody RequestLecture lecture) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        LectureDto lectureDto = mapper.map(lecture, LectureDto.class);
        lectureService.createLecture(lectureDto);

        return "Create Lecture method is called";
    }

//    @GetMapping("lecture")
//    public ResponseEntity<List<ResponseLecture>> getLectures() {
//        Iterable<LectureEntity> lectureList = lectureService.getAllLecture();
//
//        List<ResponseLecture> result = new ArrayList<>();
//        lectureList.forEach(v -> {
//            result.add(new ModelMapper().map(v, ResponseLecture.class));
//        });
//    }
}
