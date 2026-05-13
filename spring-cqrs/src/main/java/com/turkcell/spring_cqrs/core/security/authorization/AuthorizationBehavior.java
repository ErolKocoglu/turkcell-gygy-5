package com.turkcell.spring_cqrs.core.security.authorization;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.spring_cqrs.core.security.context.UserContext;
import com.turkcell.spring_cqrs.core.exception.type.AuthenticatedException;
import com.turkcell.spring_cqrs.core.exception.type.AuthorizationException;
import java.util.List;

@Component
@Order(10)
public class AuthorizationBehavior implements PipelineBehavior {
    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    

    @Override
    public boolean supports(Object request) {
        return request instanceof AuthorizableRequest;
    }


    // ilgili handler'ın öncesi ve sonrası çalıştırabilen kodlar.
    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        if(!userContext.isAuthenticated())
            throw new AuthenticatedException("Giriş yapmalısın..");// token olmayınca burası çalışıyor
        
        AuthorizableRequest authRequest = (AuthorizableRequest) request;
        List<String> requiredRoles = authRequest.getRequiredRoles();
        
        if (requiredRoles != null && !requiredRoles.isEmpty()) {
            boolean hasRole = userContext.getRoles().stream()
                .anyMatch(requiredRoles::contains);
            
            if (!hasRole) {
                throw new AuthorizationException("Gerekli yetkiye ship değilsiniz..");
            }
        }
        
        return next.invoke(); // zincirdeki sonraki halkayı çağır..
    }

}
