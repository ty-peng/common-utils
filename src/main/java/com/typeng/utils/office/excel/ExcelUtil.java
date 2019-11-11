package com.typeng.utils.office.excel;

import java.io.InputStream;
import java.util.Map;

/**
 * Excel导入导出通用工具.
 *
 * @author ty-peng
 * @since 2019/11/6 21:59
 */
public class ExcelUtil {

    private ExcelUtil() {
    }

    /**
     * 导入Excel.
     *
     * @param in
     * @param format
     * @return
     */
    public static Map<String, Object> import4Excel(InputStream in, ExcelFormat format){
        ExcelImportUtil importUtil;
        switch (format) {
            case XLS:
                return null;
            case XLSX:
                return null;
            default:
                return null;
        }
    }

    public static Map<String, Object> export2Excel(InputStream in, ExcelFormat format){
        return null;
    }

}
