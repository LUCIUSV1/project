package com.dao;

import com.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */
public interface BillMapper1 {
    //得到订单列表
    public List<Bill> getBillList(@Param("productName")String productName,@Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment,@Param("begin")Integer begin,@Param("pageSize")Integer pageSize);
    //得到订单数量
    public int getBillListCount(@Param("productName")String productName,@Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment);
}
