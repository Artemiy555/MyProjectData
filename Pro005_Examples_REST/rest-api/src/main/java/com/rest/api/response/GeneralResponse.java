package com.rest.api.response;

/* Общий вариант ответа Api
*
*  code - отвечает и возвращет результат выполнения
*         запроса от API
*  payload - в зависимости от результата выполнения запроса
*            может возвращать какой либо результат
*            или может быть NULL */
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
