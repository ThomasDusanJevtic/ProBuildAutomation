package com.probuild.workers;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class FinTrustWorkers {

    private static final Logger LOG = LoggerFactory.getLogger(FinTrustWorkers.class);

    @JobWorker(type = "Process-application")
    public Map<String, Object> processCreditApplication() {
        LOG.info("FinTrust processing credit application...");
        
        // Simulating credit check logic
        boolean creditApproved = new Random().nextBoolean(); 
        LOG.info("Credit application result: {}", creditApproved ? "APPROVED" : "REJECTED");
        
        Map<String, Object> variables = new HashMap<>();
        variables.put("creditApproved", creditApproved);
        return variables;
    }

    @JobWorker(type = "Credit-Approved")
    public void notifyCreditApproved() {
        LOG.info("FinTrust: Notifying customer that credit is APPROVED.");
    }

    @JobWorker(type = "Credit-Rejected")
    public void notifyCreditRejected() {
        LOG.info("FinTrust: Notifying customer that credit is REJECTED.");
    }

    @JobWorker(type = "Pay-probuild")
    public void payProbuildUpfront() {
        LOG.info("FinTrust: Releasing full upfront funds to Probuild.");
    }

    @JobWorker(type = "Notify-Customer")
    public void generalCustomerNotification() {
        LOG.info("FinTrust: Sending general status notification to customer.");
    }
}