package com.jiahua.security;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.util.Map;

/**
 * Created by yu on 9/26/14.
 */

// 为何偏偏这个类需要放到controller包下面
@Controller
public class SecurityImageAction extends ActionSupport {

    public SecurityImageAction() {
        System.out.println("SecurityImageAction...");
    }

    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }


    public String execute() throws Exception {

        //如果开启Hard模式，可以不区分大小写
        //String securityCode = CodeGenerator.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();

        //获取默认难度和长度的验证码
        String securityCode = CodeGenerator.getSecurityCode();
        imageStream = ImageGenerator.getImageAsInputStream(securityCode);

        //放入session中
        Map session =  ActionContext.getContext().getSession();
        session.put("securityCode", securityCode);
        System.out.println("generated securityCode in session: " + session.get("securityCode"));
        return SUCCESS;
    }
}
