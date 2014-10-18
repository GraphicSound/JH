package com.jiahua.user.controller;

import com.jiahua.model.Arrangement;
import com.jiahua.model.Movie;
import com.jiahua.user.service.ArrangementService;
import com.jiahua.user.service.MovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShowTicketsAction extends ActionSupport {
    
    @Autowired
    private MovieService movieService;
    @Autowired
    private ArrangementService arrangementService;

    public ShowTicketsAction() {
    }

    @Override
    public String execute() throws Exception {
        
        // 先获取movie
        List<Movie> movies = movieService.getAllMovie();
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST);
        actionContext.getSession().put("movies", movies);

        // 再获取arrangement
        List<Arrangement> arrangements = arrangementService.getAllArrangement();
        actionContext.getSession().put("arrangements", arrangements);
        
        return SUCCESS;
    }
}
