package com.mxz.yiban.dao;

import com.mxz.yiban.pojo.NoUpload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoUploadDao {

    @Select("select * from noupload")
    List<NoUpload> findAll();

}
