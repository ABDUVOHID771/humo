package com.example.springhumo.model.dto;

import com.example.springhumo.model.entity.Card;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CardInfoDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("card")
    private CardInfoDto.CardInfo card;
    @JsonProperty("bank")
    private CardInfoDto.Bank bank;

    public CardInfoDto(Card card) {
        this.id = card.getId();
        this.card = new CardInfoDto.CardInfo(card);
    }

    public Integer getId() {
        return this.id;
    }

    public CardInfoDto.CardInfo getCard() {
        return this.card;
    }

    public CardInfoDto.Bank getBank() {
        return this.bank;
    }

    @JsonProperty("id")
    public void setId(final Integer id) {
        this.id = id;
    }

    @JsonProperty("card")
    public void setCard(final CardInfoDto.CardInfo card) {
        this.card = card;
    }

    @JsonProperty("bank")
    public void setBank(final CardInfoDto.Bank bank) {
        this.bank = bank;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardInfoDto)) {
            return false;
        } else {
            CardInfoDto other = (CardInfoDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label47;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label47;
                    }

                    return false;
                }

                Object this$card = this.getCard();
                Object other$card = other.getCard();
                if (this$card == null) {
                    if (other$card != null) {
                        return false;
                    }
                } else if (!this$card.equals(other$card)) {
                    return false;
                }

                Object this$bank = this.getBank();
                Object other$bank = other.getBank();
                if (this$bank == null) {
                    if (other$bank != null) {
                        return false;
                    }
                } else if (!this$bank.equals(other$bank)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardInfoDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        Object $bank = this.getBank();
        result = result * 59 + ($bank == null ? 43 : $bank.hashCode());
        return result;
    }

    public String toString() {
        return "CardInfoDto(id=" + this.getId() + ", card=" + this.getCard() + ", bank=" + this.getBank() + ")";
    }

    public static class Bank {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("code")
        private String code;
        @JsonProperty("mfo")
        private String mfo;
        @JsonProperty("name")
        private String name;
        @JsonProperty("logo")
        private String logo;
        @JsonProperty("sum_max_onetime")
        private Long sumMaxAtOnce;
        @JsonProperty("sum_max_month")
        private Long sumMax;
        @JsonProperty("intrabank_pcnt")
        private BigDecimal percentage;
        @JsonProperty("interbank_pcnt")
        private BigDecimal percentHome;
        @JsonProperty("p2p_enable")
        private Boolean interBank;
        @JsonProperty("visa_code")
        private String visaCode;

        public Bank() {
        }

        public Integer getId() {
            return this.id;
        }

        public String getCode() {
            return this.code;
        }

        public String getMfo() {
            return this.mfo;
        }

        public String getName() {
            return this.name;
        }

        public String getLogo() {
            return this.logo;
        }

        public Long getSumMaxAtOnce() {
            return this.sumMaxAtOnce;
        }

        public Long getSumMax() {
            return this.sumMax;
        }

        public BigDecimal getPercentage() {
            return this.percentage;
        }

        public BigDecimal getPercentHome() {
            return this.percentHome;
        }

        public Boolean getInterBank() {
            return this.interBank;
        }

        public String getVisaCode() {
            return this.visaCode;
        }

        @JsonProperty("id")
        public void setId(final Integer id) {
            this.id = id;
        }

        @JsonProperty("code")
        public void setCode(final String code) {
            this.code = code;
        }

        @JsonProperty("mfo")
        public void setMfo(final String mfo) {
            this.mfo = mfo;
        }

        @JsonProperty("name")
        public void setName(final String name) {
            this.name = name;
        }

        @JsonProperty("logo")
        public void setLogo(final String logo) {
            this.logo = logo;
        }

        @JsonProperty("sum_max_onetime")
        public void setSumMaxAtOnce(final Long sumMaxAtOnce) {
            this.sumMaxAtOnce = sumMaxAtOnce;
        }

        @JsonProperty("sum_max_month")
        public void setSumMax(final Long sumMax) {
            this.sumMax = sumMax;
        }

        @JsonProperty("intrabank_pcnt")
        public void setPercentage(final BigDecimal percentage) {
            this.percentage = percentage;
        }

        @JsonProperty("interbank_pcnt")
        public void setPercentHome(final BigDecimal percentHome) {
            this.percentHome = percentHome;
        }

        @JsonProperty("p2p_enable")
        public void setInterBank(final Boolean interBank) {
            this.interBank = interBank;
        }

        @JsonProperty("visa_code")
        public void setVisaCode(final String visaCode) {
            this.visaCode = visaCode;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CardInfoDto.Bank)) {
                return false;
            } else {
                CardInfoDto.Bank other = (CardInfoDto.Bank) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label143:
                    {
                        Object this$id = this.getId();
                        Object other$id = other.getId();
                        if (this$id == null) {
                            if (other$id == null) {
                                break label143;
                            }
                        } else if (this$id.equals(other$id)) {
                            break label143;
                        }

                        return false;
                    }

                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code != null) {
                            return false;
                        }
                    } else if (!this$code.equals(other$code)) {
                        return false;
                    }

                    Object this$mfo = this.getMfo();
                    Object other$mfo = other.getMfo();
                    if (this$mfo == null) {
                        if (other$mfo != null) {
                            return false;
                        }
                    } else if (!this$mfo.equals(other$mfo)) {
                        return false;
                    }

                    label122:
                    {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null) {
                            if (other$name == null) {
                                break label122;
                            }
                        } else if (this$name.equals(other$name)) {
                            break label122;
                        }

                        return false;
                    }

                    label115:
                    {
                        Object this$logo = this.getLogo();
                        Object other$logo = other.getLogo();
                        if (this$logo == null) {
                            if (other$logo == null) {
                                break label115;
                            }
                        } else if (this$logo.equals(other$logo)) {
                            break label115;
                        }

                        return false;
                    }

                    Object this$sumMaxAtOnce = this.getSumMaxAtOnce();
                    Object other$sumMaxAtOnce = other.getSumMaxAtOnce();
                    if (this$sumMaxAtOnce == null) {
                        if (other$sumMaxAtOnce != null) {
                            return false;
                        }
                    } else if (!this$sumMaxAtOnce.equals(other$sumMaxAtOnce)) {
                        return false;
                    }

                    Object this$sumMax = this.getSumMax();
                    Object other$sumMax = other.getSumMax();
                    if (this$sumMax == null) {
                        if (other$sumMax != null) {
                            return false;
                        }
                    } else if (!this$sumMax.equals(other$sumMax)) {
                        return false;
                    }

                    label94:
                    {
                        Object this$percentage = this.getPercentage();
                        Object other$percentage = other.getPercentage();
                        if (this$percentage == null) {
                            if (other$percentage == null) {
                                break label94;
                            }
                        } else if (this$percentage.equals(other$percentage)) {
                            break label94;
                        }

                        return false;
                    }

                    label87:
                    {
                        Object this$percentHome = this.getPercentHome();
                        Object other$percentHome = other.getPercentHome();
                        if (this$percentHome == null) {
                            if (other$percentHome == null) {
                                break label87;
                            }
                        } else if (this$percentHome.equals(other$percentHome)) {
                            break label87;
                        }

                        return false;
                    }

                    Object this$interBank = this.getInterBank();
                    Object other$interBank = other.getInterBank();
                    if (this$interBank == null) {
                        if (other$interBank != null) {
                            return false;
                        }
                    } else if (!this$interBank.equals(other$interBank)) {
                        return false;
                    }

                    Object this$visaCode = this.getVisaCode();
                    Object other$visaCode = other.getVisaCode();
                    if (this$visaCode == null) {
                        if (other$visaCode != null) {
                            return false;
                        }
                    } else if (!this$visaCode.equals(other$visaCode)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CardInfoDto.Bank;
        }

        public int hashCode() {
            int PRIME = 1;// true
            int result = 1;
            Object $id = this.getId();
            result = result * 59 + ($id == null ? 43 : $id.hashCode());
            Object $code = this.getCode();
            result = result * 59 + ($code == null ? 43 : $code.hashCode());
            Object $mfo = this.getMfo();
            result = result * 59 + ($mfo == null ? 43 : $mfo.hashCode());
            Object $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Object $logo = this.getLogo();
            result = result * 59 + ($logo == null ? 43 : $logo.hashCode());
            Object $sumMaxAtOnce = this.getSumMaxAtOnce();
            result = result * 59 + ($sumMaxAtOnce == null ? 43 : $sumMaxAtOnce.hashCode());
            Object $sumMax = this.getSumMax();
            result = result * 59 + ($sumMax == null ? 43 : $sumMax.hashCode());
            Object $percentage = this.getPercentage();
            result = result * 59 + ($percentage == null ? 43 : $percentage.hashCode());
            Object $percentHome = this.getPercentHome();
            result = result * 59 + ($percentHome == null ? 43 : $percentHome.hashCode());
            Object $interBank = this.getInterBank();
            result = result * 59 + ($interBank == null ? 43 : $interBank.hashCode());
            Object $visaCode = this.getVisaCode();
            result = result * 59 + ($visaCode == null ? 43 : $visaCode.hashCode());
            return result;
        }

        public String toString() {
            return "CardInfoDto.Bank(id=" + this.getId() + ", code=" + this.getCode() + ", mfo=" + this.getMfo() + ", name=" + this.getName() + ", logo=" + this.getLogo() + ", sumMaxAtOnce=" + this.getSumMaxAtOnce() + ", sumMax=" + this.getSumMax() + ", percentage=" + this.getPercentage() + ", percentHome=" + this.getPercentHome() + ", interBank=" + this.getInterBank() + ", visaCode=" + this.getVisaCode() + ")";
        }
    }

    public static class CardInfo {
        @JsonProperty("id")
        private String token;
        @JsonProperty("balance")
        private Long balance;
        @JsonProperty("expiry")
        private String expiry;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("pan")
        private String pan;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("sms")
        private Boolean sms;
        @JsonProperty("status")
        private Integer status;

        public CardInfo(Card card) {
            this.token = card.getToken();
            this.balance = card.getBalance();
            this.expiry = card.getExpDate();
            this.fullName = card.getHolder();
            this.pan = card.getPan();
            this.phone = card.getPhone();
            this.sms = card.getSms();
            this.status = card.getStatus();
        }

        public String getToken() {
            return this.token;
        }

        public Long getBalance() {
            return this.balance;
        }

        public String getExpiry() {
            return this.expiry;
        }

        public String getFullName() {
            return this.fullName;
        }

        public String getPan() {
            return this.pan;
        }

        public String getPhone() {
            return this.phone;
        }

        public Boolean getSms() {
            return this.sms;
        }

        public Integer getStatus() {
            return this.status;
        }

        @JsonProperty("id")
        public void setToken(final String token) {
            this.token = token;
        }

        @JsonProperty("balance")
        public void setBalance(final Long balance) {
            this.balance = balance;
        }

        @JsonProperty("expiry")
        public void setExpiry(final String expiry) {
            this.expiry = expiry;
        }

        @JsonProperty("full_name")
        public void setFullName(final String fullName) {
            this.fullName = fullName;
        }

        @JsonProperty("pan")
        public void setPan(final String pan) {
            this.pan = pan;
        }

        @JsonProperty("phone")
        public void setPhone(final String phone) {
            this.phone = phone;
        }

        @JsonProperty("sms")
        public void setSms(final Boolean sms) {
            this.sms = sms;
        }

        @JsonProperty("status")
        public void setStatus(final Integer status) {
            this.status = status;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CardInfoDto.CardInfo)) {
                return false;
            } else {
                CardInfoDto.CardInfo other = (CardInfoDto.CardInfo) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label107:
                    {
                        Object this$token = this.getToken();
                        Object other$token = other.getToken();
                        if (this$token == null) {
                            if (other$token == null) {
                                break label107;
                            }
                        } else if (this$token.equals(other$token)) {
                            break label107;
                        }

                        return false;
                    }

                    Object this$balance = this.getBalance();
                    Object other$balance = other.getBalance();
                    if (this$balance == null) {
                        if (other$balance != null) {
                            return false;
                        }
                    } else if (!this$balance.equals(other$balance)) {
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

                    label86:
                    {
                        Object this$fullName = this.getFullName();
                        Object other$fullName = other.getFullName();
                        if (this$fullName == null) {
                            if (other$fullName == null) {
                                break label86;
                            }
                        } else if (this$fullName.equals(other$fullName)) {
                            break label86;
                        }

                        return false;
                    }

                    label79:
                    {
                        Object this$pan = this.getPan();
                        Object other$pan = other.getPan();
                        if (this$pan == null) {
                            if (other$pan == null) {
                                break label79;
                            }
                        } else if (this$pan.equals(other$pan)) {
                            break label79;
                        }

                        return false;
                    }

                    label72:
                    {
                        Object this$phone = this.getPhone();
                        Object other$phone = other.getPhone();
                        if (this$phone == null) {
                            if (other$phone == null) {
                                break label72;
                            }
                        } else if (this$phone.equals(other$phone)) {
                            break label72;
                        }

                        return false;
                    }

                    Object this$sms = this.getSms();
                    Object other$sms = other.getSms();
                    if (this$sms == null) {
                        if (other$sms != null) {
                            return false;
                        }
                    } else if (!this$sms.equals(other$sms)) {
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

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CardInfoDto.CardInfo;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $token = this.getToken();
            result = result * 59 + ($token == null ? 43 : $token.hashCode());
            Object $balance = this.getBalance();
            result = result * 59 + ($balance == null ? 43 : $balance.hashCode());
            Object $expiry = this.getExpiry();
            result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
            Object $fullName = this.getFullName();
            result = result * 59 + ($fullName == null ? 43 : $fullName.hashCode());
            Object $pan = this.getPan();
            result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
            Object $phone = this.getPhone();
            result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
            Object $sms = this.getSms();
            result = result * 59 + ($sms == null ? 43 : $sms.hashCode());
            Object $status = this.getStatus();
            result = result * 59 + ($status == null ? 43 : $status.hashCode());
            return result;
        }

        public String toString() {
            return "CardInfoDto.CardInfo(token=" + this.getToken() + ", balance=" + this.getBalance() + ", expiry=" + this.getExpiry() + ", fullName=" + this.getFullName() + ", pan=" + this.getPan() + ", phone=" + this.getPhone() + ", sms=" + this.getSms() + ", status=" + this.getStatus() + ")";
        }
    }
}
