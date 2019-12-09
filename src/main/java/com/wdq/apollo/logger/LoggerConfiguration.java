package com.wdq.apollo.logger;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 动态日志配置
 */
@Component
public class LoggerConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(LoggerConfiguration.class);
  private static final String LOGGER_TAG = "logger.level";

  @Resource
  private LoggingSystem loggingSystem;


  @ApolloConfig
  private Config config;

  @ApolloConfigChangeListener
  private void onChange(ConfigChangeEvent changeEvent) {
    System.out.println("Changes for namespace " + changeEvent.getNamespace());
    for (String key : changeEvent.changedKeys()) {
      ConfigChange change = changeEvent.getChange(key);
      System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
    }
    refreshLoggingLevels();
  }

  @PostConstruct
  private void refreshLoggingLevels() {
    Set<String> keyNames = config.getPropertyNames();
    for (String key : keyNames) {
      System.out.println("key:"+key+ "  value:"+config.getProperty(key,""));
      if (containsIgnoreCase(key, LOGGER_TAG)) {
        String strLevel = config.getProperty(key, "info");
        LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
        loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
        logger.info("{}:{}", key, strLevel);
      }
    }
  }

  private static boolean containsIgnoreCase(String str, String searchStr) {
    if (str == null || searchStr == null) {
      return false;
    }
    int len = searchStr.length();
    int max = str.length() - len;
    for (int i = 0; i <= max; i++) {
      if (str.regionMatches(true, i, searchStr, 0, len)) {
        return true;
      }
    }
    return false;
  }
}
