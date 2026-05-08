package com.turkcell.library_cqrs.core.mediator.pipeline.behaviors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(3)
public class LoggingBehavior implements PipelineBehavior {

    @Override
    public boolean supports(Object request) {
       return !(request instanceof NotLoggableRequest); // eğer ilgili request (command/query) LoggableRequest ile imzalanmış ise yap.
    }


    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        String requestName = request.getClass().getSimpleName();
        String requestDetails = request.toString();

        System.out.println("📝 INCOMING REQUEST: " + requestName);
        System.out.println("   Details: " + requestDetails);

        try {
            R response = next.invoke();

            System.out.println("✅ RESPONSE for " + requestName + ": " + 
                    (response != null ? response.toString() : "null"));

            return response;
        } catch (Exception e) {
            System.out.println("❌ ERROR for " + requestName + ": " + e.getMessage());
            throw e;
        }
    }
}
