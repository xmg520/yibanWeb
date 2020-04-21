package com.mxz.yiban.dao;

import com.mxz.yiban.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {

    @Select("select * from member where name = #{name}")
    Member findByName(String name);

    @Select({"select * from member where isupload = 0 limit #{startLine},#{num} "})
    List<Member> findAll(@Param("startLine") int paramInt1, @Param("num") int paramInt2);

    @Select("select count(*) from member")
    Integer dataLogCount();

    @Insert("insert into member (id,account,name,passwd,city) values (null,#{studentId},#{name},#{ybpasswd},#{department})")
    boolean saveMemBer(String studentId, String name,String ybpasswd,String department);
}
