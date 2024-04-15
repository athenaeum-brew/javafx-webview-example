package com.cthiebaud.javafx;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.StringWriter;

public class ThymeleafTemplateProcessor {

    public static String processTemplate(String htmlContent, Message model) {
        // Create a Thymeleaf context with the model attributes
        Context context = new Context();
        context.setVariable("message", model.getMessage());

        // Process the template with Thymeleaf
        TemplateEngine templateEngine = new TemplateEngine();
        StringWriter writer = new StringWriter();
        templateEngine.process(htmlContent, context, writer);

        return writer.toString();
    }
}
