package tld.sld.userApi.web.controllers.models.responses;

import java.util.List;

public class Response<T> {
    private Boolean success;
    private List errors;
    private T data;

    public Response(Boolean success, List errors, T data) {
        this.success = success;
        this.errors = errors;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public List getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}
