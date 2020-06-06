package com.typeng.utils.codegen;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Bean 属性拷贝代码生成工具.
 *
 * @author ty-peng
 * @date 2020-06-06 15:55
 */
public class BeanCopyCodeGenerator {

    private static final String STATEMENT_TEMPLATE = "this.{{0}} = {{1}}.get{{2}}();";
    private static final String STATEMENT_TEMPLATE_2 = "set{{0}}({{1}}.get{{2}}());";

    /**
     * 生成 source -> target 代码.
     * 
     * @param target target
     * @param source source
     */
    public static void gen(Class<?> target, Class<?> source) {
        Field[] targetFields = target.getDeclaredFields();
        Field[] sourceFields = source.getDeclaredFields();
        Map<String, Field> sourceFieldMap = new HashMap<>(sourceFields.length);
        Arrays.stream(sourceFields).forEach(field -> sourceFieldMap.put(field.getName(), field));
        for (Field targetField : targetFields) {
            if (targetField.getName().contains("this")) {
                continue;
            }
            Field sourceField = sourceFieldMap.get(targetField.getName());
            if (sourceField != null && targetField.getType().equals(sourceField.getType())) {
                String statement = STATEMENT_TEMPLATE.replace("{{0}}", targetField.getName())
                    .replace("{{1}}", makeFirstLetterLowercase(source.getSimpleName()))
                    .replace("{{2}}", makeFirstLetterUppercase(sourceField.getName()));
                System.out.println(statement);
            }
        }
    }

    public static void listAllThisFields(Class<?> target) {
        handleAllFields(target, fieldName -> System.out.println("this." + fieldName + " = ;"));
    }

    public static void listAllSetters(Class<?> target) {
        String setterPrefix = "set";
        String suffix = "();";
        handleAllFields(target, fieldName -> System.out.println(setterPrefix + makeFirstLetterUppercase(fieldName) + suffix));
    }

    public static void listAllGetters(Class<?> target) {
        String getterPrefix = "get";
        String suffix = "();";
        handleAllFields(target, fieldName -> System.out.println(getterPrefix + makeFirstLetterUppercase(fieldName) + suffix));
    }

    private static void handleAllFields(Class<?> target, Consumer<String> consumer) {
        Field[] fields = target.getDeclaredFields();
        for (Field targetField : fields) {
            if (targetField.getName().contains("this")) {
                continue;
            }
            consumer.accept(targetField.getName());
        }
    }

    private static String makeFirstLetterLowercase(String str) {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    private static String makeFirstLetterUppercase(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

}
