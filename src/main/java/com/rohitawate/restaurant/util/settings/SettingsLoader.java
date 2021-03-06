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

package com.rohitawate.restaurant.util.settings;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohitawate.restaurant.util.MiscUtils;
import com.rohitawate.restaurant.util.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

/**
 * Loads up custom values into Settings from settings.json.
 */
public class SettingsLoader implements Runnable {
    public Thread settingsLoaderThread;

    public SettingsLoader() {
        settingsLoaderThread = new Thread(this, "Settings loader thread");
        settingsLoaderThread.start();
    }

    @Override
    public void run() {
        try {
            File settingsFile = new File("config/settings.json");

            if (settingsFile.exists())
                System.out.print("Settings file found. Loading settings... ");
            else
                throw new FileNotFoundException();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode nodes = mapper.readTree(settingsFile);

            Settings.responseAreaFont = nodes.get("responseAreaFont").toString();
            Settings.responseAreaFontSize = nodes.get("responseAreaFontSize").asInt();

            Settings.connectionTimeOutEnable = nodes.get("connectionTimeOutEnable").asBoolean();
            if (Settings.connectionTimeOutEnable)
                Settings.connectionTimeOut = nodes.get("connectionTimeOut").asInt();

            Settings.connectionReadTimeOutEnable = nodes.get("connectionReadTimeOutEnable").asBoolean();
            if (Settings.connectionReadTimeOutEnable)
                Settings.connectionReadTimeOut = nodes.get("connectionReadTimeOut").asInt();

            Settings.theme = MiscUtils.trimString(nodes.get("theme").toString());
        } catch (Exception E) {
            Services.loggingService.logInfo("Settings file not found. Defaults will be used.", LocalDateTime.now());
        } finally {
            Services.loggingService.logInfo("Settings loaded.", LocalDateTime.now());
        }
    }
}
