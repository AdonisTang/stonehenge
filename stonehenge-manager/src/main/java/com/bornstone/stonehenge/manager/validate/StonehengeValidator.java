package com.bornstone.stonehenge.manager.validate;

import com.alibaba.fastjson.JSON;
import com.bornstone.stonehenge.manager.exception.EntityValidateFailureException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by King.Tang on 14-10-27.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class StonehengeValidator {
    private static final Logger logger = Logger.getLogger(StonehengeValidator.class);
    private static final Validator validator = new Validator();

    public static void validate(Object obj) {
        List<ConstraintViolation> result = validator.validate(obj);
        if (result != null && !result.isEmpty()) {
            String errorMsg = buildValidateMessage(result);
            logger.error("Illegal param object：" + errorMsg);
            throw new EntityValidateFailureException(errorMsg);
        }
    }

    private static String buildValidateMessage(List<ConstraintViolation> result) {
        List<String> messages = new ArrayList<String>();
        for (ConstraintViolation violation : result) {
            messages.add(violation.getMessage());
        }
        return JSON.toJSONString(messages);
    }
}
