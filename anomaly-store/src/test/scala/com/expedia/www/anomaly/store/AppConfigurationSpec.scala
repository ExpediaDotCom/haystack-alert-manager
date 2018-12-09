/*
 * Copyright 2018 Expedia Group, Inc.
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

package com.expedia.www.anomaly.store

import com.expedia.www.anomaly.store.config.AppConfiguration
import org.scalatest.{FunSpec, Matchers}

class AppConfigurationSpec extends FunSpec with Matchers {
    describe("App Configuration") {
        it("should load the configuration") {
            val appConfig = new AppConfiguration("test.conf")
            val kafka = appConfig.kafkaConfig
            kafka.threads shouldBe 2
        }
    }
}
