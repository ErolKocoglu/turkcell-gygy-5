package com.turkcell.library_cqrs.core.mediator.pipeline.behaviors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(2)
public class TransactionBehavior implements PipelineBehavior {

    private final TransactionTemplate transactionTemplate;

    public TransactionBehavior(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        // Sadece Command'ler için transaction başlat
        // Query'ler için read-only transaction kullan
        if (request instanceof Command) {
            return transactionTemplate.execute(status -> {
                String commandName = request.getClass().getSimpleName();
                System.out.println("💾 TRANSACTION STARTED for Command: " + commandName);
                
                try {
                    R result = next.invoke();
                    System.out.println("✓ TRANSACTION COMMITTED for Command: " + commandName);
                    return result;
                } catch (Exception e) {
                    System.out.println("✗ TRANSACTION ROLLED BACK for Command: " + commandName + 
                            " - Error: " + e.getMessage());
                    throw e;
                }
            });
        } else {
            // Query'ler için read-only transaction
            System.out.println("📖 READ-ONLY TRANSACTION for Query: " + request.getClass().getSimpleName());
            return next.invoke();
        }
    }

    @Override
    public boolean supports(Object request) {
        // Command ve Query'ler için transaction desteği sağla
        return request instanceof Command || isQuery(request);
    }

    private boolean isQuery(Object request) {
        return request.getClass().getSimpleName().contains("Query");
    }
}
