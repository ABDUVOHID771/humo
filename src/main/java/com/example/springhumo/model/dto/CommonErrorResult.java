package com.example.springhumo.model.dto;

import com.example.springhumo.model.Result;

public class CommonErrorResult {
    private Result result;

    public Result getResult() {
        return this.result;
    }

    public void setResult(final Result result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommonErrorResult)) {
            return false;
        } else {
            CommonErrorResult other = (CommonErrorResult) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
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
        return other instanceof CommonErrorResult;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "CommonErrorResult(result=" + this.getResult() + ")";
    }

    public CommonErrorResult(final Result result) {
        this.result = result;
    }

    public CommonErrorResult() {
    }
}
