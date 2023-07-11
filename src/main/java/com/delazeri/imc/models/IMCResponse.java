package com.delazeri.imc.models;

import com.delazeri.imc.models.enums.IMCStatus;

public class IMCResponse {

    private double height;
    private double weight;
    private double result;
    private IMCStatus status;

    public IMCResponse(double height, double weight, double result, IMCStatus status) {
        this.height = height;
        this.weight = weight;
        this.result = result;
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public IMCStatus getStatus() {
        return status;
    }

    public void setStatus(IMCStatus status) {
        this.status = status;
    }
}
