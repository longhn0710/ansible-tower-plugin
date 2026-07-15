package org.jenkinsci.plugins.ansible_tower;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class PipelineResultTest {

    @Test
    void convertsPropertiesToSandboxSafeMapWithoutLosingValues() {
        Properties properties = new Properties();
        properties.put("JOB_ID", "6");
        properties.put("JOB_RESULT", "SUCCESS");
        Object asyncHandle = new Object();
        properties.put("job", asyncHandle);

        HashMap<Object, Object> result = PipelineResult.from(properties);

        assertThat(result, instanceOf(Map.class));
        assertThat(result.get("JOB_ID"), is("6"));
        assertThat(result.get("JOB_RESULT"), is("SUCCESS"));
        assertThat(result.get("job"), is(asyncHandle));
    }
}
