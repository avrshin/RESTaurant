/*
 * Copyright 2018 Rohit Awate.
 *
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

package com.rohitawate.restaurant.models.requests;

import java.net.MalformedURLException;
import java.net.URL;

public class DELETERequest extends RestaurantRequest {
    public DELETERequest() {
    }

    public DELETERequest(String target) throws MalformedURLException {
        super(target);
    }

    public DELETERequest(URL target) {
        super(target);
    }
}
