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
package org.apache.shiro.crypto;

import honours.research.annotations.Group;

/**
 * Exception thrown when attempting to lookup or use a cryptographic algorithm that does not exist in the current
 * JVM environment.
 *
 * @since 1.2
 */
@Group("Cryptography")
public class UnknownAlgorithmException extends CryptoException {

    public UnknownAlgorithmException(String message) {
        super(message);
    }

    public UnknownAlgorithmException(Throwable cause) {
        super(cause);
    }

    public UnknownAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
