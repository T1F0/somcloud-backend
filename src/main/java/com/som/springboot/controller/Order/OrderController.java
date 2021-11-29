package com.som.springboot.controller.Order;


import com.som.springboot.entity.WorkOrder;
import com.som.springboot.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private WorkOrderMapper workOrderMapper;


    @GetMapping("/findAll")
    public List<WorkOrder>  find(){
        return workOrderMapper.findAll();
    }

    @GetMapping("/findById")
    public WorkOrder find(Integer id){
        WorkOrder workOrder = workOrderMapper.findById(id);
//        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
//        workOrder.setCreateTime(dFormat.format(workOrder.getCreateTime()));
        //workOrder.setAdminAssignTime(dFormat.format(workOrder.getAdminAssignTime()));
//        workOrder.setAdminConfirmTime(dFormat.format(workOrder.getAdminConfirmTime()));
//        workOrder.setAdminSubmitTime(dFormat.format(workOrder.getAdminSubmitTime()));
//        workOrder.setConsumerConfirmTime(dFormat.format(workOrder.getConsumerConfirmTime()));
        return workOrder;
    }
}
