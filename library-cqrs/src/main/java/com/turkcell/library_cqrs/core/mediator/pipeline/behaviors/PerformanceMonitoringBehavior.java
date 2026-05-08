package com.turkcell.library_cqrs.core.mediator.pipeline.behaviors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(4)
public class PerformanceMonitoringBehavior implements PipelineBehavior {

    private static final long PERFORMANCE_THRESHOLD_MS = 3000;

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        long startTime = System.currentTimeMillis();

        try {
            return next.invoke();
        } finally {
            long elapsedTime = System.currentTimeMillis() - startTime;

            if (elapsedTime > PERFORMANCE_THRESHOLD_MS) {
                String requestName = request.getClass().getSimpleName();
                System.out.println("PERFORMANCE WARNING: Request '" + requestName + "' took " +
                        elapsedTime + "ms (threshold: " + PERFORMANCE_THRESHOLD_MS + "ms)");
            }
        }
    }
}
