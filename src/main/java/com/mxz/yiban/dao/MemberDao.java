package com.mxz.yiban.dao;

import com.mxz.yiban.pojo.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MemberDao {

    @Select("select * from member where name = #{name}")
    Member findByName(String name);

    @Select({"select * from member limit #{startLine},#{num} "})
    List<Member> findAll(@Param("startLine") int paramInt1, @Param("num") int paramInt2);

    @Select("select count(*) from member")
    Integer dataLogCount();

    @Insert("insert into member (id,account,name,passwd,city,isupload) values (null,#{studentId},#{name},#{ybpasswd},#{department},0)")
    boolean saveMemBer(String studentId, String name,String ybpasswd,String department);

    @Update("update member set account = #{account}, name = #{name},passwd = #{passwd},city = #{city},isupload = #{isupload}  where id = #{id}")
    boolean updateMemBer(Member member);

    @Update("update member set isupload = #{isupload} where id = #{commentId}")
    boolean isDel(Integer commentId, Integer isupload);

    @Delete("delete from member where id = #{commentId}")
    boolean clear(Integer commentId);

    @Update("update member set isendupload = #{isendupload}  where id = #{id}")
    boolean updateEndMemBer(Member member);
}
