package com.mxz.yiban.service.impl;

import com.mxz.yiban.dao.MemberDao;
import com.mxz.yiban.pojo.Member;
import com.mxz.yiban.service.MeberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeberServiceImpl implements MeberService {

    @Autowired
    MemberDao memberDao;

    @Override
    public Member findByName(String name) {
        return memberDao.findByName(name);
    }

    @Override
    public List<Member> findAll(@Param("startLine") int paramInt1, @Param("num") int paramInt2) {
        return memberDao.findAll(paramInt1,paramInt2);
    }

    @Override
    public Integer dataLogCount() {
        return memberDao.dataLogCount();
    }

    @Override
    public boolean saveMemBer(String studentId, String name, String ybpasswd, String department) {
        return memberDao.saveMemBer(studentId,name,ybpasswd,department);
    }
}
