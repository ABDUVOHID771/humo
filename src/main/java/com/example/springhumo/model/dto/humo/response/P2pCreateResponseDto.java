package com.example.springhumo.model.dto.humo.response;

import com.example.springhumo.model.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

public class P2pCreateResponseDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("refNum")
    private String refNum;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("currency")
    private Integer currency;
    @JsonProperty("date12")
    private String date12;
    @JsonProperty("date7")
    private String date7;
    @JsonProperty("expiry")
    private String expiry;
    @JsonProperty("ext")
    private String ext;
    @JsonProperty("field48")
    private String field48;
    @JsonProperty("merchantId")
    private String merchantId;
    @JsonProperty("terminalId")
    private String terminalId;
    @JsonProperty("pan")
    private String pan;
    @JsonProperty("pan2")
    private String pan2;
    @JsonProperty("resp")
    private Integer resp;
    @JsonProperty("stan")
    private Integer stan;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tranType")
    private String tranType;
    @JsonProperty("authId")
    private String authId;
    @JsonProperty("field91")
    private String field91;
    @JsonProperty("result")
    private Result result;

    public P2pCreateResponseDto() {
    }

    public String getId() {
        return this.id;
    }

    public String getRefNum() {
        return this.refNum;
    }

    public Long getAmount() {
        return this.amount;
    }

    public Integer getCurrency() {
        return this.currency;
    }

    public String getDate12() {
        return this.date12;
    }

    public String getDate7() {
        return this.date7;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public String getExt() {
        return this.ext;
    }

    public String getField48() {
        return this.field48;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public String getPan() {
        return this.pan;
    }

    public String getPan2() {
        return this.pan2;
    }

    public Integer getResp() {
        return this.resp;
    }

    public Integer getStan() {
        return this.stan;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTranType() {
        return this.tranType;
    }

    public String getAuthId() {
        return this.authId;
    }

    public String getField91() {
        return this.field91;
    }

    public Result getResult() {
        return this.result;
    }

    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }

    @JsonProperty("refNum")
    public void setRefNum(final String refNum) {
        this.refNum = refNum;
    }

    @JsonProperty("amount")
    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public void setCurrency(final Integer currency) {
        this.currency = currency;
    }

    @JsonProperty("date12")
    public void setDate12(final String date12) {
        this.date12 = date12;
    }

    @JsonProperty("date7")
    public void setDate7(final String date7) {
        this.date7 = date7;
    }

    @JsonProperty("expiry")
    public void setExpiry(final String expiry) {
        this.expiry = expiry;
    }

    @JsonProperty("ext")
    public void setExt(final String ext) {
        this.ext = ext;
    }

    @JsonProperty("field48")
    public void setField48(final String field48) {
        this.field48 = field48;
    }

    @JsonProperty("merchantId")
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("terminalId")
    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    @JsonProperty("pan")
    public void setPan(final String pan) {
        this.pan = pan;
    }

    @JsonProperty("pan2")
    public void setPan2(final String pan2) {
        this.pan2 = pan2;
    }

    @JsonProperty("resp")
    public void setResp(final Integer resp) {
        this.resp = resp;
    }

    @JsonProperty("stan")
    public void setStan(final Integer stan) {
        this.stan = stan;
    }

    @JsonProperty("status")
    public void setStatus(final String status) {
        this.status = status;
    }

    @JsonProperty("tranType")
    public void setTranType(final String tranType) {
        this.tranType = tranType;
    }

    @JsonProperty("authId")
    public void setAuthId(final String authId) {
        this.authId = authId;
    }

    @JsonProperty("field91")
    public void setField91(final String field91) {
        this.field91 = field91;
    }

    @JsonProperty("result")
    public void setResult(final Result result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof P2pCreateResponseDto)) {
            return false;
        } else {
            P2pCreateResponseDto other = (P2pCreateResponseDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label251:
                {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label251;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label251;
                    }

                    return false;
                }

                Object this$refNum = this.getRefNum();
                Object other$refNum = other.getRefNum();
                if (this$refNum == null) {
                    if (other$refNum != null) {
                        return false;
                    }
                } else if (!this$refNum.equals(other$refNum)) {
                    return false;
                }

                Object this$amount = this.getAmount();
                Object other$amount = other.getAmount();
                if (this$amount == null) {
                    if (other$amount != null) {
                        return false;
                    }
                } else if (!this$amount.equals(other$amount)) {
                    return false;
                }

                label230:
                {
                    Object this$currency = this.getCurrency();
                    Object other$currency = other.getCurrency();
                    if (this$currency == null) {
                        if (other$currency == null) {
                            break label230;
                        }
                    } else if (this$currency.equals(other$currency)) {
                        break label230;
                    }

                    return false;
                }

                label223:
                {
                    Object this$date12 = this.getDate12();
                    Object other$date12 = other.getDate12();
                    if (this$date12 == null) {
                        if (other$date12 == null) {
                            break label223;
                        }
                    } else if (this$date12.equals(other$date12)) {
                        break label223;
                    }

                    return false;
                }

                label216:
                {
                    Object this$date7 = this.getDate7();
                    Object other$date7 = other.getDate7();
                    if (this$date7 == null) {
                        if (other$date7 == null) {
                            break label216;
                        }
                    } else if (this$date7.equals(other$date7)) {
                        break label216;
                    }

                    return false;
                }

                Object this$expiry = this.getExpiry();
                Object other$expiry = other.getExpiry();
                if (this$expiry == null) {
                    if (other$expiry != null) {
                        return false;
                    }
                } else if (!this$expiry.equals(other$expiry)) {
                    return false;
                }

                label202:
                {
                    Object this$ext = this.getExt();
                    Object other$ext = other.getExt();
                    if (this$ext == null) {
                        if (other$ext == null) {
                            break label202;
                        }
                    } else if (this$ext.equals(other$ext)) {
                        break label202;
                    }

                    return false;
                }

                Object this$field48 = this.getField48();
                Object other$field48 = other.getField48();
                if (this$field48 == null) {
                    if (other$field48 != null) {
                        return false;
                    }
                } else if (!this$field48.equals(other$field48)) {
                    return false;
                }

                label188:
                {
                    Object this$merchantId = this.getMerchantId();
                    Object other$merchantId = other.getMerchantId();
                    if (this$merchantId == null) {
                        if (other$merchantId == null) {
                            break label188;
                        }
                    } else if (this$merchantId.equals(other$merchantId)) {
                        break label188;
                    }

                    return false;
                }

                Object this$terminalId = this.getTerminalId();
                Object other$terminalId = other.getTerminalId();
                if (this$terminalId == null) {
                    if (other$terminalId != null) {
                        return false;
                    }
                } else if (!this$terminalId.equals(other$terminalId)) {
                    return false;
                }

                Object this$pan = this.getPan();
                Object other$pan = other.getPan();
                if (this$pan == null) {
                    if (other$pan != null) {
                        return false;
                    }
                } else if (!this$pan.equals(other$pan)) {
                    return false;
                }

                label167:
                {
                    Object this$pan2 = this.getPan2();
                    Object other$pan2 = other.getPan2();
                    if (this$pan2 == null) {
                        if (other$pan2 == null) {
                            break label167;
                        }
                    } else if (this$pan2.equals(other$pan2)) {
                        break label167;
                    }

                    return false;
                }

                label160:
                {
                    Object this$resp = this.getResp();
                    Object other$resp = other.getResp();
                    if (this$resp == null) {
                        if (other$resp == null) {
                            break label160;
                        }
                    } else if (this$resp.equals(other$resp)) {
                        break label160;
                    }

                    return false;
                }

                Object this$stan = this.getStan();
                Object other$stan = other.getStan();
                if (this$stan == null) {
                    if (other$stan != null) {
                        return false;
                    }
                } else if (!this$stan.equals(other$stan)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                label139:
                {
                    Object this$tranType = this.getTranType();
                    Object other$tranType = other.getTranType();
                    if (this$tranType == null) {
                        if (other$tranType == null) {
                            break label139;
                        }
                    } else if (this$tranType.equals(other$tranType)) {
                        break label139;
                    }

                    return false;
                }

                Object this$authId = this.getAuthId();
                Object other$authId = other.getAuthId();
                if (this$authId == null) {
                    if (other$authId != null) {
                        return false;
                    }
                } else if (!this$authId.equals(other$authId)) {
                    return false;
                }

                Object this$field91 = this.getField91();
                Object other$field91 = other.getField91();
                if (this$field91 == null) {
                    if (other$field91 != null) {
                        return false;
                    }
                } else if (!this$field91.equals(other$field91)) {
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
        return other instanceof P2pCreateResponseDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $refNum = this.getRefNum();
        result = result * 59 + ($refNum == null ? 43 : $refNum.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        Object $date12 = this.getDate12();
        result = result * 59 + ($date12 == null ? 43 : $date12.hashCode());
        Object $date7 = this.getDate7();
        result = result * 59 + ($date7 == null ? 43 : $date7.hashCode());
        Object $expiry = this.getExpiry();
        result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
        Object $ext = this.getExt();
        result = result * 59 + ($ext == null ? 43 : $ext.hashCode());
        Object $field48 = this.getField48();
        result = result * 59 + ($field48 == null ? 43 : $field48.hashCode());
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $pan = this.getPan();
        result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
        Object $pan2 = this.getPan2();
        result = result * 59 + ($pan2 == null ? 43 : $pan2.hashCode());
        Object $resp = this.getResp();
        result = result * 59 + ($resp == null ? 43 : $resp.hashCode());
        Object $stan = this.getStan();
        result = result * 59 + ($stan == null ? 43 : $stan.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $tranType = this.getTranType();
        result = result * 59 + ($tranType == null ? 43 : $tranType.hashCode());
        Object $authId = this.getAuthId();
        result = result * 59 + ($authId == null ? 43 : $authId.hashCode());
        Object $field91 = this.getField91();
        result = result * 59 + ($field91 == null ? 43 : $field91.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "P2pCreateResponseDto(id=" + this.getId() + ", refNum=" + this.getRefNum() + ", amount=" + this.getAmount() + ", currency=" + this.getCurrency() + ", date12=" + this.getDate12() + ", date7=" + this.getDate7() + ", expiry=" + this.getExpiry() + ", ext=" + this.getExt() + ", field48=" + this.getField48() + ", merchantId=" + this.getMerchantId() + ", terminalId=" + this.getTerminalId() + ", pan=" + this.getPan() + ", pan2=" + this.getPan2() + ", resp=" + this.getResp() + ", stan=" + this.getStan() + ", status=" + this.getStatus() + ", tranType=" + this.getTranType() + ", authId=" + this.getAuthId() + ", field91=" + this.getField91() + ", result=" + this.getResult() + ")";
    }
}
