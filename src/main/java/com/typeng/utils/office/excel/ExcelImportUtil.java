package com.typeng.utils.office.excel;

import java.io.InputStream;
import java.util.Map;

/**
 * Excel 导入工具类.
 *
 * @author ty-peng
 * @since 2019/11/7 09:21
 */
public interface ExcelImportUtil {

    Map<String, Object> importXLS(InputStream inputStream);

    Map<String, Object> importXLSX(InputStream inputStream);
}
