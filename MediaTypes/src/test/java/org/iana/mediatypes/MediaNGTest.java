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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Miroslav Nachev [mnachev@gmail.com]
 */
public class MediaNGTest {

    public MediaNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of values method, of class Media.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Media[] result = Media.values();
        Map<String, Media> mediaMap = Media.getMediaMap();
        assertEquals(result.length, mediaMap.size());
    }

    /**
     * Test of getMediaByExtension method, of class Media.
     */
    @Test
    public void testGetMediaByExtension() {
        System.out.println("getMediaByExtension");
        Media media = Media.VideoMpeg;
        for (String ext : media.getExtensionSet()) {
            Media result = Media.getMediaByExtension(ext);
            assertEquals(result, media);
        }
    }

    /**
     * Test of getMediaByExtension method, of class Media.
     */
    @Test
    public void testGetMedia() {
        System.out.println("getMedia");
        Media media = Media.VideoMpeg;
        Media result = Media.getMedia(media.getMimeType());
        assertEquals(result, media);
    }

    /**
     * Test of getMediaByExtension method, of class Media.
     */
    @Test
    public void testGetMediaByPath() {
        System.out.println("getMediaByPath");
        Media media = Media.VideoMpeg;
        Path path = Paths.get("test.mpeg");
        Media result = Media.getMedia(path);
        assertEquals(result, media);
    }
}
