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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class MediaTypeDetectorNGTest {
    
    public MediaTypeDetectorNGTest() {
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
     * Test of probeContentType method, of class MediaTypeDetector.
     */
    @Test
    public void testProbeContentType() throws Exception {
        System.out.println("probeContentType");
        Path path;
        for(String ext : Media.getMediaExtensionSet()) {
            path = Paths.get("testfile." + ext);
            String mimeType = Files.probeContentType(path);
            assertNotNull(mimeType);
            Media source = Media.getMediaByExtension(ext);
            Media result = Media.getMedia(mimeType);
            assertEquals(result, source);
        }
    }
}
