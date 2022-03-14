package org.liuep.APIDemo.Impl;

import lombok.extern.slf4j.Slf4j;
import org.liuep.APIDemo.DAO.ReceiverDAO;
import org.liuep.APIDemo.entities.ApproveInf;
import org.liuep.APIDemo.entities.ExamineAndApprove;
import org.liuep.APIDemo.entities.ExamineAndApproveDB;
import org.liuep.APIDemo.services.ReceiverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ReceiverImpl implements ReceiverService {

    @Resource
    ReceiverDAO receiverDAO;

    @Override
    public int saveApproveInf(ApproveInf approveInf) {
//        log.info("receiverDAO: " + receiverDAO);
        return receiverDAO.saveApproveInf(approveInf);
    }

    @Override
    public int saveExamineAndApproveDB(ExamineAndApproveDB examineAndApproveDB) {
        return receiverDAO.saveExamineAndApproveDB(examineAndApproveDB);
    }

    @Override
    public ApproveInf getApproveInf(String uid) {
        return receiverDAO.getApproveInf(uid);
    }

    @Override
    public ExamineAndApproveDB getExamineAndApproveDB(Long blncId) {
        return receiverDAO.getExamineAndApproveDB(blncId);
    }
}
