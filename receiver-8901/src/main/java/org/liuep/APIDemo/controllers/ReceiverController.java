package org.liuep.APIDemo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.liuep.APIDemo.entities.ApproveInf;
import org.liuep.APIDemo.entities.CommonResult;
import org.liuep.APIDemo.entities.ExamineAndApprove;
import org.liuep.APIDemo.entities.ExamineAndApproveDB;
import org.liuep.APIDemo.services.ReceiverService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/receiver")
@RestController
@Slf4j
public class ReceiverController {

    @Resource
    ReceiverService receiverService;

    @RequestMapping(value = "/getExamineAndApproveFromRemote")
    public CommonResult<ExamineAndApprove> getExamineAndApproveFromRemote(
            @RequestBody ExamineAndApprove examineAndApprove){
        //控制判断
        if (examineAndApprove == null || examineAndApprove.getBlncId() == null){
            return new CommonResult(444,"非法数据，拒绝接收");
        }

        ExamineAndApproveDB examineAndApproveDB = new ExamineAndApproveDB();

        //转移不需要变形的数据
        examineAndApproveDB.setApplyType(examineAndApprove.getApplyType());
        examineAndApproveDB.setApproveResult(examineAndApprove.getApproveResult());
        examineAndApproveDB.setBlncId(examineAndApprove.getBlncId());

        //完整审批信息可能包含多个数组内容(approveInf)，创建一个strBuilder来循环添加信息
        StringBuilder stringBuilder = new StringBuilder();

        //第一个以字符串形式存储uid的approveInf不用在前头添加一个逗号
        if (examineAndApprove.getApproveInfs().size() > 0){
            stringBuilder.append(examineAndApprove.getApproveInfs().get(0).getUid());
            //往数据库中写入uid对应的approveInf
//            log.info(""+examineAndApprove.getApproveInfs().get(0));
            saveApproveInf(examineAndApprove.getApproveInfs().get(0));
        }

        //出去第一个approve的索引信息uid，其余的通过英文逗号分隔开
        for (int i = 1; i < examineAndApprove.getApproveInfs().size(); i++) {
            stringBuilder.append(",");
            stringBuilder.append(examineAndApprove.getApproveInfs().get(i).getUid());
            //往数据库中写入uid对应的approveInf
            saveApproveInf(examineAndApprove.getApproveInfs().get(i));
        }

        //把uid的索引串填入存储用实例
        examineAndApproveDB.setApproveList(stringBuilder.toString());

        //把存储用实例写入数据库
        receiverService.saveExamineAndApproveDB(examineAndApproveDB);

        //往网页返回一个结果
        return new CommonResult(200,"数据获取成功，已存入数据库",examineAndApprove);
    }

    private int saveApproveInf(ApproveInf approveInf){
        if (approveInf == null || approveInf.getUid() == null){
            return -1;
        }
//        log.info("save :"+approveInf);

        return receiverService.saveApproveInf(approveInf);
    }
}
