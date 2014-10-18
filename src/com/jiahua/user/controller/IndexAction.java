package com.jiahua.user.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller
public class IndexAction extends ActionSupport {

    public IndexAction() {
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
