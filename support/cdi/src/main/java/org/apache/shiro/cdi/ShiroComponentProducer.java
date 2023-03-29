/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.shiro.cdi;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cdi.annotations.NoSessionCreation;
import org.apache.shiro.cdi.annotations.Principal;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Exposes Shiro's SecurityManager, Session and Subject via CDI @Inject
 */
@SuppressWarnings("HideUtilityClassConstructor")
@Dependent
@Slf4j
public class ShiroComponentProducer {
    @Produces
    public static SecurityManager getSecurityManager() {
        return SecurityUtils.getSecurityManager();
    }

    @Produces
    @RequestScoped
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    @Produces
    @RequestScoped
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    @Produces
    @NoSessionCreation
    @RequestScoped
    public static Session getSessionNoCreation() {
        return Optional.ofNullable(SecurityUtils.getSubject().getSession(false))
                .orElseThrow(InvalidSessionException::new);
    }

    @Produces
    @Principal
    @SuppressWarnings("unchecked")
    public static <T> ShiroPrincipal<T> getPrincipal(InjectionPoint injectionPoint) {
        var parameterizedType = (ParameterizedType) injectionPoint.getType();
        return new ShiroPrincipal<>((Class<T>) parameterizedType.getActualTypeArguments()[0]);
    }
}
