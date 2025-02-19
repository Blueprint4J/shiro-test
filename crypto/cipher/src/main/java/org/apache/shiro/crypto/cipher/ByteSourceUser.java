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

package org.apache.shiro.crypto.cipher;

import honours.research.annotations.Group;

/**
 * {@link ByteSourceBroker#useBytes(ByteSourceUser)} method requires ByteSourceUser argument,
 * and developers should implement how we use the byte arrays in our code-base.
 * <br/>
 * The byte array "bytes" could be a decrypted password in plaintext format, or other
 * sensitive information that needs to be erased at end of use.
 */
@Group("Cryptography")
public interface ByteSourceUser {
    void use(byte[] bytes);
}
