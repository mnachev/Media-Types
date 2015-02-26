/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.iana.mediatypes;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Miroslav Nachev [mnachev@gmail.com]
 */
public enum MediaType {

    Application("application"),
    Audio("audio"),
    Example("example"),
    Chemical("chemical"),
    Image("image"),
    Message("message"),
    Model("model"),
    Multipart("multipart"),
    Text("text"),
    Video("video"),
    XConference("x-conference");

    private static Map<String, MediaType> mediaTypeMap;

    private final String mimeType;
    private final Set<String> mimeSubtypeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    private MediaType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    boolean addSubtype(String mimeSubtype) {
        return mimeSubtypeSet.add(mimeSubtype);
    }

    public Set<String> getMimeSubtypeSet() {
        return Collections.unmodifiableSet(mimeSubtypeSet);
    }

    private static Map<String, MediaType> getMediaTypeMap() {
        if (mediaTypeMap == null) {
            mediaTypeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (MediaType mediaType : values()) {
                mediaTypeMap.put(mediaType.getMimeType(), mediaType);
            }
        }

        return mediaTypeMap;
    }

    public static MediaType getMediaType(String mimeType) {
        return getMediaTypeMap().get(mimeType.trim().split("/")[0].trim());
    }
}
