package com.example.springhumo.model.dto.humo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JacksonXmlRootElement(
        localName = "envelop"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class CheckSmsEnabledResponseEnvelopDto {
    @JacksonXmlProperty(
            localName = "cardholderID"
    )
    private String cardHolderId;
    @JacksonXmlProperty(
            localName = "bankId"
    )
    private String bankId;
    @JacksonXmlProperty(
            localName = "cardholderName"
    )
    private String cardholderName;
    @JacksonXmlProperty(
            localName = "state"
    )
    private String state;
    @JacksonXmlProperty(
            localName = "language"
    )
    private String language;
    @JacksonXmlProperty(
            localName = "Charge"
    )
    private CheckSmsEnabledResponseEnvelopDto.Charge charge;
    @JacksonXmlProperty(
            localName = "CardInfo",
            isAttribute = true
    )
    @JacksonXmlElementWrapper(
            useWrapping = false
    )
    private List<CheckSmsEnabledResponseEnvelopDto.Card> cards;
    @JacksonXmlProperty(
            localName = "Phone"
    )
    private CheckSmsEnabledResponseEnvelopDto.Phone phone;

    public CheckSmsEnabledResponseEnvelopDto() {
    }

    public String getCardHolderId() {
        return this.cardHolderId;
    }

    public String getBankId() {
        return this.bankId;
    }

    public String getCardholderName() {
        return this.cardholderName;
    }

    public String getState() {
        return this.state;
    }

    public String getLanguage() {
        return this.language;
    }

    public CheckSmsEnabledResponseEnvelopDto.Charge getCharge() {
        return this.charge;
    }

    public List<CheckSmsEnabledResponseEnvelopDto.Card> getCards() {
        return this.cards;
    }

    public CheckSmsEnabledResponseEnvelopDto.Phone getPhone() {
        return this.phone;
    }

    public void setCardHolderId(final String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }

    public void setCardholderName(final String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public void setCharge(final CheckSmsEnabledResponseEnvelopDto.Charge charge) {
        this.charge = charge;
    }

    public void setCards(final List<CheckSmsEnabledResponseEnvelopDto.Card> cards) {
        this.cards = cards;
    }

    public void setPhone(final CheckSmsEnabledResponseEnvelopDto.Phone phone) {
        this.phone = phone;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CheckSmsEnabledResponseEnvelopDto)) {
            return false;
        } else {
            CheckSmsEnabledResponseEnvelopDto other = (CheckSmsEnabledResponseEnvelopDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$cardHolderId = this.getCardHolderId();
                    Object other$cardHolderId = other.getCardHolderId();
                    if (this$cardHolderId == null) {
                        if (other$cardHolderId == null) {
                            break label107;
                        }
                    } else if (this$cardHolderId.equals(other$cardHolderId)) {
                        break label107;
                    }

                    return false;
                }

                Object this$bankId = this.getBankId();
                Object other$bankId = other.getBankId();
                if (this$bankId == null) {
                    if (other$bankId != null) {
                        return false;
                    }
                } else if (!this$bankId.equals(other$bankId)) {
                    return false;
                }

                Object this$cardholderName = this.getCardholderName();
                Object other$cardholderName = other.getCardholderName();
                if (this$cardholderName == null) {
                    if (other$cardholderName != null) {
                        return false;
                    }
                } else if (!this$cardholderName.equals(other$cardholderName)) {
                    return false;
                }

                label86: {
                    Object this$state = this.getState();
                    Object other$state = other.getState();
                    if (this$state == null) {
                        if (other$state == null) {
                            break label86;
                        }
                    } else if (this$state.equals(other$state)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$language = this.getLanguage();
                    Object other$language = other.getLanguage();
                    if (this$language == null) {
                        if (other$language == null) {
                            break label79;
                        }
                    } else if (this$language.equals(other$language)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$charge = this.getCharge();
                    Object other$charge = other.getCharge();
                    if (this$charge == null) {
                        if (other$charge == null) {
                            break label72;
                        }
                    } else if (this$charge.equals(other$charge)) {
                        break label72;
                    }

                    return false;
                }

                Object this$cards = this.getCards();
                Object other$cards = other.getCards();
                if (this$cards == null) {
                    if (other$cards != null) {
                        return false;
                    }
                } else if (!this$cards.equals(other$cards)) {
                    return false;
                }

                Object this$phone = this.getPhone();
                Object other$phone = other.getPhone();
                if (this$phone == null) {
                    if (other$phone != null) {
                        return false;
                    }
                } else if (!this$phone.equals(other$phone)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CheckSmsEnabledResponseEnvelopDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $cardHolderId = this.getCardHolderId();
        result = result * 59 + ($cardHolderId == null ? 43 : $cardHolderId.hashCode());
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        Object $cardholderName = this.getCardholderName();
        result = result * 59 + ($cardholderName == null ? 43 : $cardholderName.hashCode());
        Object $state = this.getState();
        result = result * 59 + ($state == null ? 43 : $state.hashCode());
        Object $language = this.getLanguage();
        result = result * 59 + ($language == null ? 43 : $language.hashCode());
        Object $charge = this.getCharge();
        result = result * 59 + ($charge == null ? 43 : $charge.hashCode());
        Object $cards = this.getCards();
        result = result * 59 + ($cards == null ? 43 : $cards.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        return result;
    }

    public String toString() {
        return "CheckSmsEnabledResponseEnvelopDto(cardHolderId=" + this.getCardHolderId() + ", bankId=" + this.getBankId() + ", cardholderName=" + this.getCardholderName() + ", state=" + this.getState() + ", language=" + this.getLanguage() + ", charge=" + this.getCharge() + ", cards=" + this.getCards() + ", phone=" + this.getPhone() + ")";
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Phone {
        @JacksonXmlProperty(
                localName = "state"
        )
        private String state;
        @JacksonXmlProperty(
                localName = "msisdn"
        )
        private String msisdn;
        @JacksonXmlProperty(
                localName = "deliveryChannel"
        )
        private String deliveryChannel;

        public Phone() {
        }

        public String getState() {
            return this.state;
        }

        public String getMsisdn() {
            return this.msisdn;
        }

        public String getDeliveryChannel() {
            return this.deliveryChannel;
        }

        public void setState(final String state) {
            this.state = state;
        }

        public void setMsisdn(final String msisdn) {
            this.msisdn = msisdn;
        }

        public void setDeliveryChannel(final String deliveryChannel) {
            this.deliveryChannel = deliveryChannel;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CheckSmsEnabledResponseEnvelopDto.Phone)) {
                return false;
            } else {
                CheckSmsEnabledResponseEnvelopDto.Phone other = (CheckSmsEnabledResponseEnvelopDto.Phone)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label47: {
                        Object this$state = this.getState();
                        Object other$state = other.getState();
                        if (this$state == null) {
                            if (other$state == null) {
                                break label47;
                            }
                        } else if (this$state.equals(other$state)) {
                            break label47;
                        }

                        return false;
                    }

                    Object this$msisdn = this.getMsisdn();
                    Object other$msisdn = other.getMsisdn();
                    if (this$msisdn == null) {
                        if (other$msisdn != null) {
                            return false;
                        }
                    } else if (!this$msisdn.equals(other$msisdn)) {
                        return false;
                    }

                    Object this$deliveryChannel = this.getDeliveryChannel();
                    Object other$deliveryChannel = other.getDeliveryChannel();
                    if (this$deliveryChannel == null) {
                        if (other$deliveryChannel != null) {
                            return false;
                        }
                    } else if (!this$deliveryChannel.equals(other$deliveryChannel)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CheckSmsEnabledResponseEnvelopDto.Phone;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $state = this.getState();
            result = result * 59 + ($state == null ? 43 : $state.hashCode());
            Object $msisdn = this.getMsisdn();
            result = result * 59 + ($msisdn == null ? 43 : $msisdn.hashCode());
            Object $deliveryChannel = this.getDeliveryChannel();
            result = result * 59 + ($deliveryChannel == null ? 43 : $deliveryChannel.hashCode());
            return result;
        }

        public String toString() {
            return "CheckSmsEnabledResponseEnvelopDto.Phone(state=" + this.getState() + ", msisdn=" + this.getMsisdn() + ", deliveryChannel=" + this.getDeliveryChannel() + ")";
        }
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Card {
        @JacksonXmlProperty(
                localName = "state"
        )
        private String state;
        @JacksonXmlProperty(
                localName = "pan"
        )
        private String pan;
        @JacksonXmlProperty(
                localName = "expiry"
        )
        private String expiry;

        public Card() {
        }

        public String getState() {
            return this.state;
        }

        public String getPan() {
            return this.pan;
        }

        public String getExpiry() {
            return this.expiry;
        }

        public void setState(final String state) {
            this.state = state;
        }

        public void setPan(final String pan) {
            this.pan = pan;
        }

        public void setExpiry(final String expiry) {
            this.expiry = expiry;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CheckSmsEnabledResponseEnvelopDto.Card)) {
                return false;
            } else {
                CheckSmsEnabledResponseEnvelopDto.Card other = (CheckSmsEnabledResponseEnvelopDto.Card)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label47: {
                        Object this$state = this.getState();
                        Object other$state = other.getState();
                        if (this$state == null) {
                            if (other$state == null) {
                                break label47;
                            }
                        } else if (this$state.equals(other$state)) {
                            break label47;
                        }

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

                    Object this$expiry = this.getExpiry();
                    Object other$expiry = other.getExpiry();
                    if (this$expiry == null) {
                        if (other$expiry != null) {
                            return false;
                        }
                    } else if (!this$expiry.equals(other$expiry)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CheckSmsEnabledResponseEnvelopDto.Card;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $state = this.getState();
            result = result * 59 + ($state == null ? 43 : $state.hashCode());
            Object $pan = this.getPan();
            result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
            Object $expiry = this.getExpiry();
            result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
            return result;
        }

        public String toString() {
            return "CheckSmsEnabledResponseEnvelopDto.Card(state=" + this.getState() + ", pan=" + this.getPan() + ", expiry=" + this.getExpiry() + ")";
        }
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Charge {
        @JacksonXmlProperty(
                localName = "agreementCharge"
        )
        private String agreementCharge;
        @JacksonXmlProperty(
                localName = "chargeAccount"
        )
        private String chargeAccount;

        public Charge() {
        }

        public String getAgreementCharge() {
            return this.agreementCharge;
        }

        public String getChargeAccount() {
            return this.chargeAccount;
        }

        public void setAgreementCharge(final String agreementCharge) {
            this.agreementCharge = agreementCharge;
        }

        public void setChargeAccount(final String chargeAccount) {
            this.chargeAccount = chargeAccount;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CheckSmsEnabledResponseEnvelopDto.Charge)) {
                return false;
            } else {
                CheckSmsEnabledResponseEnvelopDto.Charge other = (CheckSmsEnabledResponseEnvelopDto.Charge)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$agreementCharge = this.getAgreementCharge();
                    Object other$agreementCharge = other.getAgreementCharge();
                    if (this$agreementCharge == null) {
                        if (other$agreementCharge != null) {
                            return false;
                        }
                    } else if (!this$agreementCharge.equals(other$agreementCharge)) {
                        return false;
                    }

                    Object this$chargeAccount = this.getChargeAccount();
                    Object other$chargeAccount = other.getChargeAccount();
                    if (this$chargeAccount == null) {
                        if (other$chargeAccount != null) {
                            return false;
                        }
                    } else if (!this$chargeAccount.equals(other$chargeAccount)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CheckSmsEnabledResponseEnvelopDto.Charge;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $agreementCharge = this.getAgreementCharge();
            result = result * 59 + ($agreementCharge == null ? 43 : $agreementCharge.hashCode());
            Object $chargeAccount = this.getChargeAccount();
            result = result * 59 + ($chargeAccount == null ? 43 : $chargeAccount.hashCode());
            return result;
        }

        public String toString() {
            return "CheckSmsEnabledResponseEnvelopDto.Charge(agreementCharge=" + this.getAgreementCharge() + ", chargeAccount=" + this.getChargeAccount() + ")";
        }
    }
}
