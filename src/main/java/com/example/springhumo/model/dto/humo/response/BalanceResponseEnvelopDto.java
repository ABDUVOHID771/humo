package com.example.springhumo.model.dto.humo.response;

import com.example.springhumo.constant.HumoError;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Optional;

@JacksonXmlRootElement(
        localName = "envelop"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BalanceResponseEnvelopDto {
    @JacksonXmlProperty(
            localName = "listSize"
    )
    private Integer listSize;
    @JacksonXmlProperty(
            localName = "card",
            isAttribute = true
    )
    private BalanceResponseEnvelopDto.Card card;
    @JacksonXmlProperty(
            localName = "account",
            isAttribute = true
    )
    private BalanceResponseEnvelopDto.Account account;
    @JacksonXmlProperty(
            localName = "balance",
            isAttribute = true
    )
    private BalanceResponseEnvelopDto.Balance balance;

    @JsonIgnore
    public HumoError getCardStatusError() {
        if (this.card != null) {
            BalanceResponseEnvelopDto.Card card = this.card;
            List<BalanceResponseEnvelopDto.Card.StatusItems> items = card.getItems();
            if (items != null) {
                Optional<BalanceResponseEnvelopDto.Card.StatusItems> statusItem = items.stream().filter((i) -> {
                    return i.getType().equalsIgnoreCase("card");
                }).findFirst();
                if (statusItem.isPresent()) {
                    HumoError result = HumoError.findById(Integer.parseInt(((BalanceResponseEnvelopDto.Card.StatusItems) statusItem.get()).getActionCode()));
                    return result;
                }
            }
        }

        return HumoError.error_100;
    }

    public BalanceResponseEnvelopDto() {
    }

    public Integer getListSize() {
        return this.listSize;
    }

    public BalanceResponseEnvelopDto.Card getCard() {
        return this.card;
    }

    public BalanceResponseEnvelopDto.Account getAccount() {
        return this.account;
    }

    public BalanceResponseEnvelopDto.Balance getBalance() {
        return this.balance;
    }

    public void setListSize(final Integer listSize) {
        this.listSize = listSize;
    }

    public void setCard(final BalanceResponseEnvelopDto.Card card) {
        this.card = card;
    }

    public void setAccount(final BalanceResponseEnvelopDto.Account account) {
        this.account = account;
    }

    public void setBalance(final BalanceResponseEnvelopDto.Balance balance) {
        this.balance = balance;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BalanceResponseEnvelopDto)) {
            return false;
        } else {
            BalanceResponseEnvelopDto other = (BalanceResponseEnvelopDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$listSize = this.getListSize();
                    Object other$listSize = other.getListSize();
                    if (this$listSize == null) {
                        if (other$listSize == null) {
                            break label59;
                        }
                    } else if (this$listSize.equals(other$listSize)) {
                        break label59;
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

                Object this$account = this.getAccount();
                Object other$account = other.getAccount();
                if (this$account == null) {
                    if (other$account != null) {
                        return false;
                    }
                } else if (!this$account.equals(other$account)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BalanceResponseEnvelopDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $listSize = this.getListSize();
         result = result * 59 + ($listSize == null ? 43 : $listSize.hashCode());
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        Object $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        Object $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : $balance.hashCode());
        return result;
    }

    public String toString() {
        return "BalanceResponseEnvelopDto(listSize=" + this.getListSize() + ", card=" + this.getCard() + ", account=" + this.getAccount() + ", balance=" + this.getBalance() + ")";
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Balance {
        private Long currency;
        private Long initialAmount;
        private Long bonusAmount;
        private Long creditLimit;
        private Long lockedBackofficeAmount;
        private Long lockedBackofficeAmountOffline;
        private Long lockedAmount;
        private Long availableAmount;

        public Balance() {
        }

        public Long getCurrency() {
            return this.currency;
        }

        public Long getInitialAmount() {
            return this.initialAmount;
        }

        public Long getBonusAmount() {
            return this.bonusAmount;
        }

        public Long getCreditLimit() {
            return this.creditLimit;
        }

        public Long getLockedBackofficeAmount() {
            return this.lockedBackofficeAmount;
        }

        public Long getLockedBackofficeAmountOffline() {
            return this.lockedBackofficeAmountOffline;
        }

        public Long getLockedAmount() {
            return this.lockedAmount;
        }

        public Long getAvailableAmount() {
            return this.availableAmount;
        }

        public void setCurrency(final Long currency) {
            this.currency = currency;
        }

        public void setInitialAmount(final Long initialAmount) {
            this.initialAmount = initialAmount;
        }

        public void setBonusAmount(final Long bonusAmount) {
            this.bonusAmount = bonusAmount;
        }

        public void setCreditLimit(final Long creditLimit) {
            this.creditLimit = creditLimit;
        }

        public void setLockedBackofficeAmount(final Long lockedBackofficeAmount) {
            this.lockedBackofficeAmount = lockedBackofficeAmount;
        }

        public void setLockedBackofficeAmountOffline(final Long lockedBackofficeAmountOffline) {
            this.lockedBackofficeAmountOffline = lockedBackofficeAmountOffline;
        }

        public void setLockedAmount(final Long lockedAmount) {
            this.lockedAmount = lockedAmount;
        }

        public void setAvailableAmount(final Long availableAmount) {
            this.availableAmount = availableAmount;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof BalanceResponseEnvelopDto.Balance)) {
                return false;
            } else {
                BalanceResponseEnvelopDto.Balance other = (BalanceResponseEnvelopDto.Balance) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label107:
                    {
                        Object this$currency = this.getCurrency();
                        Object other$currency = other.getCurrency();
                        if (this$currency == null) {
                            if (other$currency == null) {
                                break label107;
                            }
                        } else if (this$currency.equals(other$currency)) {
                            break label107;
                        }

                        return false;
                    }

                    Object this$initialAmount = this.getInitialAmount();
                    Object other$initialAmount = other.getInitialAmount();
                    if (this$initialAmount == null) {
                        if (other$initialAmount != null) {
                            return false;
                        }
                    } else if (!this$initialAmount.equals(other$initialAmount)) {
                        return false;
                    }

                    Object this$bonusAmount = this.getBonusAmount();
                    Object other$bonusAmount = other.getBonusAmount();
                    if (this$bonusAmount == null) {
                        if (other$bonusAmount != null) {
                            return false;
                        }
                    } else if (!this$bonusAmount.equals(other$bonusAmount)) {
                        return false;
                    }

                    label86:
                    {
                        Object this$creditLimit = this.getCreditLimit();
                        Object other$creditLimit = other.getCreditLimit();
                        if (this$creditLimit == null) {
                            if (other$creditLimit == null) {
                                break label86;
                            }
                        } else if (this$creditLimit.equals(other$creditLimit)) {
                            break label86;
                        }

                        return false;
                    }

                    label79:
                    {
                        Object this$lockedBackofficeAmount = this.getLockedBackofficeAmount();
                        Object other$lockedBackofficeAmount = other.getLockedBackofficeAmount();
                        if (this$lockedBackofficeAmount == null) {
                            if (other$lockedBackofficeAmount == null) {
                                break label79;
                            }
                        } else if (this$lockedBackofficeAmount.equals(other$lockedBackofficeAmount)) {
                            break label79;
                        }

                        return false;
                    }

                    label72:
                    {
                        Object this$lockedBackofficeAmountOffline = this.getLockedBackofficeAmountOffline();
                        Object other$lockedBackofficeAmountOffline = other.getLockedBackofficeAmountOffline();
                        if (this$lockedBackofficeAmountOffline == null) {
                            if (other$lockedBackofficeAmountOffline == null) {
                                break label72;
                            }
                        } else if (this$lockedBackofficeAmountOffline.equals(other$lockedBackofficeAmountOffline)) {
                            break label72;
                        }

                        return false;
                    }

                    Object this$lockedAmount = this.getLockedAmount();
                    Object other$lockedAmount = other.getLockedAmount();
                    if (this$lockedAmount == null) {
                        if (other$lockedAmount != null) {
                            return false;
                        }
                    } else if (!this$lockedAmount.equals(other$lockedAmount)) {
                        return false;
                    }

                    Object this$availableAmount = this.getAvailableAmount();
                    Object other$availableAmount = other.getAvailableAmount();
                    if (this$availableAmount == null) {
                        if (other$availableAmount != null) {
                            return false;
                        }
                    } else if (!this$availableAmount.equals(other$availableAmount)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof BalanceResponseEnvelopDto.Balance;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $currency = this.getCurrency();
            result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
            Object $initialAmount = this.getInitialAmount();
            result = result * 59 + ($initialAmount == null ? 43 : $initialAmount.hashCode());
            Object $bonusAmount = this.getBonusAmount();
            result = result * 59 + ($bonusAmount == null ? 43 : $bonusAmount.hashCode());
            Object $creditLimit = this.getCreditLimit();
            result = result * 59 + ($creditLimit == null ? 43 : $creditLimit.hashCode());
            Object $lockedBackofficeAmount = this.getLockedBackofficeAmount();
            result = result * 59 + ($lockedBackofficeAmount == null ? 43 : $lockedBackofficeAmount.hashCode());
            Object $lockedBackofficeAmountOffline = this.getLockedBackofficeAmountOffline();
            result = result * 59 + ($lockedBackofficeAmountOffline == null ? 43 : $lockedBackofficeAmountOffline.hashCode());
            Object $lockedAmount = this.getLockedAmount();
            result = result * 59 + ($lockedAmount == null ? 43 : $lockedAmount.hashCode());
            Object $availableAmount = this.getAvailableAmount();
            result = result * 59 + ($availableAmount == null ? 43 : $availableAmount.hashCode());
            return result;
        }

        public String toString() {
            return "BalanceResponseEnvelopDto.Balance(currency=" + this.getCurrency() + ", initialAmount=" + this.getInitialAmount() + ", bonusAmount=" + this.getBonusAmount() + ", creditLimit=" + this.getCreditLimit() + ", lockedBackofficeAmount=" + this.getLockedBackofficeAmount() + ", lockedBackofficeAmountOffline=" + this.getLockedBackofficeAmountOffline() + ", lockedAmount=" + this.getLockedAmount() + ", availableAmount=" + this.getAvailableAmount() + ")";
        }
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Account {
        private String institutionId;
        private String accountId;
        private String bankAccountId;
        private String currency;
        private String cardholderId;
        private String effectiveDate;
        private String updateDate;
        private String accountType;
        private String initialAmount;
        private String lockedBackofficeAmount;
        private String lockTime;
        private String lockedAmount;
        private String shadowAmount;
        private String commissionGroup;
        private String priority;
        private String status;
        private String availableAmount;

        public Account() {
        }

        public String getInstitutionId() {
            return this.institutionId;
        }

        public String getAccountId() {
            return this.accountId;
        }

        public String getBankAccountId() {
            return this.bankAccountId;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getCardholderId() {
            return this.cardholderId;
        }

        public String getEffectiveDate() {
            return this.effectiveDate;
        }

        public String getUpdateDate() {
            return this.updateDate;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public String getInitialAmount() {
            return this.initialAmount;
        }

        public String getLockedBackofficeAmount() {
            return this.lockedBackofficeAmount;
        }

        public String getLockTime() {
            return this.lockTime;
        }

        public String getLockedAmount() {
            return this.lockedAmount;
        }

        public String getShadowAmount() {
            return this.shadowAmount;
        }

        public String getCommissionGroup() {
            return this.commissionGroup;
        }

        public String getPriority() {
            return this.priority;
        }

        public String getStatus() {
            return this.status;
        }

        public String getAvailableAmount() {
            return this.availableAmount;
        }

        public void setInstitutionId(final String institutionId) {
            this.institutionId = institutionId;
        }

        public void setAccountId(final String accountId) {
            this.accountId = accountId;
        }

        public void setBankAccountId(final String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        public void setCurrency(final String currency) {
            this.currency = currency;
        }

        public void setCardholderId(final String cardholderId) {
            this.cardholderId = cardholderId;
        }

        public void setEffectiveDate(final String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public void setUpdateDate(final String updateDate) {
            this.updateDate = updateDate;
        }

        public void setAccountType(final String accountType) {
            this.accountType = accountType;
        }

        public void setInitialAmount(final String initialAmount) {
            this.initialAmount = initialAmount;
        }

        public void setLockedBackofficeAmount(final String lockedBackofficeAmount) {
            this.lockedBackofficeAmount = lockedBackofficeAmount;
        }

        public void setLockTime(final String lockTime) {
            this.lockTime = lockTime;
        }

        public void setLockedAmount(final String lockedAmount) {
            this.lockedAmount = lockedAmount;
        }

        public void setShadowAmount(final String shadowAmount) {
            this.shadowAmount = shadowAmount;
        }

        public void setCommissionGroup(final String commissionGroup) {
            this.commissionGroup = commissionGroup;
        }

        public void setPriority(final String priority) {
            this.priority = priority;
        }

        public void setStatus(final String status) {
            this.status = status;
        }

        public void setAvailableAmount(final String availableAmount) {
            this.availableAmount = availableAmount;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof BalanceResponseEnvelopDto.Account)) {
                return false;
            } else {
                BalanceResponseEnvelopDto.Account other = (BalanceResponseEnvelopDto.Account) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label215:
                    {
                        Object this$institutionId = this.getInstitutionId();
                        Object other$institutionId = other.getInstitutionId();
                        if (this$institutionId == null) {
                            if (other$institutionId == null) {
                                break label215;
                            }
                        } else if (this$institutionId.equals(other$institutionId)) {
                            break label215;
                        }

                        return false;
                    }

                    Object this$accountId = this.getAccountId();
                    Object other$accountId = other.getAccountId();
                    if (this$accountId == null) {
                        if (other$accountId != null) {
                            return false;
                        }
                    } else if (!this$accountId.equals(other$accountId)) {
                        return false;
                    }

                    label201:
                    {
                        Object this$bankAccountId = this.getBankAccountId();
                        Object other$bankAccountId = other.getBankAccountId();
                        if (this$bankAccountId == null) {
                            if (other$bankAccountId == null) {
                                break label201;
                            }
                        } else if (this$bankAccountId.equals(other$bankAccountId)) {
                            break label201;
                        }

                        return false;
                    }

                    Object this$currency = this.getCurrency();
                    Object other$currency = other.getCurrency();
                    if (this$currency == null) {
                        if (other$currency != null) {
                            return false;
                        }
                    } else if (!this$currency.equals(other$currency)) {
                        return false;
                    }

                    label187:
                    {
                        Object this$cardholderId = this.getCardholderId();
                        Object other$cardholderId = other.getCardholderId();
                        if (this$cardholderId == null) {
                            if (other$cardholderId == null) {
                                break label187;
                            }
                        } else if (this$cardholderId.equals(other$cardholderId)) {
                            break label187;
                        }

                        return false;
                    }

                    Object this$effectiveDate = this.getEffectiveDate();
                    Object other$effectiveDate = other.getEffectiveDate();
                    if (this$effectiveDate == null) {
                        if (other$effectiveDate != null) {
                            return false;
                        }
                    } else if (!this$effectiveDate.equals(other$effectiveDate)) {
                        return false;
                    }

                    label173:
                    {
                        Object this$updateDate = this.getUpdateDate();
                        Object other$updateDate = other.getUpdateDate();
                        if (this$updateDate == null) {
                            if (other$updateDate == null) {
                                break label173;
                            }
                        } else if (this$updateDate.equals(other$updateDate)) {
                            break label173;
                        }

                        return false;
                    }

                    label166:
                    {
                        Object this$accountType = this.getAccountType();
                        Object other$accountType = other.getAccountType();
                        if (this$accountType == null) {
                            if (other$accountType == null) {
                                break label166;
                            }
                        } else if (this$accountType.equals(other$accountType)) {
                            break label166;
                        }

                        return false;
                    }

                    Object this$initialAmount = this.getInitialAmount();
                    Object other$initialAmount = other.getInitialAmount();
                    if (this$initialAmount == null) {
                        if (other$initialAmount != null) {
                            return false;
                        }
                    } else if (!this$initialAmount.equals(other$initialAmount)) {
                        return false;
                    }

                    label152:
                    {
                        Object this$lockedBackofficeAmount = this.getLockedBackofficeAmount();
                        Object other$lockedBackofficeAmount = other.getLockedBackofficeAmount();
                        if (this$lockedBackofficeAmount == null) {
                            if (other$lockedBackofficeAmount == null) {
                                break label152;
                            }
                        } else if (this$lockedBackofficeAmount.equals(other$lockedBackofficeAmount)) {
                            break label152;
                        }

                        return false;
                    }

                    label145:
                    {
                        Object this$lockTime = this.getLockTime();
                        Object other$lockTime = other.getLockTime();
                        if (this$lockTime == null) {
                            if (other$lockTime == null) {
                                break label145;
                            }
                        } else if (this$lockTime.equals(other$lockTime)) {
                            break label145;
                        }

                        return false;
                    }

                    Object this$lockedAmount = this.getLockedAmount();
                    Object other$lockedAmount = other.getLockedAmount();
                    if (this$lockedAmount == null) {
                        if (other$lockedAmount != null) {
                            return false;
                        }
                    } else if (!this$lockedAmount.equals(other$lockedAmount)) {
                        return false;
                    }

                    Object this$shadowAmount = this.getShadowAmount();
                    Object other$shadowAmount = other.getShadowAmount();
                    if (this$shadowAmount == null) {
                        if (other$shadowAmount != null) {
                            return false;
                        }
                    } else if (!this$shadowAmount.equals(other$shadowAmount)) {
                        return false;
                    }

                    label124:
                    {
                        Object this$commissionGroup = this.getCommissionGroup();
                        Object other$commissionGroup = other.getCommissionGroup();
                        if (this$commissionGroup == null) {
                            if (other$commissionGroup == null) {
                                break label124;
                            }
                        } else if (this$commissionGroup.equals(other$commissionGroup)) {
                            break label124;
                        }

                        return false;
                    }

                    Object this$priority = this.getPriority();
                    Object other$priority = other.getPriority();
                    if (this$priority == null) {
                        if (other$priority != null) {
                            return false;
                        }
                    } else if (!this$priority.equals(other$priority)) {
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

                    Object this$availableAmount = this.getAvailableAmount();
                    Object other$availableAmount = other.getAvailableAmount();
                    if (this$availableAmount == null) {
                        if (other$availableAmount != null) {
                            return false;
                        }
                    } else if (!this$availableAmount.equals(other$availableAmount)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof BalanceResponseEnvelopDto.Account;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $institutionId = this.getInstitutionId();
             result = result * 59 + ($institutionId == null ? 43 : $institutionId.hashCode());
            Object $accountId = this.getAccountId();
            result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
            Object $bankAccountId = this.getBankAccountId();
            result = result * 59 + ($bankAccountId == null ? 43 : $bankAccountId.hashCode());
            Object $currency = this.getCurrency();
            result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
            Object $cardholderId = this.getCardholderId();
            result = result * 59 + ($cardholderId == null ? 43 : $cardholderId.hashCode());
            Object $effectiveDate = this.getEffectiveDate();
            result = result * 59 + ($effectiveDate == null ? 43 : $effectiveDate.hashCode());
            Object $updateDate = this.getUpdateDate();
            result = result * 59 + ($updateDate == null ? 43 : $updateDate.hashCode());
            Object $accountType = this.getAccountType();
            result = result * 59 + ($accountType == null ? 43 : $accountType.hashCode());
            Object $initialAmount = this.getInitialAmount();
            result = result * 59 + ($initialAmount == null ? 43 : $initialAmount.hashCode());
            Object $lockedBackofficeAmount = this.getLockedBackofficeAmount();
            result = result * 59 + ($lockedBackofficeAmount == null ? 43 : $lockedBackofficeAmount.hashCode());
            Object $lockTime = this.getLockTime();
            result = result * 59 + ($lockTime == null ? 43 : $lockTime.hashCode());
            Object $lockedAmount = this.getLockedAmount();
            result = result * 59 + ($lockedAmount == null ? 43 : $lockedAmount.hashCode());
            Object $shadowAmount = this.getShadowAmount();
            result = result * 59 + ($shadowAmount == null ? 43 : $shadowAmount.hashCode());
            Object $commissionGroup = this.getCommissionGroup();
            result = result * 59 + ($commissionGroup == null ? 43 : $commissionGroup.hashCode());
            Object $priority = this.getPriority();
            result = result * 59 + ($priority == null ? 43 : $priority.hashCode());
            Object $status = this.getStatus();
            result = result * 59 + ($status == null ? 43 : $status.hashCode());
            Object $availableAmount = this.getAvailableAmount();
            result = result * 59 + ($availableAmount == null ? 43 : $availableAmount.hashCode());
            return result;
        }

        public String toString() {
            return "BalanceResponseEnvelopDto.Account(institutionId=" + this.getInstitutionId() + ", accountId=" + this.getAccountId() + ", bankAccountId=" + this.getBankAccountId() + ", currency=" + this.getCurrency() + ", cardholderId=" + this.getCardholderId() + ", effectiveDate=" + this.getEffectiveDate() + ", updateDate=" + this.getUpdateDate() + ", accountType=" + this.getAccountType() + ", initialAmount=" + this.getInitialAmount() + ", lockedBackofficeAmount=" + this.getLockedBackofficeAmount() + ", lockTime=" + this.getLockTime() + ", lockedAmount=" + this.getLockedAmount() + ", shadowAmount=" + this.getShadowAmount() + ", commissionGroup=" + this.getCommissionGroup() + ", priority=" + this.getPriority() + ", status=" + this.getStatus() + ", availableAmount=" + this.getAvailableAmount() + ")";
        }
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Card {
        private String institutionId;
        private String primaryAccountNumber;
        private String effectiveDate;
        private String updateDate;
        private String prefixNumber;
        private String expiry;
        private String cardSequenceNumber;
        private String cardholderId;
        private String nameOnCard;
        private String accountRestrictionsFlag;
        private String cardUserId;
        private String additionalInfo;
        private String riskGroup;
        private String riskGroup2;
        @JacksonXmlProperty(
                localName = "statuses",
                isAttribute = true
        )
        private List<BalanceResponseEnvelopDto.Card.StatusItems> items;

        public Card() {
        }

        public String getInstitutionId() {
            return this.institutionId;
        }

        public String getPrimaryAccountNumber() {
            return this.primaryAccountNumber;
        }

        public String getEffectiveDate() {
            return this.effectiveDate;
        }

        public String getUpdateDate() {
            return this.updateDate;
        }

        public String getPrefixNumber() {
            return this.prefixNumber;
        }

        public String getExpiry() {
            return this.expiry;
        }

        public String getCardSequenceNumber() {
            return this.cardSequenceNumber;
        }

        public String getCardholderId() {
            return this.cardholderId;
        }

        public String getNameOnCard() {
            return this.nameOnCard;
        }

        public String getAccountRestrictionsFlag() {
            return this.accountRestrictionsFlag;
        }

        public String getCardUserId() {
            return this.cardUserId;
        }

        public String getAdditionalInfo() {
            return this.additionalInfo;
        }

        public String getRiskGroup() {
            return this.riskGroup;
        }

        public String getRiskGroup2() {
            return this.riskGroup2;
        }

        public List<BalanceResponseEnvelopDto.Card.StatusItems> getItems() {
            return this.items;
        }

        public void setInstitutionId(final String institutionId) {
            this.institutionId = institutionId;
        }

        public void setPrimaryAccountNumber(final String primaryAccountNumber) {
            this.primaryAccountNumber = primaryAccountNumber;
        }

        public void setEffectiveDate(final String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public void setUpdateDate(final String updateDate) {
            this.updateDate = updateDate;
        }

        public void setPrefixNumber(final String prefixNumber) {
            this.prefixNumber = prefixNumber;
        }

        public void setExpiry(final String expiry) {
            this.expiry = expiry;
        }

        public void setCardSequenceNumber(final String cardSequenceNumber) {
            this.cardSequenceNumber = cardSequenceNumber;
        }

        public void setCardholderId(final String cardholderId) {
            this.cardholderId = cardholderId;
        }

        public void setNameOnCard(final String nameOnCard) {
            this.nameOnCard = nameOnCard;
        }

        public void setAccountRestrictionsFlag(final String accountRestrictionsFlag) {
            this.accountRestrictionsFlag = accountRestrictionsFlag;
        }

        public void setCardUserId(final String cardUserId) {
            this.cardUserId = cardUserId;
        }

        public void setAdditionalInfo(final String additionalInfo) {
            this.additionalInfo = additionalInfo;
        }

        public void setRiskGroup(final String riskGroup) {
            this.riskGroup = riskGroup;
        }

        public void setRiskGroup2(final String riskGroup2) {
            this.riskGroup2 = riskGroup2;
        }

        public void setItems(final List<BalanceResponseEnvelopDto.Card.StatusItems> items) {
            this.items = items;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof BalanceResponseEnvelopDto.Card)) {
                return false;
            } else {
                BalanceResponseEnvelopDto.Card other = (BalanceResponseEnvelopDto.Card) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label191:
                    {
                        Object this$institutionId = this.getInstitutionId();
                        Object other$institutionId = other.getInstitutionId();
                        if (this$institutionId == null) {
                            if (other$institutionId == null) {
                                break label191;
                            }
                        } else if (this$institutionId.equals(other$institutionId)) {
                            break label191;
                        }

                        return false;
                    }

                    Object this$primaryAccountNumber = this.getPrimaryAccountNumber();
                    Object other$primaryAccountNumber = other.getPrimaryAccountNumber();
                    if (this$primaryAccountNumber == null) {
                        if (other$primaryAccountNumber != null) {
                            return false;
                        }
                    } else if (!this$primaryAccountNumber.equals(other$primaryAccountNumber)) {
                        return false;
                    }

                    Object this$effectiveDate = this.getEffectiveDate();
                    Object other$effectiveDate = other.getEffectiveDate();
                    if (this$effectiveDate == null) {
                        if (other$effectiveDate != null) {
                            return false;
                        }
                    } else if (!this$effectiveDate.equals(other$effectiveDate)) {
                        return false;
                    }

                    label170:
                    {
                        Object this$updateDate = this.getUpdateDate();
                        Object other$updateDate = other.getUpdateDate();
                        if (this$updateDate == null) {
                            if (other$updateDate == null) {
                                break label170;
                            }
                        } else if (this$updateDate.equals(other$updateDate)) {
                            break label170;
                        }

                        return false;
                    }

                    label163:
                    {
                        Object this$prefixNumber = this.getPrefixNumber();
                        Object other$prefixNumber = other.getPrefixNumber();
                        if (this$prefixNumber == null) {
                            if (other$prefixNumber == null) {
                                break label163;
                            }
                        } else if (this$prefixNumber.equals(other$prefixNumber)) {
                            break label163;
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

                    Object this$cardSequenceNumber = this.getCardSequenceNumber();
                    Object other$cardSequenceNumber = other.getCardSequenceNumber();
                    if (this$cardSequenceNumber == null) {
                        if (other$cardSequenceNumber != null) {
                            return false;
                        }
                    } else if (!this$cardSequenceNumber.equals(other$cardSequenceNumber)) {
                        return false;
                    }

                    label142:
                    {
                        Object this$cardholderId = this.getCardholderId();
                        Object other$cardholderId = other.getCardholderId();
                        if (this$cardholderId == null) {
                            if (other$cardholderId == null) {
                                break label142;
                            }
                        } else if (this$cardholderId.equals(other$cardholderId)) {
                            break label142;
                        }

                        return false;
                    }

                    label135:
                    {
                        Object this$nameOnCard = this.getNameOnCard();
                        Object other$nameOnCard = other.getNameOnCard();
                        if (this$nameOnCard == null) {
                            if (other$nameOnCard == null) {
                                break label135;
                            }
                        } else if (this$nameOnCard.equals(other$nameOnCard)) {
                            break label135;
                        }

                        return false;
                    }

                    Object this$accountRestrictionsFlag = this.getAccountRestrictionsFlag();
                    Object other$accountRestrictionsFlag = other.getAccountRestrictionsFlag();
                    if (this$accountRestrictionsFlag == null) {
                        if (other$accountRestrictionsFlag != null) {
                            return false;
                        }
                    } else if (!this$accountRestrictionsFlag.equals(other$accountRestrictionsFlag)) {
                        return false;
                    }

                    label121:
                    {
                        Object this$cardUserId = this.getCardUserId();
                        Object other$cardUserId = other.getCardUserId();
                        if (this$cardUserId == null) {
                            if (other$cardUserId == null) {
                                break label121;
                            }
                        } else if (this$cardUserId.equals(other$cardUserId)) {
                            break label121;
                        }

                        return false;
                    }

                    Object this$additionalInfo = this.getAdditionalInfo();
                    Object other$additionalInfo = other.getAdditionalInfo();
                    if (this$additionalInfo == null) {
                        if (other$additionalInfo != null) {
                            return false;
                        }
                    } else if (!this$additionalInfo.equals(other$additionalInfo)) {
                        return false;
                    }

                    label107:
                    {
                        Object this$riskGroup = this.getRiskGroup();
                        Object other$riskGroup = other.getRiskGroup();
                        if (this$riskGroup == null) {
                            if (other$riskGroup == null) {
                                break label107;
                            }
                        } else if (this$riskGroup.equals(other$riskGroup)) {
                            break label107;
                        }

                        return false;
                    }

                    Object this$riskGroup2 = this.getRiskGroup2();
                    Object other$riskGroup2 = other.getRiskGroup2();
                    if (this$riskGroup2 == null) {
                        if (other$riskGroup2 != null) {
                            return false;
                        }
                    } else if (!this$riskGroup2.equals(other$riskGroup2)) {
                        return false;
                    }

                    Object this$items = this.getItems();
                    Object other$items = other.getItems();
                    if (this$items == null) {
                        if (other$items != null) {
                            return false;
                        }
                    } else if (!this$items.equals(other$items)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof BalanceResponseEnvelopDto.Card;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $institutionId = this.getInstitutionId();
            result = result * 59 + ($institutionId == null ? 43 : $institutionId.hashCode());
            Object $primaryAccountNumber = this.getPrimaryAccountNumber();
            result = result * 59 + ($primaryAccountNumber == null ? 43 : $primaryAccountNumber.hashCode());
            Object $effectiveDate = this.getEffectiveDate();
            result = result * 59 + ($effectiveDate == null ? 43 : $effectiveDate.hashCode());
            Object $updateDate = this.getUpdateDate();
            result = result * 59 + ($updateDate == null ? 43 : $updateDate.hashCode());
            Object $prefixNumber = this.getPrefixNumber();
            result = result * 59 + ($prefixNumber == null ? 43 : $prefixNumber.hashCode());
            Object $expiry = this.getExpiry();
            result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
            Object $cardSequenceNumber = this.getCardSequenceNumber();
            result = result * 59 + ($cardSequenceNumber == null ? 43 : $cardSequenceNumber.hashCode());
            Object $cardholderId = this.getCardholderId();
            result = result * 59 + ($cardholderId == null ? 43 : $cardholderId.hashCode());
            Object $nameOnCard = this.getNameOnCard();
            result = result * 59 + ($nameOnCard == null ? 43 : $nameOnCard.hashCode());
            Object $accountRestrictionsFlag = this.getAccountRestrictionsFlag();
            result = result * 59 + ($accountRestrictionsFlag == null ? 43 : $accountRestrictionsFlag.hashCode());
            Object $cardUserId = this.getCardUserId();
            result = result * 59 + ($cardUserId == null ? 43 : $cardUserId.hashCode());
            Object $additionalInfo = this.getAdditionalInfo();
            result = result * 59 + ($additionalInfo == null ? 43 : $additionalInfo.hashCode());
            Object $riskGroup = this.getRiskGroup();
            result = result * 59 + ($riskGroup == null ? 43 : $riskGroup.hashCode());
            Object $riskGroup2 = this.getRiskGroup2();
            result = result * 59 + ($riskGroup2 == null ? 43 : $riskGroup2.hashCode());
            Object $items = this.getItems();
            result = result * 59 + ($items == null ? 43 : $items.hashCode());
            return result;
        }

        public String toString() {
            return "BalanceResponseEnvelopDto.Card(institutionId=" + this.getInstitutionId() + ", primaryAccountNumber=" + this.getPrimaryAccountNumber() + ", effectiveDate=" + this.getEffectiveDate() + ", updateDate=" + this.getUpdateDate() + ", prefixNumber=" + this.getPrefixNumber() + ", expiry=" + this.getExpiry() + ", cardSequenceNumber=" + this.getCardSequenceNumber() + ", cardholderId=" + this.getCardholderId() + ", nameOnCard=" + this.getNameOnCard() + ", accountRestrictionsFlag=" + this.getAccountRestrictionsFlag() + ", cardUserId=" + this.getCardUserId() + ", additionalInfo=" + this.getAdditionalInfo() + ", riskGroup=" + this.getRiskGroup() + ", riskGroup2=" + this.getRiskGroup2() + ", items=" + this.getItems() + ")";
        }

        @JsonIgnoreProperties(
                ignoreUnknown = true
        )
        public static class StatusItems {
            private String type;
            private String actionCode;
            private String actionDescription;
            private String effectiveDate;

            public StatusItems() {
            }

            public String getType() {
                return this.type;
            }

            public String getActionCode() {
                return this.actionCode;
            }

            public String getActionDescription() {
                return this.actionDescription;
            }

            public String getEffectiveDate() {
                return this.effectiveDate;
            }

            public void setType(final String type) {
                this.type = type;
            }

            public void setActionCode(final String actionCode) {
                this.actionCode = actionCode;
            }

            public void setActionDescription(final String actionDescription) {
                this.actionDescription = actionDescription;
            }

            public void setEffectiveDate(final String effectiveDate) {
                this.effectiveDate = effectiveDate;
            }

            public boolean equals(final Object o) {
                if (o == this) {
                    return true;
                } else if (!(o instanceof BalanceResponseEnvelopDto.Card.StatusItems)) {
                    return false;
                } else {
                    BalanceResponseEnvelopDto.Card.StatusItems other = (BalanceResponseEnvelopDto.Card.StatusItems) o;
                    if (!other.canEqual(this)) {
                        return false;
                    } else {
                        label59:
                        {
                            Object this$type = this.getType();
                            Object other$type = other.getType();
                            if (this$type == null) {
                                if (other$type == null) {
                                    break label59;
                                }
                            } else if (this$type.equals(other$type)) {
                                break label59;
                            }

                            return false;
                        }

                        Object this$actionCode = this.getActionCode();
                        Object other$actionCode = other.getActionCode();
                        if (this$actionCode == null) {
                            if (other$actionCode != null) {
                                return false;
                            }
                        } else if (!this$actionCode.equals(other$actionCode)) {
                            return false;
                        }

                        Object this$actionDescription = this.getActionDescription();
                        Object other$actionDescription = other.getActionDescription();
                        if (this$actionDescription == null) {
                            if (other$actionDescription != null) {
                                return false;
                            }
                        } else if (!this$actionDescription.equals(other$actionDescription)) {
                            return false;
                        }

                        Object this$effectiveDate = this.getEffectiveDate();
                        Object other$effectiveDate = other.getEffectiveDate();
                        if (this$effectiveDate == null) {
                            if (other$effectiveDate != null) {
                                return false;
                            }
                        } else if (!this$effectiveDate.equals(other$effectiveDate)) {
                            return false;
                        }

                        return true;
                    }
                }
            }

            protected boolean canEqual(final Object other) {
                return other instanceof BalanceResponseEnvelopDto.Card.StatusItems;
            }

            public int hashCode() {
                int PRIME = 1;//true
                int result = 1;
                Object $type = this.getType();
                result = result * 59 + ($type == null ? 43 : $type.hashCode());
                Object $actionCode = this.getActionCode();
                result = result * 59 + ($actionCode == null ? 43 : $actionCode.hashCode());
                Object $actionDescription = this.getActionDescription();
                result = result * 59 + ($actionDescription == null ? 43 : $actionDescription.hashCode());
                Object $effectiveDate = this.getEffectiveDate();
                result = result * 59 + ($effectiveDate == null ? 43 : $effectiveDate.hashCode());
                return result;
            }

            public String toString() {
                return "BalanceResponseEnvelopDto.Card.StatusItems(type=" + this.getType() + ", actionCode=" + this.getActionCode() + ", actionDescription=" + this.getActionDescription() + ", effectiveDate=" + this.getEffectiveDate() + ")";
            }
        }
    }
}
