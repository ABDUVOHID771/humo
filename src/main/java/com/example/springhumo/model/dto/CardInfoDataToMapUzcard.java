package com.example.springhumo.model.dto;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.model.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardInfoDataToMapUzcard {
    @JsonProperty("cref_no")
    private String cref_no;
    @JsonProperty("embos_name")
    private String embos_name;
    @JsonProperty("exp_dt")
    private String exp_dt;
    @JsonProperty("cardtype")
    private String cardtype;
    @JsonProperty("status")
    private Result result;

    public CardInfoDataToMapUzcard() {
    }

    public CardInfoDataToMapUzcard(CardInfoDto cardInfoDto) {
        this.cref_no = cardInfoDto.getCard().getPan();
        this.embos_name = cardInfoDto.getCard().getFullName();
        this.exp_dt = "00" + cardInfoDto.getCard().getExpiry();
        this.cardtype = "";
        this.result = ApiResults.OK;
    }

    public String getCref_no() {
        return this.cref_no;
    }

    public String getEmbos_name() {
        return this.embos_name;
    }

    public String getExp_dt() {
        return this.exp_dt;
    }

    public String getCardtype() {
        return this.cardtype;
    }

    public Result getResult() {
        return this.result;
    }

    @JsonProperty("cref_no")
    public void setCref_no(final String cref_no) {
        this.cref_no = cref_no;
    }

    @JsonProperty("embos_name")
    public void setEmbos_name(final String embos_name) {
        this.embos_name = embos_name;
    }

    @JsonProperty("exp_dt")
    public void setExp_dt(final String exp_dt) {
        this.exp_dt = exp_dt;
    }

    @JsonProperty("cardtype")
    public void setCardtype(final String cardtype) {
        this.cardtype = cardtype;
    }

    @JsonProperty("status")
    public void setResult(final Result result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardInfoDataToMapUzcard)) {
            return false;
        } else {
            CardInfoDataToMapUzcard other = (CardInfoDataToMapUzcard) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71:
                {
                    Object this$cref_no = this.getCref_no();
                    Object other$cref_no = other.getCref_no();
                    if (this$cref_no == null) {
                        if (other$cref_no == null) {
                            break label71;
                        }
                    } else if (this$cref_no.equals(other$cref_no)) {
                        break label71;
                    }

                    return false;
                }

                Object this$embos_name = this.getEmbos_name();
                Object other$embos_name = other.getEmbos_name();
                if (this$embos_name == null) {
                    if (other$embos_name != null) {
                        return false;
                    }
                } else if (!this$embos_name.equals(other$embos_name)) {
                    return false;
                }

                label57:
                {
                    Object this$exp_dt = this.getExp_dt();
                    Object other$exp_dt = other.getExp_dt();
                    if (this$exp_dt == null) {
                        if (other$exp_dt == null) {
                            break label57;
                        }
                    } else if (this$exp_dt.equals(other$exp_dt)) {
                        break label57;
                    }

                    return false;
                }

                Object this$cardtype = this.getCardtype();
                Object other$cardtype = other.getCardtype();
                if (this$cardtype == null) {
                    if (other$cardtype != null) {
                        return false;
                    }
                } else if (!this$cardtype.equals(other$cardtype)) {
                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result == null) {
                        return true;
                    }
                } else if (this$result.equals(other$result)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardInfoDataToMapUzcard;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $cref_no = this.getCref_no();
        result = result * 59 + ($cref_no == null ? 43 : $cref_no.hashCode());
        Object $embos_name = this.getEmbos_name();
        result = result * 59 + ($embos_name == null ? 43 : $embos_name.hashCode());
        Object $exp_dt = this.getExp_dt();
        result = result * 59 + ($exp_dt == null ? 43 : $exp_dt.hashCode());
        Object $cardtype = this.getCardtype();
        result = result * 59 + ($cardtype == null ? 43 : $cardtype.hashCode());
        Result $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "CardInfoDataToMapUzcard(cref_no=" + this.getCref_no() + ", embos_name=" + this.getEmbos_name() + ", exp_dt=" + this.getExp_dt() + ", cardtype=" + this.getCardtype() + ", result=" + this.getResult() + ")";
    }
}
