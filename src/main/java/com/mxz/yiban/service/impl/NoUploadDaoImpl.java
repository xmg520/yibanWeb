package com.mxz.yiban.service.impl;


import com.mxz.yiban.dao.NoUploadDao;
import com.mxz.yiban.pojo.NoUpload;
import com.mxz.yiban.service.NoUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoUploadDaoImpl implements NoUploadService {

    @Autowired
    NoUploadDao noUploadDao;

    @Override
    public List<NoUpload> findAll() {
        return noUploadDao.findAll();
    }
}
