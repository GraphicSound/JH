package com.jiahua.user.controller;

import com.jiahua.model.User;
import com.jiahua.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by yu on 9/23/14.
 */

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartAction.class);

    private String username;
    private String password;

    @Autowired
    private UserService userService;

    public LoginAction() {
        log.info("LoginAction...");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {

        String dateString = new Date().toString();
        ActionContext actionContext = ActionContext.getContext();
        // HttpServletResponse response = (HttpServletResponse)actionContext.get(ServletActionContext.HTTP_RESPONSE);

        if (null == username || "".equals(username)) {
            return INPUT;
        }

        // 模拟标记登陆成功
        // 还是使用sessionid
        User user = userService.getUser(username, password);
        if (null != user) {
            log.info("登陆成功！");
            actionContext.getSession().put("user", user);
        } else {
            log.info("登陆失败！");
        }

        return SUCCESS;
    }

    public String logout() {

        Map session =  ActionContext.getContext().getSession();
        session.remove("user");
        log.info("退出成功");
        return SUCCESS;
    }
}
