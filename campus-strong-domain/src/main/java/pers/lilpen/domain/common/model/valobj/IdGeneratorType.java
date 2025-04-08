package pers.lilpen.domain.common.model.valobj;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
public enum IdGeneratorType {
    /**
     * 雪花算法
     */
    SNOWFLAKE,

    /**
     * UUID
     */
    UUID,

    /**
     * 数据库自增
     */
    AUTO_INCREMENT,

    /**
     * 自定义
     */
    CUSTOM;

    public static final String DEFAULT = SNOWFLAKE.name();
}
