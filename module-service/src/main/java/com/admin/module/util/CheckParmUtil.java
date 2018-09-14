package com.admin.module.util;

import com.admin.module.entity.Borrow;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 校验参数
 */
@Slf4j
public class CheckParmUtil {
    /**
     * 检查发布标的参数
     */
    public static boolean checkAddBorrow(Borrow borrow) {
        List<String> errors = new ArrayList<>();
        if (StringUtils.isBlank(borrow.getName())) {
            errors.add("标的名称不能为空") ;
        }
        if (StringUtils.isBlank(borrow.getAccount())) {
            errors.add("募筹金额不能为空");
        }
        if (borrow.getTimeLimitDay()!=null&&borrow.getTimeLimitDay() <= 0) {
            errors.add("理财期限必须大于0") ;
        }
        if (borrow.getApr()!=null&&borrow.getApr().doubleValue() <= 0) {
            errors.add("年化利率必须大于0") ;
        }

        if (!"0".equals(borrow.getUse()) && StringUtils.isBlank(borrow.getUserName())) {
            errors.add("借款人用户名不能为空");
        }

        if (!"0".equals(borrow.getUse()) && StringUtils.isBlank(borrow.getLoanUsage())) {
           errors.add("借款用途不能为空");
        }

        if (errors.size() != 0) {
            log.warn("校验参数不通过：{}",errors.toString());
            return false;
        }
        log.info("校验通过");
        return true;


    }
}
