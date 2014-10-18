package com.jiahua.user.service;

import com.jiahua.model.Arrangement;
import com.jiahua.model.ArrangementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu on 9/23/14.
 */

@Service
public class ArrangementService {

    @Autowired
    private ArrangementDAO arrangementDAO;

    public ArrangementService() {}

    public List<Arrangement> getAllArrangement() throws Exception  {
        List<Arrangement> list = null;
        list = (List<Arrangement>)arrangementDAO.findAll();
        return list;
    }
}
