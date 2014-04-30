package com.manydesigns.portofino.report.enums;

import org.apache.commons.lang.StringUtils;

public enum PeriodType {

    hour("hour", "小时"),

    day("day", "日报"),

    week("week", "周报"),

    month("month", "月报"),

    quartz("quartz", "季报"),

    // halfyear("halfyear","半年报"),

    year("year", "年报");

    private final String m_id;
    private final String m_name;

    /**
     * Constructors.
     * 
     * @param name 标识号
     */
    private PeriodType(final String id, final String name) {
        this.m_id = id;
        this.m_name = name;
    }

    /**
     * parse enum.
     * 
     * @param name id
     * @return DataType
     */
    public static PeriodType parse(final String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        for (PeriodType t_generic : PeriodType.values()) {
            if (t_generic.getName().equals(name)) {
                return t_generic;
            }
        }
        return null;
    }

    /**
     * get displayName from i18n
     * 
     * @return displayName
     */
    public String getName() {
        return m_name;
    }

    /**
     * @return id -id{return content description}
     */
    public final String getId() {
        return m_id;
    }
}
