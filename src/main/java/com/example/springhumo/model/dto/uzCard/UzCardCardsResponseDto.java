package com.example.springhumo.model.dto.uzCard;

public class UzCardCardsResponseDto<T> {
    private String jsonrpc;
    private String id;
    private T result;

    public UzCardCardsResponseDto(T result, String jsonrpc, String id) {
        this.result = result;
        this.jsonrpc = jsonrpc;
        this.id = id;
    }

    public String getJsonrpc() {
        return this.jsonrpc;
    }

    public String getId() {
        return this.id;
    }

    public T getResult() {
        return this.result;
    }

    public void setJsonrpc(final String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setResult(final T result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UzCardCardsResponseDto)) {
            return false;
        } else {
            UzCardCardsResponseDto<?> other = (UzCardCardsResponseDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$jsonrpc = this.getJsonrpc();
                    Object other$jsonrpc = other.getJsonrpc();
                    if (this$jsonrpc == null) {
                        if (other$jsonrpc == null) {
                            break label47;
                        }
                    } else if (this$jsonrpc.equals(other$jsonrpc)) {
                        break label47;
                    }

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

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UzCardCardsResponseDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $jsonrpc = this.getJsonrpc();
        result = result * 59 + ($jsonrpc == null ? 43 : $jsonrpc.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "UzCardCardsResponseDto(jsonrpc=" + this.getJsonrpc() + ", id=" + this.getId() + ", result=" + this.getResult() + ")";
    }
}
