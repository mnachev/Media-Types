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
public class MediaTypeNGTest {

    public MediaTypeNGTest() {
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
     * Test of getMediaType method, of class MediaType.
     */
    @Test
    public void testGetMediaType() {
        System.out.println("getMediaType");
        String mimeType = "application/msword";
        MediaType expResult = MediaType.Application;
        MediaType result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);

        mimeType = " application/msword ";
        result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);

        mimeType = " application /msword ";
        result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);

        mimeType = " application /";
        result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);

        mimeType = " application ";
        result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);

        mimeType = "application";
        result = MediaType.getMediaType(mimeType);
        assertEquals(result, expResult, "mimeType=" + mimeType);
    }
}
