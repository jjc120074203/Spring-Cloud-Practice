package org.spring.cloud.common.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jiazaibo on 17-3-3.
 */

public class AuthInterceptorHelper {

    @Autowired
    private Environment env;

    private Set<String> outFilterPathPrefixPatterns = new HashSet<String>();

    @PostConstruct
    public void init() {
        String outFilterPathPrefixPattern = env.getProperty("filter.path.ignored.prefix");
        if (StringUtils.isNotBlank(outFilterPathPrefixPattern)) {
            String [] pps = StringUtils.split(outFilterPathPrefixPattern, ",");
            for (String pp : pps) {
                if (StringUtils.isNotBlank(pp)) {
                    outFilterPathPrefixPatterns.add(pp.trim());
                }
            }
        }
    }


    public boolean ignoredAuthenticationPath(String path) {
        for (String outPath : outFilterPathPrefixPatterns) {
            if (path.startsWith(outPath)) {
                return true;
            }
        }
        return false;
    }


}
