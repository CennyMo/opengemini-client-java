/*
 * Copyright 2024 openGemini Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opengemini.client.spring.data.sample.customizer;

import io.github.openfacade.http.HttpClientConfig;
import io.github.openfacade.http.HttpClientEngine;
import io.opengemini.client.api.Configuration;
import io.opengemini.client.spring.data.core.ClientConfigurationBuilderCustomizer;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class TestClientConfigurationBuilderCustomizer implements ClientConfigurationBuilderCustomizer {
    @Override
    public void customize(Configuration.ConfigurationBuilder configurationBuilder) {
        HttpClientConfig httpConfig = new HttpClientConfig.Builder()
                .engine(HttpClientEngine.OkHttp)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        configurationBuilder.httpConfig(httpConfig);
    }
}