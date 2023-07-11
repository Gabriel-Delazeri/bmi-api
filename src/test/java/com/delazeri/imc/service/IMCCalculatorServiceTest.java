package com.delazeri.imc.service;

import com.delazeri.imc.models.IMCRequest;
import com.delazeri.imc.models.IMCResponse;
import com.delazeri.imc.models.enums.IMCStatus;
import com.delazeri.imc.services.IMCCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMCCalculatorServiceTest {

    private IMCCalculatorService imcCalculatorService;

    @BeforeEach
    public void setUp() {
        imcCalculatorService = new IMCCalculatorService();
    }

    @Test
    void testCalculateIMC() {
        double height = 1.75;
        double weight = 75.0;
        IMCRequest imcRequest = new IMCRequest(height, weight);

        double expectedImc = 24.49;
        IMCStatus expectedStatus = IMCStatus.NORMAL;

        IMCResponse imcResponse = imcCalculatorService.calculate(imcRequest);

        assertEquals(expectedImc, imcResponse.getResult(), 0.01);
        assertEquals(expectedStatus, imcResponse.getStatus());
    }

    @Test
    void testIMCStatus() {
        double baseHeight = 1.75;
        double[] weights = { 50, 75.0, 80, 95, 125 };

        IMCStatus[] expectedStatuses = {
                IMCStatus.UNDERWEIGHT, IMCStatus.NORMAL, IMCStatus.OVERWEIGHT, IMCStatus.OBESITY, IMCStatus.SEVERE_OBESITY
        };

        for (int i = 0; i < weights.length ; i ++) {
            IMCRequest imcRequest = new IMCRequest(baseHeight, weights[i]);
            double result = IMCCalculatorService.getResult(imcRequest);
            assertEquals(expectedStatuses[i], IMCCalculatorService.getStatus(result));
        }
    }
}
