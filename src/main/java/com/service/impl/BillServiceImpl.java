package com.service.impl;

import com.dao.BillMapper1;
import com.entity.Bill;
import com.service.BillService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */
@Service("billService")
public class BillServiceImpl implements BillService {
    @Resource(name="billMapper1")
    private BillMapper1 billMapper1;
    public List<Bill> getBillList(@Param("productName")String productName,@Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment,@Param("begin")Integer begin,@Param("pageSize")Integer pageSize) {
        begin = (begin-1)*pageSize;
        return billMapper1.getBillList(productName,providerId,isPayment,begin,pageSize);
    }

    public int getBillListCount(@Param("productName")String productName, @Param("providerId")Integer providerId, @Param("isPayment")Integer isPayment) {
        return billMapper1.getBillListCount(productName,providerId,isPayment);
    }
}
