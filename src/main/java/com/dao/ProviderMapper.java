package com.dao;

import com.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/12/1.
 */
public interface ProviderMapper {
    //获取列表
    public List<Provider> getProviderList(@Param("proCode") String proCode ,@Param("proName")String proName, @Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    //获取数量
    public int getProviderCount(@Param("proCode") String proCode ,@Param("proName")String proName);

    //增加供应商
    public int add(Provider p);

    //查看供应商
    public Provider getPro(@Param("id") Integer pid);
    //根据id查看该供应商下是否有未完成订单
    public int getCount(@Param("id") Integer pid);
    //开始删除
   public  int delPro(@Param("id") Integer pid);
}
