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
        approveInf.setActivityName("测试");
        approveInf.setExecutor("测试");
        approveInf.setExecutorName("测试");
        approveInf.setActivityName("测试");
        approveInf.setFinished(dateString);
        approveInf.setId(12);
        approveInf.setOpinion("测试");
        approveInf.setParentId(123);
        approveInf.setPid(123);
        approveInf.setStatus(1);
        approveInf.setStatusName("测试");
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
        approveInfXml.setActivityName("测试");
        approveInfXml.setExecutor("测试");
        approveInfXml.setExecutorName("测试");
        approveInfXml.setActivityName("测试");
        approveInfXml.setFinished(dateString);
        approveInfXml.setId(12);
        approveInfXml.setOpinion("测试");
        approveInfXml.setParentId(123);
        approveInfXml.setPid(123);
        approveInfXml.setStatus(1);
        approveInfXml.setStatusName("测试");
        approveInfXml.setUid(uid);

        approveInfXmls.add(approveInfXml);

        return approveInfXmls;
    }
}
