package com.example.springhumo.model.dto.uzCard;

public class UzCardCardsRequestDto<T> {
    private String jsonrpc;
    private String method;
    private String id;
    private T params;

    public UzCardCardsRequestDto() {
    }

    public String getJsonrpc() {
        return this.jsonrpc;
    }

    public String getMethod() {
        return this.method;
    }

    public String getId() {
        return this.id;
    }

    public T getParams() {
        return this.params;
    }

    public void setJsonrpc(final String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setMethod(final String method) {
        this.method = method;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setParams(final T params) {
        this.params = params;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UzCardCardsRequestDto)) {
            return false;
        } else {
            UzCardCardsRequestDto<?> other = (UzCardCardsRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$jsonrpc = this.getJsonrpc();
                    Object other$jsonrpc = other.getJsonrpc();
                    if (this$jsonrpc == null) {
                        if (other$jsonrpc == null) {
                            break label59;
                        }
                    } else if (this$jsonrpc.equals(other$jsonrpc)) {
                        break label59;
                    }

                    return false;
                }

                Object this$method = this.getMethod();
                Object other$method = other.getMethod();
                if (this$method == null) {
                    if (other$method != null) {
                        return false;
                    }
                } else if (!this$method.equals(other$method)) {
                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$params = this.getParams();
                Object other$params = other.getParams();
                if (this$params == null) {
                    if (other$params != null) {
                        return false;
                    }
                } else if (!this$params.equals(other$params)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UzCardCardsRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $jsonrpc = this.getJsonrpc();
        result = result * 59 + ($jsonrpc == null ? 43 : $jsonrpc.hashCode());
        Object $method = this.getMethod();
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $params = this.getParams();
        result = result * 59 + ($params == null ? 43 : $params.hashCode());
        return result;
    }

    public String toString() {
        return "UzCardCardsRequestDto(jsonrpc=" + this.getJsonrpc() + ", method=" + this.getMethod() + ", id=" + this.getId() + ", params=" + this.getParams() + ")";
    }
}
