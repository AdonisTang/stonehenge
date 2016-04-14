package com.bornstone.stonehenge.core.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.log4j.Logger;

import java.io.Writer;

/**
 * FreemarkerExceptionHandler.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description Freemarker 异常处理
 * @Date 2012-11-20下午7:15:28
 * @since 1.0.0
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {
    private static final Logger log = Logger.getLogger(FreemarkerExceptionHandler.class);

    @Override
    public void handleTemplateException(TemplateException te, Environment env,
                                        Writer out) throws TemplateException {
        log.error("[Freemarker Error: " + te.getMessage() + "]");
    }
}
