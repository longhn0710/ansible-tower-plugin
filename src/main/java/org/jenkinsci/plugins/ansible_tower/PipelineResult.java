package org.jenkinsci.plugins.ansible_tower;

import java.util.HashMap;
import java.util.Properties;

/** Converts the plugin's internal result container into a Pipeline Sandbox-safe map. */
final class PipelineResult {
    private PipelineResult() {
    }

    static HashMap<Object, Object> from(Properties properties) {
        return new HashMap<Object, Object>(properties);
    }
}
