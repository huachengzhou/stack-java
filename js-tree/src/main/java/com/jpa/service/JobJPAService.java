package com.jpa.service;

import com.jpa.dao.JobJPADao;
import com.jpa.entity.JobJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Lenovo on 2020/8/15.
 */
@Service
public class JobJPAService {

    @Autowired
    private JobJPADao jobJPADao;


    public void saveData(JobJPA jobJPA){
        jobJPADao.save(jobJPA);
    }

    public void saveData(List<JobJPA> jobJPAList) {
        jobJPADao.saveAll(jobJPAList) ;
    }


    public void deleteById(Long id){
        jobJPADao.deleteById(id);
    }

    public List<JobJPA> getDataList(){
        return jobJPADao.findAll();
    }

    public Long getCount(){
        return jobJPADao.count();
    }

}
