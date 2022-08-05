package com.example.examplespring.framework.util;

import com.example.examplespring.mvc.domain.BaseCodeLabelEnum;
import org.springframework.util.ObjectUtils;

public class EnumUtils {

    /**
     * @param values 파라미터로 넘어온 선택된 값들
     * @param codeEnum 현재 출력하고 있는 code
     * @return
     */
    public static boolean isSelected(BaseCodeLabelEnum[] values, BaseCodeLabelEnum codeEnum) {
        if (ObjectUtils.isEmpty(values))
            return false;
        for (BaseCodeLabelEnum value : values) {
            // 동일하면
            if (value.code().equals(codeEnum.code()))
                return true;
        }
        return false;
    }
}
