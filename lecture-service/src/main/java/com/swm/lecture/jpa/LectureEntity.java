package com.swm.lecture.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "lecture")
public class LectureEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory")
    private SubCategoryEntity subCategory;

    @Column(nullable = false, unique = true)
    private String lectureCode;
    @Column(nullable = false, unique = true)
    private String lectureName;
    @Column(nullable = false, unique = true)
    private String lectureImage;
    @Column(nullable = false, unique = true)
    private String vendorUrl;
    @Column(nullable = false, length = 50)
    private String vendorName;
    @Column(nullable = false, length = 10000)
    private String lectureInfo;
    @Column(nullable = false)
    private Integer lectureLevel;
    @Column(nullable = false)
    private Integer lectureOriginalPrice;
    @Column(nullable = false)
    private Integer lectureSalePrice;
    @Column(nullable = false)
    private Integer lectureDeadline;

    @Column(nullable = false, updatable = false, insertable = false)
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;


}
