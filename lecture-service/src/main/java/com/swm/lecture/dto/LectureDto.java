package com.swm.lecture.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class LectureDto implements Serializable {
    private String lectureCode;
    private String lectureName;
    private Map<String, String> lectureImage;
    private String lectureCategory;
    private List<String> lectureTags;
    private String lectureDescription;
    private String instructorCode;
    private String lectureVendorName;
    private String lectureVendorUrl;
    private Integer lectureOriginalPrice;
    private Integer lectureSalePrice;
    private Integer lectureDeadline;
    private Map<String, String> lectureInfo;
    private Integer lectureLevel;
    private Map<String, String> lectureCurriculum;

    private Date createdAt;
    private Date updatedAt;
}
