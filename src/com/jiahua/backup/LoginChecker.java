package com.jiahua.backup;

import com.jiahua.security.Decryptor;
import com.jiahua.security.Encryptor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by yu on 10/12/14.
 */

public class LoginChecker {

    public static boolean check(HttpServletRequest request) throws IOException, ServletException {

        // 防止因为第一次访问cookies是null而出错
        if (null == request.getCookies()) {
            return false;
        }

        String userName = null;
        for(Cookie obj : request.getCookies()) {
            if ("userName".equals(obj.getName())) {
                System.out.println("LoginChecker : userName value : " + obj.getValue());
                userName = obj.getName();
                break;
            }
        }
        if (userName == null) {
            return false;
        }

        for(Cookie obj : request.getCookies()) {

            // 先检测是否包含login
            if (obj.getName().equals("login")) {

                System.out.println("LoginChecker : login value : " + obj.getValue());

                // AES解密，查看是否是合法的值
                String decryptedString = "";
                try {
                    decryptedString = Decryptor.decrypt(Encryptor.ENCRYPTION_KEY, obj.getValue().getBytes());
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
                System.out.println("AuthenticationFilter : decryptedString : " + decryptedString);

                // 如何证明是合法的呢，这是个问题
                if (decryptedString.startsWith(userName)) {
                    System.out.println("AuthenticationFilter : 用户已经登陆！");
                    return true;
                }
            }
        }

        return false;
    }
}
