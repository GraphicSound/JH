package com.jiahua.backup;

import com.jiahua.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by yu on 9/23/14.
 */

@Controller
@Scope("prototype")
public class XLoginAction extends ActionSupport {

    private String userName;
    private String password;

    @Autowired
    private UserService userService;

    public XLoginAction() {
        System.out.println("LoginAction...");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String execute() throws Exception {

        if (userName.equals("admin") && password.equals("admin")) {
            String dateString = new Date().toString();
            ActionContext actionContext = ActionContext.getContext();
            HttpServletResponse response = (HttpServletResponse)actionContext.get(ServletActionContext.HTTP_RESPONSE);

            // 模拟标记登陆成功
            // 添加login

            /*
            // 值用日期作为内容，用base64进行加密
            Base64.Encoder encoder = Base64.getEncoder();
            String encryptedString = encoder.encodeToString(dateString.getBytes(Charset.forName("UTF-8")));

            // 值用日期作为内容，用AES进行加密
            Cookie userNameCookie = new Cookie("userName", userName);
            response.addCookie(userNameCookie);

            // 以用户名开头，作为验证凭据
            // 必须保证value长度也是16的倍数位
            StringBuilder tmpString = new StringBuilder();
            if (userName.length() < 16) {
                tmpString.append(userName);
                for (int i = userName.length(); i <=16; i++) {
                    tmpString.append((int)(Math.random() * 10));
                }
            }
            String ENCRYPTION_VALUE = tmpString.toString(); // 有特殊字符，不知道是编码问题，还是必须是就是会出来特殊字符，需要再处理一下

            byte[] bytes = Encryptor.encrypt(Encryptor.ENCRYPTION_KEY, ENCRYPTION_VALUE);
            String encryptedString = new String(bytes);
            System.out.println("LoginAction : encryptedString : " + encryptedString);
            Cookie loginCookie = new Cookie("login", encryptedString);
            response.addCookie(loginCookie);
            */
        }

        return SUCCESS;
    }
}
