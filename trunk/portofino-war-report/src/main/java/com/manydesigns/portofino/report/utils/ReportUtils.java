package com.manydesigns.portofino.report.utils;

import com.manydesigns.portofino.report.pojo.GenerateArgsPojo;
import com.manydesigns.portofino.report.pojo.ReportPojo;

public class ReportUtils {
    /**
     * getFileName.
     * 
     * @param reportPojo
     * @param docType
     * @return String 文件路径 +英文名称+时间+后缀 exportToFile.
     */
    public static String getFileName(final ReportPojo reportPojo, final GenerateArgsPojo paramPojo) {
        return getReportBasePath() + "/" + reportPojo.getNameEn() + paramPojo.getStartTime() + "."
            + paramPojo.getDocType();
    }

    public static String getReportBasePath() {
        return "";
    }
}
