package org.liu.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamineAndApproveDB {
    private String applyType;
    /**
     * approveList 里以英文逗号隔开每个approveInf的名字以存储进数据库
     */
    private String approveList;
    private String approveResult;

    @NotNull(message = "请输入blncId")
    private Long blncId;
}
