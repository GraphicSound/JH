package com.jiahua.user.service;

import com.jiahua.model.Movie;
import com.jiahua.model.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu on 9/23/14.
 */

@Service
public class MovieService {

    @Autowired
    private MovieDAO movieDAO;

    public MovieService() {}

    public List<Movie> getAllMovie() throws Exception  {
        List<Movie> list = null;
        list = (List<Movie>)movieDAO.findAll();
        return list;
    }
}
