package com.swm.lecture.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestLecture {
    @NotNull
    private String lectureCode;

    @NotNull
    private String lectureName;

    @NotNull
    private Map<String, String> lectureImage;

    @NotNull
    private String lectureCategory;

    @NotNull
    private List<String> lectureTags;

    @NotNull
    private String lectureDescription;

    @NotNull
    private String instructorCode;

    @NotNull
    private String lectureVendorName;

    @NotNull
    private String lectureVendorUrl;

    @NotNull
    private Integer lectureOriginalPrice;

    @NotNull
    private Integer lectureSalePrice;

    @NotNull
    private Integer lectureDeadline;

    @NotNull
    private Map<String, String> lectureInfo;

    @NotNull
    private Integer lectureLevel;

    @NotNull
    private Map<String, String> lectureCurriculum;
}
