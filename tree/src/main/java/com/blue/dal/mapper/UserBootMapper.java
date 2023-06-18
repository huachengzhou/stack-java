package com.blue.dal.mapper;

import com.blue.dal.entity.UserBoot;
import com.blue.dal.entity.UserBootExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBootMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int countByExample(UserBootExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int deleteByExample(UserBootExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int insert(UserBoot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int insertSelective(UserBoot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    List<UserBoot> selectByExample(UserBootExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    UserBoot selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserBoot record, @Param("example") UserBootExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int updateByExample(@Param("record") UserBoot record, @Param("example") UserBootExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int updateByPrimaryKeySelective(UserBoot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_boot
     *
     * @mbggenerated Sat Jan 18 10:56:54 CST 2020
     */
    int updateByPrimaryKey(UserBoot record);
}