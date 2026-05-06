package com.probuild.workers;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerSystemWorkers {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerSystemWorkers.class);

    @JobWorker(type = "Send-Product-Selected")
    public void sendProductSelected(@Variable(name = "ProductID") String productId) {
        LOG.info("Customer selected product: {}. Sending IDs to Probuild system.", productId);
    }

    @JobWorker(type = "request-credit")
    public void requestCreditApplication() {
        LOG.info("Customer requested finance. Sending API request to FinTrust UK.");
    }

    @JobWorker(type = "Send-Payment")
    public void sendPaymentDeposit() {
        LOG.info("Processing initial payment/deposit from customer.");
    }

    @JobWorker(type = "send-payment")
    public void sendPaymentFull() {
        LOG.info("Processing full card/cash payment from customer.");
    }

    @JobWorker(type = "payment-complete")
    public void paymentComplete() {
        LOG.info("Payment fully authorized and complete. Notifying Probuild.");
    }

    @JobWorker(type = "Pay-Installments")
    public void payInstallments() {
        LOG.info("Setting up direct debit for Fintrust UK installments.");
    }

    @JobWorker(type = "Return-Tools")
    public void returnTools() {
        LOG.info("Rental period ended. Initiating return tool workflow for customer.");
    }
}