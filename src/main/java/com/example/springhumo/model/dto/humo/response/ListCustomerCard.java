package com.example.springhumo.model.dto.humo.response;

import com.example.springhumo.constant.HumoCardStatus;
import com.example.springhumo.constant.HumoStopCause;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

@JsonNaming(SnakeCaseStrategy.class)
public class ListCustomerCard {
    private String card;
    private String cardType;
    private String expiry;
    private String baseSupp;
    private String condSet;
    private String agreementKey;
    private String riskLevel;
    private String status1;
    private String stopCause;
    private String cardName;
    private String clRole;
    private String bankC;
    private String groupC;
    private String client;
    private String clientB;

    public ListCustomerCard(Map<String, String> map) {
        this.card = (String) map.getOrDefault("CARD", "");
        this.cardType = (String) map.getOrDefault("CARD_TYPE", "");
        this.expiry = (String) map.getOrDefault("EXPIRY1", "");
        this.baseSupp = (String) map.getOrDefault("BASE_SUPP", "");
        this.condSet = (String) map.getOrDefault("COND_SET", "");
        this.agreementKey = (String) map.getOrDefault("AGREEMENT_KEY", "");
        this.riskLevel = (String) map.getOrDefault("RISK_LEVEL", "");
        this.status1 = (String) map.getOrDefault("STATUS1", "0");
        this.stopCause = (String) map.getOrDefault("STOP_CAUSE", "0");
        this.cardName = (String) map.getOrDefault("CARD_NAME", "");
        this.clRole = (String) map.getOrDefault("CL_ROLE", "");
        this.bankC = (String) map.getOrDefault("BANK_C", "");
        this.groupC = (String) map.getOrDefault("GROUPC", "");
        this.client = (String) map.getOrDefault("CLIENT", "");
        this.clientB = (String) map.getOrDefault("CLIENT_B", "");
    }

    @JsonIgnore
    public HumoCardStatus getStatusEnum() {
        Integer status = Integer.valueOf(this.status1);
        return HumoCardStatus.findById(status);
    }

    @JsonIgnore
    public HumoStopCause getStopCauseEnum() {
        Integer cause = Integer.valueOf(this.stopCause);
        return HumoStopCause.findById(cause);
    }

