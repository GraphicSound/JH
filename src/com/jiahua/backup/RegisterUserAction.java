package com.jiahua.backup;

import com.jiahua.model.User;
import com.jiahua.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yu on 9/23/14.
 */

@Controller
@Scope("prototype")
public class RegisterUserAction extends ActionSupport {
    private String userName;
    private String password;
    private String confirmPassword;
    private String realName;
    private String idNumber;
    private String telno;

    @Autowired
    private UserService userService;

    public RegisterUserAction() {
        System.out.println("RegisterUserAction...");
    }

    @RequiredStringValidator(
            key = "error.userName.required",
            trim = true,
            shortCircuit = true
    )
    @StringLengthFieldValidator(
            key = "error.userName.length",
            minLength = "5",
            maxLength = "20"
    )
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(
            key = "error.password.required",
            trim = true,
            shortCircuit = true
    )
    @StringLengthFieldValidator(
            key = "error.password.length",
            minLength = "5",
            maxLength = "20"
    )
    public void setPassword(String password) {
        this.password = password;
    }

    @RequiredStringValidator(
            key = "error.confirmPassword.required",
            trim = true,
            shortCircuit = true
    )
    @StringLengthFieldValidator(
            key = "error.confirmPassword.length",
            minLength = "5",
            maxLength = "20"
    )
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @RequiredStringValidator(
            key = "error.realName.required",
            trim = true,
            shortCircuit = true
    )
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @RequiredStringValidator(
            key = "error.idNumber.required",
            trim = true,
            shortCircuit = true
    )
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @RequiredStringValidator(
            key = "error.telno.required",
            trim = true,
            shortCircuit = true
    )
    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {

        // 创建user对象
        User user = new User();
        userService.insertUser(user);

        // request, 不用放到session，因为用处不大
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST);
        request.setAttribute("registeredUser", user);

        return SUCCESS;
    }
}
