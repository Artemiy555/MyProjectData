package com.rest.api.response;

public class GeneralResponse<T> {
    private String code;
    private T payload;

    public GeneralResponse() {}
    public GeneralResponse(String code, T payload) {
        this.code = code;
        this.payload = payload;
    }
    public String getCode() {
        return code;
    }
    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "code='" + code + '\'' +
                ", payload=" + payload +
                '}';
    }


}
