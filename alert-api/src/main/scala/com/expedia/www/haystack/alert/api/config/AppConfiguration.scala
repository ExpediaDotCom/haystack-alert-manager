/*
 *               Copyright 2018 Expedia, Inc.
 *
 *        Licensed under the Apache License, Version 2.0 (the "License");
 *        you may not use this file except in compliance with the License.
 *        You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 *        Unless required by applicable law or agreed to in writing, software
 *        distributed under the License is distributed on an "AS IS" BASIS,
 *        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *        See the License for the specific language governing permissions and
 *        limitations under the License.
 *
 */

package com.expedia.www.haystack.alert.api.config


import com.expedia.www.haystack.alert.api.config.entities._
import com.expedia.www.haystack.commons.config.ConfigurationLoader
import com.typesafe.config.Config

import scala.collection.JavaConverters._

class AppConfiguration {

  private val config: Config = ConfigurationLoader.loadConfigFileWithEnvOverrides()

  val serviceConfig: ServiceConfiguration = {
    val serviceConfig = config.getConfig("service")

    val ssl = serviceConfig.getConfig("ssl")
    val sslConfig = SslConfiguration(ssl.getBoolean("enabled"), ssl.getString("cert.path"), ssl.getString("private.key.path"))

    ServiceConfiguration(serviceConfig.getInt("port"), sslConfig)
  }

  val clientConfig: ClientConfiguration = {
    val clientConfig = config.getConfig("client")
    ClientConfiguration(clientConfig.getInt("connectionTimeout"), clientConfig.getInt("socketTimeout"))
  }

  val subscriptionConfig = {
    val subscriptionConfig = config.getConfig("subscription")
    SubscriptionConfiguration(subscriptionConfig.getString("baseUrl"), subscriptionConfig.getInt("retryInSeconds"), subscriptionConfig.getInt("numOfRetries"))
  }

  val pluginConfigs = {
    val pluginConfigs = config.getConfigList("plugins").asScala
    pluginConfigs.map(plugin => PluginConfig(
      plugin.getString("directory"),
      plugin.getString("name"),
      plugin.getString("jar.name"),
      plugin.getConfig("conf"))
    ).toList
  }

}
