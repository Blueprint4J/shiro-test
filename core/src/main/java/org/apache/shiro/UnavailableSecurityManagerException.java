/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shiro;

import honours.research.annotations.Group;
import honours.research.annotations.Ignore;
import org.apache.shiro.lang.ShiroException;

/**
 * Exception thrown when attempting to acquire the application's {@code SecurityManager} instance, but Shiro's
 * lookup heuristics cannot find one.  This typically indicates an invalid application configuration.
 *
 * @since 1.0
 */
@Ignore
public class UnavailableSecurityManagerException extends ShiroException {

    public UnavailableSecurityManagerException(String message) {
        super(message);
    }

    /**
     * @deprecated This constructor is NOT used by Shiro directly, and will be removed in the future.
     */
    @Deprecated
    public UnavailableSecurityManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