    public String getCard() {
        return this.card;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public String getBaseSupp() {
        return this.baseSupp;
    }

    public String getCondSet() {
        return this.condSet;
    }

    public String getAgreementKey() {
        return this.agreementKey;
    }

    public String getRiskLevel() {
        return this.riskLevel;
    }

    public String getStatus1() {
        return this.status1;
    }

    public String getStopCause() {
        return this.stopCause;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getClRole() {
        return this.clRole;
    }

    public String getBankC() {
        return this.bankC;
    }

    public String getGroupC() {
        return this.groupC;
    }

    public String getClient() {
        return this.client;
    }

    public String getClientB() {
        return this.clientB;
    }

    public void setCard(final String card) {
        this.card = card;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public void setExpiry(final String expiry) {
        this.expiry = expiry;
    }

    public void setBaseSupp(final String baseSupp) {
        this.baseSupp = baseSupp;
    }

    public void setCondSet(final String condSet) {
        this.condSet = condSet;
    }

    public void setAgreementKey(final String agreementKey) {
        this.agreementKey = agreementKey;
    }

    public void setRiskLevel(final String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void setStatus1(final String status1) {
        this.status1 = status1;
    }

    public void setStopCause(final String stopCause) {
        this.stopCause = stopCause;
    }

    public void setCardName(final String cardName) {
        this.cardName = cardName;
    }

    public void setClRole(final String clRole) {
        this.clRole = clRole;
    }

    public void setBankC(final String bankC) {
        this.bankC = bankC;
    }

    public void setGroupC(final String groupC) {
        this.groupC = groupC;
    }

    public void setClient(final String client) {
        this.client = client;
    }

    public void setClientB(final String clientB) {
        this.clientB = clientB;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ListCustomerCard)) {
            return false;
        } else {
            ListCustomerCard other = (ListCustomerCard) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label191:
                {
                    Object this$card = this.getCard();
                    Object other$card = other.getCard();
                    if (this$card == null) {
                        if (other$card == null) {
                            break label191;
                        }
                    } else if (this$card.equals(other$card)) {
                        break label191;
                    }

                    return false;
                }

                Object this$cardType = this.getCardType();
                Object other$cardType = other.getCardType();
                if (this$cardType == null) {
                    if (other$cardType != null) {
                        return false;
                    }
                } else if (!this$cardType.equals(other$cardType)) {
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

                label170:
                {
                    Object this$baseSupp = this.getBaseSupp();
                    Object other$baseSupp = other.getBaseSupp();
                    if (this$baseSupp == null) {
                        if (other$baseSupp == null) {
                            break label170;
                        }
                    } else if (this$baseSupp.equals(other$baseSupp)) {
                        break label170;
                    }

                    return false;
                }

                label163:
                {
                    Object this$condSet = this.getCondSet();
                    Object other$condSet = other.getCondSet();
                    if (this$condSet == null) {
                        if (other$condSet == null) {
                            break label163;
                        }
                    } else if (this$condSet.equals(other$condSet)) {
                        break label163;
                    }

                    return false;
                }

                Object this$agreementKey = this.getAgreementKey();
                Object other$agreementKey = other.getAgreementKey();
                if (this$agreementKey == null) {
                    if (other$agreementKey != null) {
                        return false;
                    }
                } else if (!this$agreementKey.equals(other$agreementKey)) {
                    return false;
                }

                Object this$riskLevel = this.getRiskLevel();
                Object other$riskLevel = other.getRiskLevel();
                if (this$riskLevel == null) {
                    if (other$riskLevel != null) {
                        return false;
                    }
                } else if (!this$riskLevel.equals(other$riskLevel)) {
                    return false;
                }

                label142:
                {
                    Object this$status1 = this.getStatus1();
                    Object other$status1 = other.getStatus1();
                    if (this$status1 == null) {
                        if (other$status1 == null) {
                            break label142;
                        }
                    } else if (this$status1.equals(other$status1)) {
                        break label142;
                    }

                    return false;
                }

                label135:
                {
                    Object this$stopCause = this.getStopCause();
                    Object other$stopCause = other.getStopCause();
                    if (this$stopCause == null) {
                        if (other$stopCause == null) {
                            break label135;
                        }
                    } else if (this$stopCause.equals(other$stopCause)) {
                        break label135;
                    }

                    return false;
                }

                Object this$cardName = this.getCardName();
                Object other$cardName = other.getCardName();
                if (this$cardName == null) {
                    if (other$cardName != null) {
                        return false;
                    }
                } else if (!this$cardName.equals(other$cardName)) {
                    return false;
                }

                label121:
                {
                    Object this$clRole = this.getClRole();
                    Object other$clRole = other.getClRole();
                    if (this$clRole == null) {
                        if (other$clRole == null) {
                            break label121;
                        }
                    } else if (this$clRole.equals(other$clRole)) {
                        break label121;
                    }

                    return false;
                }

                Object this$bankC = this.getBankC();
                Object other$bankC = other.getBankC();
                if (this$bankC == null) {
                    if (other$bankC != null) {
                        return false;
                    }
                } else if (!this$bankC.equals(other$bankC)) {
                    return false;
                }

                label107:
                {
                    Object this$groupC = this.getGroupC();
                    Object other$groupC = other.getGroupC();
                    if (this$groupC == null) {
                        if (other$groupC == null) {
                            break label107;
                        }
                    } else if (this$groupC.equals(other$groupC)) {
                        break label107;
                    }

                    return false;
                }

                Object this$client = this.getClient();
                Object other$client = other.getClient();
                if (this$client == null) {
                    if (other$client != null) {
                        return false;
                    }
                } else if (!this$client.equals(other$client)) {
                    return false;
                }

                Object this$clientB = this.getClientB();
                Object other$clientB = other.getClientB();
                if (this$clientB == null) {
                    if (other$clientB != null) {
                        return false;
                    }
                } else if (!this$clientB.equals(other$clientB)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ListCustomerCard;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        Object $cardType = this.getCardType();
        result = result * 59 + ($cardType == null ? 43 : $cardType.hashCode());
        Object $expiry = this.getExpiry();
        result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
        Object $baseSupp = this.getBaseSupp();
        result = result * 59 + ($baseSupp == null ? 43 : $baseSupp.hashCode());
        Object $condSet = this.getCondSet();
        result = result * 59 + ($condSet == null ? 43 : $condSet.hashCode());
        Object $agreementKey = this.getAgreementKey();
        result = result * 59 + ($agreementKey == null ? 43 : $agreementKey.hashCode());
        Object $riskLevel = this.getRiskLevel();
        result = result * 59 + ($riskLevel == null ? 43 : $riskLevel.hashCode());
        Object $status1 = this.getStatus1();
        result = result * 59 + ($status1 == null ? 43 : $status1.hashCode());
        Object $stopCause = this.getStopCause();
        result = result * 59 + ($stopCause == null ? 43 : $stopCause.hashCode());
        Object $cardName = this.getCardName();
        result = result * 59 + ($cardName == null ? 43 : $cardName.hashCode());
        Object $clRole = this.getClRole();
        result = result * 59 + ($clRole == null ? 43 : $clRole.hashCode());
        Object $bankC = this.getBankC();
        result = result * 59 + ($bankC == null ? 43 : $bankC.hashCode());
        Object $groupC = this.getGroupC();
        result = result * 59 + ($groupC == null ? 43 : $groupC.hashCode());
        Object $client = this.getClient();
        result = result * 59 + ($client == null ? 43 : $client.hashCode());
        Object $clientB = this.getClientB();
        result = result * 59 + ($clientB == null ? 43 : $clientB.hashCode());
        return result;
    }

    public ListCustomerCard(final String card, final String cardType, final String expiry, final String baseSupp, final String condSet, final String agreementKey, final String riskLevel, final String status1, final String stopCause, final String cardName, final String clRole, final String bankC, final String groupC, final String client, final String clientB) {
        this.card = card;
        this.cardType = cardType;
        this.expiry = expiry;
        this.baseSupp = baseSupp;
        this.condSet = condSet;
        this.agreementKey = agreementKey;
        this.riskLevel = riskLevel;
        this.status1 = status1;
        this.stopCause = stopCause;
        this.cardName = cardName;
        this.clRole = clRole;
        this.bankC = bankC;
        this.groupC = groupC;
        this.client = client;
        this.clientB = clientB;
    }

    public ListCustomerCard() {
    }

    public String toString() {
        return "ListCustomerCard(card=" + this.getCard() + ", cardType=" + this.getCardType() + ", expiry=" + this.getExpiry() + ", baseSupp=" + this.getBaseSupp() + ", condSet=" + this.getCondSet() + ", agreementKey=" + this.getAgreementKey() + ", riskLevel=" + this.getRiskLevel() + ", status1=" + this.getStatus1() + ", stopCause=" + this.getStopCause() + ", cardName=" + this.getCardName() + ", clRole=" + this.getClRole() + ", bankC=" + this.getBankC() + ", groupC=" + this.getGroupC() + ", client=" + this.getClient() + ", clientB=" + this.getClientB() + ")";
    }
}
