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
package org.apache.shiro.env;

import java.util.function.Function;

import honours.research.annotations.Ignore;
import org.apache.shiro.config.Ini;
import org.apache.shiro.ini.IniSecurityManagerFactory;

/**
 * Basic usage:<p>
 * <code>
 * Environment env = new BasicIniEnvironment("classpath:shiro.ini");
 * SecurityManager securityManager = env.getSecurityManager();
 * </code>
 *
 * @since 1.5
 */
@Ignore
public class BasicIniEnvironment extends DefaultEnvironment {
    public BasicIniEnvironment(Ini ini) {
        this(ini, (name) -> null);
    }

    public BasicIniEnvironment(Ini ini, Function<String, ?> alternateObjectSupplier) {
        var securityManagerFactory = new IniSecurityManagerFactory(ini);
        securityManagerFactory.getReflectionBuilder().setAlternateObjectSupplier(alternateObjectSupplier);
        setSecurityManager(securityManagerFactory.getInstance());
    }

    public BasicIniEnvironment(String iniResourcePath) {
        this(Ini.fromResourcePath(iniResourcePath));
    }

    public BasicIniEnvironment(String iniResourcePath, Function<String, ?> alternateObjectSupplier) {
        this(Ini.fromResourcePath(iniResourcePath), alternateObjectSupplier);
    }
}
