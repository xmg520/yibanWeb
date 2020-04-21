package com.mxz.yiban.service;


import com.mxz.yiban.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeberService {

    Member findByName(String name);


    List<Member> findAll(@Param("startLine") int paramInt1, @Param("num") int paramInt2);

    Integer dataLogCount();

    boolean saveMemBer(String studentId, String name,String ybpasswd,String department);
}
