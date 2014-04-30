package com.manydesigns.portofino.report.export;

import javax.servlet.http.HttpServletRequest;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sourceforge.stripes.action.Resolution;

import com.manydesigns.portofino.report.pojo.GenerateArgsPojo;
import com.manydesigns.portofino.report.pojo.QueryArgsPojo;
import com.manydesigns.portofino.report.pojo.ReportPojo;

public interface IReportViewer {
    /**
     * 导出报表.
     * 
     * @param request
     * @param reportPojo
     * @param docType
     * @param returnUrl
     * @return
     */
    Resolution export(HttpServletRequest request, ReportPojo reportPojo, QueryArgsPojo queryArgsPojo, String returnUrl);

    /**
     * 定期生成报表文件.<br>
     * 
     * @param reportPojo
     * @param docType
     * @param fileName 文件路径 +英文名称+时间+后缀 exportToFile.
     * @return String
     */
    String exportToFile(ReportPojo reportPojo, GenerateArgsPojo generateArgsPojo);

    /**
     * 根据报表id生成 JasperReportBuilder.
     * 
     * @param reportPojo
     * @return
     */
    JasperReportBuilder getReportBuilder(ReportPojo reportPojo);

    /**
     * 二次开发回调接口.
     * 
     * @param reportPojo
     */
    void modifyReportPojo(ReportPojo reportPojo);
}
