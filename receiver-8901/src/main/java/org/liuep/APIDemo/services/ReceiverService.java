package org.liuep.APIDemo.services;

import org.apache.ibatis.annotations.Param;
import org.liuep.APIDemo.entities.ApproveInf;
import org.liuep.APIDemo.entities.ExamineAndApproveDB;

public interface ReceiverService {
    public int saveApproveInf(ApproveInf approveInf);
    public int saveExamineAndApproveDB(ExamineAndApproveDB examineAndApproveDB);
    public ApproveInf getApproveInf(@Param("uid") String uid);
    public ExamineAndApproveDB getExamineAndApproveDB(@Param("blncId") Long blncId);
}
