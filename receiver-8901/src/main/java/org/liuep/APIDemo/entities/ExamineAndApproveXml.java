package org.liuep.APIDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "examineAndApprove")
@XmlType(propOrder = {
        "applyType",
        "approveInfs",
        "approveResult",
        "blncId"
})
public class ExamineAndApproveXml {
    private String applyType;
    private ArrayList<ApproveInfXml> approveInfs;
    private String approveResult;

    @NotNull(message = "请输入blncId")
    private Long blncId;
}
