package com.example.file.Model;

import org.apache.ibatis.annotations.Mapper;

import javax.persistence.*;

@Entity
@Mapper
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20) comment '文件id'")
    private Long fileId;

    @Column(columnDefinition = "varchar(500) comment '时间戳名称'")
    private String timeStampName;

    @Column(columnDefinition = "varchar(500) comment '文件url'")
    private String fileUrl;

    @Column(columnDefinition = "bigint(10) comment '文件大小'")
    private Long fileSize;
}
