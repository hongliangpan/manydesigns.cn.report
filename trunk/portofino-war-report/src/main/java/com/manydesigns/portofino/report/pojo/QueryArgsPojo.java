package com.manydesigns.portofino.report.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

import com.manydesigns.portofino.report.enums.DocType;
import com.manydesigns.portofino.report.enums.PeriodType;

public class QueryArgsPojo {

    private DocType m_docType;

    private PeriodType m_periodType;

    private String m_startTime;

    private String m_endTime;

    private Map<String, String> m_args = new LinkedHashMap<String, String>();

    /**
     * @return docType -docType{return content description}
     */
    public final DocType getDocType() {
        return m_docType;
    }

    /**
     * @param docType - docType{parameter description}.
     */
    public final void setDocType(final DocType docType) {
        m_docType = docType;
    }

    /**
     * @return periodType -periodType{return content description}
     */
    public final PeriodType getPeriodType() {
        return m_periodType;
    }

    /**
     * @param periodType - periodType{parameter description}.
     */
    public final void setPeriodType(final PeriodType periodType) {
        m_periodType = periodType;
    }

    /**
     * @return startTime -startTime{return content description}
     */
    public final String getStartTime() {
        return m_startTime;
    }

    /**
     * @param startTime - startTime{parameter description}.
     */
    public final void setStartTime(final String startTime) {
        m_startTime = startTime;
    }

    /**
     * @return endTime -endTime{return content description}
     */
    public final String getEndTime() {
        return m_endTime;
    }

    /**
     * @param endTime - endTime{parameter description}.
     */
    public final void setEndTime(final String endTime) {
        m_endTime = endTime;
    }

    /**
     * @return args -args{return content description}
     */
    public final Map<String, String> getArgs() {
        return m_args;
    }

    /**
     * @param args - args{parameter description}.
     */
    public final void setArgs(final Map<String, String> args) {
        m_args = args;
    }

    
}
