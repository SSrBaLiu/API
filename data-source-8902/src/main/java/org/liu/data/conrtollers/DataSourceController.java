package org.liu.data.conrtollers;

import org.liu.data.entities.CommonResult;
import org.liu.data.entities.ExamineAndApprove;
import org.liu.data.util.DataCreater;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    DataCreater dataCreater;

    @RequestMapping("/objSource")
    public CommonResult<ExamineAndApprove> objSource(){
        CommonResult<ExamineAndApprove> commonResult = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ExamineAndApprove examineAndApprove = dataCreater.createExamineAndApprove();
        HttpEntity<ExamineAndApprove> entity = new HttpEntity<>(examineAndApprove,headers);

        commonResult = restTemplate.postForObject("http://localhost:8901/receiver/getExamineAndApproveFromRemote",entity,CommonResult.class);

        return commonResult;
    }


}
