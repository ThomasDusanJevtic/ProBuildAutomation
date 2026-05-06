package com.probuild.workers;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProbuildWorkers {

    private static final Logger LOG = LoggerFactory.getLogger(ProbuildWorkers.class);

    @JobWorker(type = "CheckStock")
    public Map<String, Object> checkStock(@Variable(name = "ProductID") String productId) {
        LOG.info("Checking stock availability for Product ID: {}", productId);
        // Simulate stock check against a database
        boolean stockAvailable = true; // Replace with actual DB query
        
        Map<String, Object> variables = new HashMap<>();
        variables.put("stockAvailable", stockAvailable);
        return variables;
    }

    @JobWorker(type = "SendOrder")
    public void sendOrder(
            @Variable(name = "ProductID") String productId,
            @Variable(name = "textarea_dxfkco") String deliveryAddress) {
        LOG.info("Sending order for {} to logistics. Delivery Address: {}", productId, deliveryAddress);
    }

    @JobWorker(type = "Handover")
    public void handoverTools() {
        LOG.info("Triggering handover process to FixPro Driver.");
    }

    @JobWorker(type = "FlagTools")
    public void flagToolsForService() {
        LOG.info("Weekly maintenance cycle started. Flagging tools for service bay.");
    }

    @JobWorker(type = "Update_ToolLog")
    public void updateToolLog() {
        LOG.info("System updating with new tool condition log from warehouse staff.");
    }

    @JobWorker(type = "Throw")
    public void handleNoStockRejection() {
        LOG.info("No stock available. Ending process and triggering rejection to customer.");
    }
}