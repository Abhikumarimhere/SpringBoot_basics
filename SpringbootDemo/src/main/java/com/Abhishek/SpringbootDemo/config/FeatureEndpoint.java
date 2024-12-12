package com.Abhishek.SpringbootDemo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
   private final Map<String,Feature> Featuresmap=
           new ConcurrentHashMap<String,Feature>();

    public FeatureEndpoint() {
        Featuresmap.put("Department",new Feature(true));
        Featuresmap.put("user",new Feature(false));
    }
@ReadOperation
    public Map<String, Feature> getFeaturesmap() {
        return Featuresmap;
    }
@ReadOperation
    public Feature Features(@Selector String tool){
        return Featuresmap.get(tool);
    }

    @Data
@NoArgsConstructor
@AllArgsConstructor
    private static class Feature {
       private boolean isEnabled;
   }
}
