package com.example.springhumo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(
        name = "banks"
)
public class Bank {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer bankId = 0;
    @Column(
            name = "bank_code"
    )
    private String bankCode;
    @Column(
            name = "bank_mfo"
    )
    private String bankMfo;
    @Column(
            name = "bank_card"
    )
    private String bankCard;
    @Column(
            name = "bank_name"
    )
    private String bankName;
    @Column(
            name = "percentage"
    )
    private Double percentage;
    @Column(
            name = "percent_home"
    )
    private Double percentHome;
    @Column(
            name = "center_id"
    )
    private String centerId;

    public Bank() {
    }

    public Integer getBankId() {
        return this.bankId;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankMfo() {
        return this.bankMfo;
    }

    public String getBankCard() {
        return this.bankCard;
    }

    public String getBankName() {
        return this.bankName;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    public Double getPercentHome() {
        return this.percentHome;
    }

    public String getCenterId() {
        return this.centerId;
    }

    public void setBankId(final Integer bankId) {
        this.bankId = bankId;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankMfo(final String bankMfo) {
        this.bankMfo = bankMfo;
    }

    public void setBankCard(final String bankCard) {
        this.bankCard = bankCard;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public void setPercentage(final Double percentage) {
        this.percentage = percentage;
    }

    public void setPercentHome(final Double percentHome) {
        this.percentHome = percentHome;
    }

    public void setCenterId(final String centerId) {
        this.centerId = centerId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Bank)) {
            return false;
        } else {
            Bank other = (Bank) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107:
                {
                    Object this$bankId = this.getBankId();
                    Object other$bankId = other.getBankId();
                    if (this$bankId == null) {
                        if (other$bankId == null) {
                            break label107;
                        }
                    } else if (this$bankId.equals(other$bankId)) {
                        break label107;
                    }

                    return false;
                }

                Object this$bankCode = this.getBankCode();
                Object other$bankCode = other.getBankCode();
                if (this$bankCode == null) {
                    if (other$bankCode != null) {
                        return false;
                    }
                } else if (!this$bankCode.equals(other$bankCode)) {
                    return false;
                }

                Object this$bankMfo = this.getBankMfo();
                Object other$bankMfo = other.getBankMfo();
                if (this$bankMfo == null) {
                    if (other$bankMfo != null) {
                        return false;
                    }
                } else if (!this$bankMfo.equals(other$bankMfo)) {
                    return false;
                }

                label86:
                {
                    Object this$bankCard = this.getBankCard();
                    Object other$bankCard = other.getBankCard();
                    if (this$bankCard == null) {
                        if (other$bankCard == null) {
                            break label86;
                        }
                    } else if (this$bankCard.equals(other$bankCard)) {
                        break label86;
                    }

                    return false;
                }

                label79:
                {
                    Object this$bankName = this.getBankName();
                    Object other$bankName = other.getBankName();
                    if (this$bankName == null) {
                        if (other$bankName == null) {
                            break label79;
                        }
                    } else if (this$bankName.equals(other$bankName)) {
                        break label79;
                    }

                    return false;
                }

                label72:
                {
                    Object this$percentage = this.getPercentage();
                    Object other$percentage = other.getPercentage();
                    if (this$percentage == null) {
                        if (other$percentage == null) {
                            break label72;
                        }
                    } else if (this$percentage.equals(other$percentage)) {
                        break label72;
                    }

                    return false;
                }

                Object this$percentHome = this.getPercentHome();
                Object other$percentHome = other.getPercentHome();
                if (this$percentHome == null) {
                    if (other$percentHome != null) {
                        return false;
                    }
                } else if (!this$percentHome.equals(other$percentHome)) {
                    return false;
                }

                Object this$centerId = this.getCenterId();
                Object other$centerId = other.getCenterId();
                if (this$centerId == null) {
                    if (other$centerId != null) {
                        return false;
                    }
                } else if (!this$centerId.equals(other$centerId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Bank;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        Object $bankCode = this.getBankCode();
        result = result * 59 + ($bankCode == null ? 43 : $bankCode.hashCode());
        Object $bankMfo = this.getBankMfo();
        result = result * 59 + ($bankMfo == null ? 43 : $bankMfo.hashCode());
        Object $bankCard = this.getBankCard();
        result = result * 59 + ($bankCard == null ? 43 : $bankCard.hashCode());
        Object $bankName = this.getBankName();
        result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
        Object $percentage = this.getPercentage();
        result = result * 59 + ($percentage == null ? 43 : $percentage.hashCode());
        Object $percentHome = this.getPercentHome();
        result = result * 59 + ($percentHome == null ? 43 : $percentHome.hashCode());
        Object $centerId = this.getCenterId();
        result = result * 59 + ($centerId == null ? 43 : $centerId.hashCode());
        return result;
    }

    public String toString() {
        return "Bank(bankId=" + this.getBankId() + ", bankCode=" + this.getBankCode() + ", bankMfo=" + this.getBankMfo() + ", bankCard=" + this.getBankCard() + ", bankName=" + this.getBankName() + ", percentage=" + this.getPercentage() + ", percentHome=" + this.getPercentHome() + ", centerId=" + this.getCenterId() + ")";
    }
}
