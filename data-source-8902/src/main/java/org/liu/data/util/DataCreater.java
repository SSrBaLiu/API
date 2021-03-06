package org.liu.data.util;

import org.liu.data.entities.ApproveInf;
import org.liu.data.entities.ApproveInfXml;
import org.liu.data.entities.ExamineAndApprove;
import org.liu.data.entities.ExamineAndApproveXml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class DataCreater {

    public ExamineAndApproveXml createExamineAndApproveXml(){
        ExamineAndApproveXml examineAndApproveXml = new ExamineAndApproveXml();
        examineAndApproveXml.setApplyType("A");
        examineAndApproveXml.setApproveResult("0");

        Random random = new Random();
        Long numForBlncId = random.nextLong()%10000000;
        if (numForBlncId < 0){
            numForBlncId += 10000000;
        }
        examineAndApproveXml.setBlncId(numForBlncId);

        int numForUid = random.nextInt()%10000;
        if (numForUid < 0){
            numForUid += 10000;
        }
        String uid = "asia"+numForUid;

        ArrayList<ApproveInfXml> approveInfXmls = createApproveInfXmls(uid);

        examineAndApproveXml.setApproveInfs(approveInfXmls);
        return examineAndApproveXml;
    }

    public ExamineAndApprove createExamineAndApprove(){
        ExamineAndApprove examineAndApprove = new ExamineAndApprove();
        examineAndApprove.setApplyType("A");
        examineAndApprove.setApproveResult("0");

        Random random = new Random();
        Long numForBlncId = random.nextLong()%10000000;
        if (numForBlncId < 0){
            numForBlncId += 10000000;
        }
        examineAndApprove.setBlncId(numForBlncId);

        int numForUid = random.nextInt()%10000;
        if (numForUid < 0){
            numForUid += 10000;
        }
        String uid = "asia"+numForUid;

        ArrayList<ApproveInf> approveInfs = createApproveInfs(uid);

        examineAndApprove.setApproveInfs(approveInfs);
        return examineAndApprove;
    }

    public ArrayList<ApproveInf> createApproveInfs(String uid){
        ArrayList<ApproveInf> approveInfs = new ArrayList<ApproveInf>();

        ApproveInf approveInf = new ApproveInf();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);

        approveInf.setUid(uid);
        approveInf.setActivityLabel("123");
        approveInf.setActivityName("??????");
        approveInf.setExecutor("??????");
        approveInf.setExecutorName("??????");
        approveInf.setActivityName("??????");
        approveInf.setFinished(dateString);
        approveInf.setId(12);
        approveInf.setOpinion("??????");
        approveInf.setParentId(123);
        approveInf.setPid(123);
        approveInf.setStatus(1);
        approveInf.setStatusName("??????");
        approveInf.setUid(uid);

        approveInfs.add(approveInf);

        return approveInfs;
    }

    public ArrayList<ApproveInfXml> createApproveInfXmls(String uid){
        ArrayList<ApproveInfXml> approveInfXmls = new ArrayList<ApproveInfXml>();

        ApproveInfXml approveInfXml = new ApproveInfXml();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);

        approveInfXml.setUid(uid);
        approveInfXml.setActivityLabel("123");
        approveInfXml.setActivityName("??????");
        approveInfXml.setExecutor("??????");
        approveInfXml.setExecutorName("??????");
        approveInfXml.setActivityName("??????");
        approveInfXml.setFinished(dateString);
        approveInfXml.setId(12);
        approveInfXml.setOpinion("??????");
        approveInfXml.setParentId(123);
        approveInfXml.setPid(123);
        approveInfXml.setStatus(1);
        approveInfXml.setStatusName("??????");
        approveInfXml.setUid(uid);

        approveInfXmls.add(approveInfXml);

        return approveInfXmls;
    }
}
