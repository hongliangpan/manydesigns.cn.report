package com.manydesigns.portofino.report.export;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manydesigns.elements.ElementsThreadLocals;
import com.manydesigns.elements.messages.SessionMessages;
import com.manydesigns.portofino.report.enums.DocType;
import com.manydesigns.portofino.report.export.builder.ExportUtils;
import com.manydesigns.portofino.report.export.builder.ReportBuilder;
import com.manydesigns.portofino.report.pojo.GenerateArgsPojo;
import com.manydesigns.portofino.report.pojo.QueryArgsPojo;
import com.manydesigns.portofino.report.pojo.ReportPojo;

public class DefaultReportViewer implements IReportViewer {
    public final static Logger logger = LoggerFactory.getLogger(DefaultReportViewer.class);

    @Override
    public Resolution export(final HttpServletRequest request, final ReportPojo reportPojo,
        final QueryArgsPojo queryParamPojo, final String returnUrl) {
        try {
            modifyReportPojo(reportPojo);
            JasperReportBuilder t_builder = getReportBuilder(reportPojo);

            modifyBuilder(t_builder, reportPojo);
            if (DocType.html == queryParamPojo.getDocType()) {
                request.getSession().setAttribute(
                    net.sf.jasperreports.j2ee.servlets.ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
                    t_builder.toJasperPrint());
                return ExportUtils.exportHtml(reportPojo, queryParamPojo.getDocType(), returnUrl, t_builder);
            }

            final File tmpFile =
                File.createTempFile("report." + reportPojo.getNameEn(), ".read." + queryParamPojo.getDocType().name());
            ExportUtils.exportFile(t_builder, tmpFile, queryParamPojo.getDocType());
            FileInputStream fileInputStream = new FileInputStream(tmpFile);

            String contentType = "application/" + queryParamPojo.getDocType().name();
            if (DocType.htmlFile == queryParamPojo.getDocType()) {
                contentType = "text/html; charset=UTF-8";
            }
            return new StreamingResolution(contentType, fileInputStream) {
                @Override
                protected void stream(final HttpServletResponse response) throws Exception {
                    super.stream(response);
                    if (!tmpFile.delete()) {
                        logger.warn("Temporary file {} could not be deleted", tmpFile.getAbsolutePath());
                    }
                }
            }.setFilename(reportPojo.getNameEn() + "." + queryParamPojo.getDocType().name());
        } catch (Exception e) {
            logger.error(queryParamPojo.getDocType().name() + " export failed!" + e.getMessage(), e);
            SessionMessages.addErrorMessage(getMessage("commons.export.failed"));
            return new RedirectResolution(returnUrl);
        }
    }

    /**
     * 修改报表对象,改变报表行为<br>
     * 二次开发回调接口.
     * 
     * @param reportPojo
     */
    @Override
    public void modifyReportPojo(final ReportPojo reportPojo) {
    }

    /**
     * 修改报表Builder,改变报表行为<br>
     * 二次开发回调接口.
     * 
     * @param builder
     */
    protected void modifyBuilder(final JasperReportBuilder builder, final ReportPojo reportPojo) {
    }

    protected String getMessage(final String key, final Object... args) {
        return ElementsThreadLocals.getText(key, args);
    }

    @Override
    public JasperReportBuilder getReportBuilder(final ReportPojo reportPojo) {
        return ReportBuilder.getReportBuilder(reportPojo);
    }

    @Override
    public String exportToFile(final ReportPojo reportPojo, final GenerateArgsPojo generateParamPojo) {
        try {
            modifyReportPojo(reportPojo);
            JasperReportBuilder t_builder = getReportBuilder(reportPojo);

            modifyBuilder(t_builder, reportPojo);
            if (DocType.html == generateParamPojo.getDocType()) {
                return ExportUtils.exportHtml(reportPojo, generateParamPojo.getDocType(), t_builder, generateParamPojo.getFileName());
            }

            String contentType = "application/" + generateParamPojo.getDocType().name();
            if (DocType.htmlFile == generateParamPojo.getDocType()) {
                contentType = "text/html; charset=UTF-8";
            }
            final File tmpFile = new File(generateParamPojo.getFileName());
            ExportUtils.exportFile(t_builder, tmpFile, generateParamPojo.getDocType());

            return "";
        } catch (Exception e) {
            final String t_message = generateParamPojo.getDocType().name() + getMessage("commons.export.failed") + e.getMessage();
            logger.error(t_message, e);
            SessionMessages.addErrorMessage(getMessage("commons.export.failed"));
            return t_message;
        }
    }
}
