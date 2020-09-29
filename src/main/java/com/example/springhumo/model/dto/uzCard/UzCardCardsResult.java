package com.example.springhumo.model.dto.uzCard;

import com.example.springhumo.model.entity.Card;

public class UzCardCardsResult {
    private String id;
    private String username;
    private String pan;
    private String expiry;
    private Integer status;
    private String phone;
    private String fullName;
    private Long balance;
    private Integer sms;
    private Integer pincnt;
    private String aacct;

    public UzCardCardsResult(Card card) {
        this.id = card.getToken();
        this.balance = card.getBalance();
        this.expiry = card.getExpDate();
        this.fullName = card.getHolder();
        this.pan = card.getPan();
        this.phone = card.getPhone();
        this.sms = card.getSms() ? 1 : 0;
        this.status = card.getStatus();
        this.pincnt = 0;
        this.aacct = "";
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPan() {
        return this.pan;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Long getBalance() {
        return this.balance;
    }

    public Integer getSms() {
        return this.sms;
    }

    public Integer getPincnt() {
        return this.pincnt;
    }

    public String getAacct() {
        return this.aacct;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPan(final String pan) {
        this.pan = pan;
    }

    public void setExpiry(final String expiry) {
        this.expiry = expiry;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public void setBalance(final Long balance) {
        this.balance = balance;
    }

    public void setSms(final Integer sms) {
        this.sms = sms;
    }

    public void setPincnt(final Integer pincnt) {
        this.pincnt = pincnt;
    }

    public void setAacct(final String aacct) {
        this.aacct = aacct;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UzCardCardsResult)) {
            return false;
        } else {
            UzCardCardsResult other = (UzCardCardsResult) o;
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

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
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

                label122:
                {
                    Object this$expiry = this.getExpiry();
                    Object other$expiry = other.getExpiry();
                    if (this$expiry == null) {
                        if (other$expiry == null) {
                            break label122;
                        }
                    } else if (this$expiry.equals(other$expiry)) {
                        break label122;
                    }

                    return false;
                }

                label115:
                {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label115;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label115;
                    }

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

                Object this$fullName = this.getFullName();
                Object other$fullName = other.getFullName();
                if (this$fullName == null) {
                    if (other$fullName != null) {
                        return false;
                    }
                } else if (!this$fullName.equals(other$fullName)) {
                    return false;
                }

                label94:
                {
                    Object this$balance = this.getBalance();
                    Object other$balance = other.getBalance();
                    if (this$balance == null) {
                        if (other$balance == null) {
                            break label94;
                        }
                    } else if (this$balance.equals(other$balance)) {
                        break label94;
                    }

                    return false;
                }

                label87:
                {
                    Object this$sms = this.getSms();
                    Object other$sms = other.getSms();
                    if (this$sms == null) {
                        if (other$sms == null) {
                            break label87;
                        }
                    } else if (this$sms.equals(other$sms)) {
                        break label87;
                    }

                    return false;
                }

                Object this$pincnt = this.getPincnt();
                Object other$pincnt = other.getPincnt();
                if (this$pincnt == null) {
                    if (other$pincnt != null) {
                        return false;
                    }
                } else if (!this$pincnt.equals(other$pincnt)) {
                    return false;
                }

                Object this$aacct = this.getAacct();
                Object other$aacct = other.getAacct();
                if (this$aacct == null) {
                    if (other$aacct != null) {
                        return false;
                    }
                } else if (!this$aacct.equals(other$aacct)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UzCardCardsResult;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $pan = this.getPan();
        result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
        Object $expiry = this.getExpiry();
        result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $fullName = this.getFullName();
        result = result * 59 + ($fullName == null ? 43 : $fullName.hashCode());
        Object $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : $balance.hashCode());
        Object $sms = this.getSms();
        result = result * 59 + ($sms == null ? 43 : $sms.hashCode());
        Object $pincnt = this.getPincnt();
        result = result * 59 + ($pincnt == null ? 43 : $pincnt.hashCode());
        Object $aacct = this.getAacct();
        result = result * 59 + ($aacct == null ? 43 : $aacct.hashCode());
        return result;
    }

    public String toString() {
        return "UzCardCardsResult(id=" + this.getId() + ", username=" + this.getUsername() + ", pan=" + this.getPan() + ", expiry=" + this.getExpiry() + ", status=" + this.getStatus() + ", phone=" + this.getPhone() + ", fullName=" + this.getFullName() + ", balance=" + this.getBalance() + ", sms=" + this.getSms() + ", pincnt=" + this.getPincnt() + ", aacct=" + this.getAacct() + ")";
    }
}

