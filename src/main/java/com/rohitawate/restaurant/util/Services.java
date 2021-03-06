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

package com.rohitawate.restaurant.util;

import com.rohitawate.restaurant.homewindow.HomeWindowController;
import com.rohitawate.restaurant.util.history.HistoryManager;
import com.rohitawate.restaurant.util.logging.Level;
import com.rohitawate.restaurant.util.logging.LoggingService;

public class Services {
    public static Thread startServicesThread;
    public static HistoryManager historyManager;
    public static LoggingService loggingService;
    public static HomeWindowController homeWindowController;

    public static void start() {
        startServicesThread = new Thread(() -> {
            loggingService = new LoggingService(Level.INFO);
            historyManager = new HistoryManager();
        });

        startServicesThread.start();
    }
}
