package com.manydesigns.portofino.report.pojo;

public class GenerateArgsPojo extends QueryArgsPojo {

    private String m_fileName;

    /**
     * @return fileName -fileName{return content description}
     */
    public final String getFileName() {
        return m_fileName;
    }

    /**
     * @param fileName - fileName{parameter description}.
     */
    public final void setFileName(final String fileName) {
        m_fileName = fileName;
    }
}
