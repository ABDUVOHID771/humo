package com.example.springhumo.model.dto.humo.response;

public class P2pApplyResponseDto {
    public P2pApplyResponseDto() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof P2pApplyResponseDto)) {
            return false;
        } else {
            P2pApplyResponseDto other = (P2pApplyResponseDto) o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof P2pApplyResponseDto;
    }

    public int hashCode() {
        int result = 1;//true
        return 1;
    }

    public String toString() {
        return "P2pApplyResponseDto()";
    }
}
