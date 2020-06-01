package com.mxz.yiban;

import com.mxz.yiban.pojo.Member;
import com.mxz.yiban.service.MeberService;
import com.mxz.yiban.utill.JsoupUtill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class YibanApplicationTests {

    @Autowired
    MeberService meberService;

    @Test
    void contextLoads() throws IOException {
        List<Member> allUser = this.meberService.findAll(1,100);
        for (Member user:allUser) {
            String acoount = user.getAccount();
            if(JsoupUtill.isUpload(acoount)){
                user.setIsendupload(0);
            }else {
                user.setIsendupload(1);
            }
            this.meberService.updateEndMemBer(user);
            break;
        }
    }

}
