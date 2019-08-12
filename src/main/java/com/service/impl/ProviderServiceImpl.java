package com.service.impl;

import com.dao.ProviderMapper;
import com.entity.Provider;
import com.service.ProviderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/12/1.
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Resource(name="providerMapper")
    private ProviderMapper providerMapper;

    public List<Provider> getProviderList(@Param("proCode") String proCode, @Param("proName") String proName, @Param("begin") Integer begin, @Param("pageSize") Integer pageSize) {
       begin = (begin-1)*pageSize;
        return providerMapper.getProviderList(proCode,proName,begin,pageSize);
    }

    public int getProviderCount(@Param("proCode") String proCode, @Param("proName") String proName) {
        return providerMapper.getProviderCount(proCode,proName);
    }
    //增加供应商
    public int add(Provider p){
        return providerMapper.add(p);
    }

    public Provider getPro(@Param("id") Integer pid) {
        return providerMapper.getPro(pid);
    }

    public int getCount(@Param("id") Integer pid) {
        return providerMapper.getCount(pid);
    }

    public int delPro(@Param("id") Integer pid) {
        return providerMapper.delPro(pid);
    }
}
