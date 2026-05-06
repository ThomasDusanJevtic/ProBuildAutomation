package com.probuild.workers;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FixProWorkers {

    private static final Logger LOG = LoggerFactory.getLogger(FixProWorkers.class);

    @JobWorker(type = "inspection")
    public Map<String, Object> inspectTools() {
        LOG.info("FixPro: Inspecting received tools...");
        
        // Simulating inspection finding a major fault
        boolean majorRepairNeeded = false; 
        
        Map<String, Object> variables = new HashMap<>();
        variables.put("majorRepair", majorRepairNeeded);
        return variables;
    }

    @JobWorker(type = "servicing")
    public void carryOutServicing() {
        LOG.info("FixPro: Carrying out standard servicing and maintenance.");
    }

    @JobWorker(type = "PAT-Testing")
    public void patTesting() {
        LOG.info("FixPro: Conducting electrical safety PAT testing.");
    }

    @JobWorker(type = "Record-Serviced-Tools")
    public void recordServicedTools() {
        LOG.info("FixPro: Updating client portal with new service logs and PAT certificates.");
    }

    @JobWorker(type = "send-tools-back")
    public void sendToolsBack() {
        LOG.info("FixPro: Dispatching serviced tools back to Probuild warehouse.");
    }
}