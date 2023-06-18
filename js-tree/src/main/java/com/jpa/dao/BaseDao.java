package com.jpa.dao;

/**
 * Created by Lenovo on 2020/8/16.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * jpa会将所有继承 Repository的类进行代理实例化，加上注解就不会
 */
@NoRepositoryBean
public interface BaseDao<T,ID> extends JpaRepository<T,ID> {

}
