package com.delazeri.imc.services;

import com.delazeri.imc.models.IMCRequest;
import com.delazeri.imc.models.IMCResponse;
import com.delazeri.imc.models.enums.IMCStatus;
import org.springframework.stereotype.Service;

@Service
public class IMCCalculatorService {

    public IMCResponse calculate(IMCRequest imcRequest) {
        return new IMCResponse(
                imcRequest.getHeight(),
                imcRequest.getWeight(),
                getResult(imcRequest),
                getStatus(getResult(imcRequest))
        );
    }

    public static double getResult(IMCRequest imcRequest) {
        double imc = imcRequest.getWeight() / (imcRequest.getHeight() * imcRequest.getHeight());

        return Math.round(imc * 100.0) / 100.0;
    }

    public static IMCStatus getStatus(double result) {
        if (result < 18.5) {
            return IMCStatus.UNDERWEIGHT;
        } else if (result >= 18.5 && result <= 24.9) {
            return IMCStatus.NORMAL;
        } else if (result >= 25.0 && result <= 29.9) {
            return IMCStatus.OVERWEIGHT;
        } else if (result >= 30.0 && result <= 39.9) {
            return IMCStatus.OBESITY;
        } else {
            return IMCStatus.SEVERE_OBESITY;
        }
    }
}
