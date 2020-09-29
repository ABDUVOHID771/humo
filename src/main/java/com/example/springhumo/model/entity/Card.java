package com.example.springhumo.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(
        name = "card"
)
public class Card {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            name = "card_id"
    )
    private String token;
    @ManyToOne
    @JoinColumn(
            name = "bank_id"
    )
    private Bank bank;
    @Column(
            name = "card_holder"
    )
    private String holder;
    @Column(
            name = "card_pan"
    )
    private String pan;
    @Column(
            name = "card_expdate"
    )
    private String expDate;
    @Column(
            name = "card_status"
    )
    private Integer status;
    @Column(
            name = "card_phone"
    )
    private String phone;
    @Column(
            name = "card_name"
    )
    private String name;
    @Column(
            name = "card_theme"
    )
    private String theme;
    @Column(
            name = "sms",
            columnDefinition = "TINYINT(1)"
    )
    private Boolean sms;
    @Column(
            name = "enabled",
            columnDefinition = "TINYINT(4)"
    )
    private Integer enabled = 1;
    @Column(
            name = "deleted",
            columnDefinition = "TINYINT(4)"
    )
    private Integer deleted = 0;
    @Column(
            name = "balance",
            columnDefinition = "BIGINT(20)"
    )
    private Long balance;
    @Column(
            name = "enc_pan"
    )
    private String encPan;
    @Column(
            name = "instime"
    )
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(
            name = "updtime"
    )
    private LocalDateTime updatedDate = LocalDateTime.now();
    @JoinColumn(
            name = "humo_client_id"
    )
    @ManyToOne
    private HumoClient humoClient;

    public Card() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public Bank getBank() {
        return this.bank;
    }

    public String getHolder() {
        return this.holder;
    }

    public String getPan() {
        return this.pan;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getName() {
        return this.name;
    }

    public String getTheme() {
        return this.theme;
    }

    public Boolean getSms() {
        return this.sms;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public Integer getDeleted() {
        return this.deleted;
    }

    public Long getBalance() {
        return this.balance;
    }

    public String getEncPan() {
        return this.encPan;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public HumoClient getHumoClient() {
        return this.humoClient;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setBank(final Bank bank) {
        this.bank = bank;
    }

    public void setHolder(final String holder) {
        this.holder = holder;
    }

    public void setPan(final String pan) {
        this.pan = pan;
    }

    public void setExpDate(final String expDate) {
        this.expDate = expDate;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTheme(final String theme) {
        this.theme = theme;
    }

    public void setSms(final Boolean sms) {
        this.sms = sms;
    }

    public void setEnabled(final Integer enabled) {
        this.enabled = enabled;
    }

    public void setDeleted(final Integer deleted) {
        this.deleted = deleted;
    }

    public void setBalance(final Long balance) {
        this.balance = balance;
    }

    public void setEncPan(final String encPan) {
        this.encPan = encPan;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(final LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setHumoClient(final HumoClient humoClient) {
        this.humoClient = humoClient;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Card)) {
            return false;
        } else {
            Card other = (Card)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
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

                label206: {
                    Object this$holder = this.getHolder();
                    Object other$holder = other.getHolder();
                    if (this$holder == null) {
                        if (other$holder == null) {
                            break label206;
                        }
                    } else if (this$holder.equals(other$holder)) {
                        break label206;
                    }

                    return false;
                }

                label199: {
                    Object this$pan = this.getPan();
                    Object other$pan = other.getPan();
                    if (this$pan == null) {
                        if (other$pan == null) {
                            break label199;
                        }
                    } else if (this$pan.equals(other$pan)) {
                        break label199;
                    }

                    return false;
                }

                Object this$expDate = this.getExpDate();
                Object other$expDate = other.getExpDate();
                if (this$expDate == null) {
                    if (other$expDate != null) {
                        return false;
                    }
                } else if (!this$expDate.equals(other$expDate)) {
                    return false;
                }

                label185: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label185;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label185;
                    }

                    return false;
                }

                label178: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label178;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label178;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$theme = this.getTheme();
                Object other$theme = other.getTheme();
                if (this$theme == null) {
                    if (other$theme != null) {
                        return false;
                    }
                } else if (!this$theme.equals(other$theme)) {
                    return false;
                }

                label157: {
                    Object this$sms = this.getSms();
                    Object other$sms = other.getSms();
                    if (this$sms == null) {
                        if (other$sms == null) {
                            break label157;
                        }
                    } else if (this$sms.equals(other$sms)) {
                        break label157;
                    }

                    return false;
                }

                label150: {
                    Object this$enabled = this.getEnabled();
                    Object other$enabled = other.getEnabled();
                    if (this$enabled == null) {
                        if (other$enabled == null) {
                            break label150;
                        }
                    } else if (this$enabled.equals(other$enabled)) {
                        break label150;
                    }

                    return false;
                }

                Object this$deleted = this.getDeleted();
                Object other$deleted = other.getDeleted();
                if (this$deleted == null) {
                    if (other$deleted != null) {
                        return false;
                    }
                } else if (!this$deleted.equals(other$deleted)) {
                    return false;
                }

                label136: {
                    Object this$balance = this.getBalance();
                    Object other$balance = other.getBalance();
                    if (this$balance == null) {
                        if (other$balance == null) {
                            break label136;
                        }
                    } else if (this$balance.equals(other$balance)) {
                        break label136;
                    }

                    return false;
                }

                Object this$encPan = this.getEncPan();
                Object other$encPan = other.getEncPan();
                if (this$encPan == null) {
                    if (other$encPan != null) {
                        return false;
                    }
                } else if (!this$encPan.equals(other$encPan)) {
                    return false;
                }

                label122: {
                    Object this$createdDate = this.getCreatedDate();
                    Object other$createdDate = other.getCreatedDate();
                    if (this$createdDate == null) {
                        if (other$createdDate == null) {
                            break label122;
                        }
                    } else if (this$createdDate.equals(other$createdDate)) {
                        break label122;
                    }

                    return false;
                }

                Object this$updatedDate = this.getUpdatedDate();
                Object other$updatedDate = other.getUpdatedDate();
                if (this$updatedDate == null) {
                    if (other$updatedDate != null) {
                        return false;
                    }
                } else if (!this$updatedDate.equals(other$updatedDate)) {
                    return false;
                }

                Object this$humoClient = this.getHumoClient();
                Object other$humoClient = other.getHumoClient();
                if (this$humoClient == null) {
                    if (other$humoClient != null) {
                        return false;
                    }
                } else if (!this$humoClient.equals(other$humoClient)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Card;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        Object $bank = this.getBank();
        result = result * 59 + ($bank == null ? 43 : $bank.hashCode());
        Object $holder = this.getHolder();
        result = result * 59 + ($holder == null ? 43 : $holder.hashCode());
        Object $pan = this.getPan();
        result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
        Object $expDate = this.getExpDate();
        result = result * 59 + ($expDate == null ? 43 : $expDate.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $theme = this.getTheme();
        result = result * 59 + ($theme == null ? 43 : $theme.hashCode());
        Object $sms = this.getSms();
        result = result * 59 + ($sms == null ? 43 : $sms.hashCode());
        Object $enabled = this.getEnabled();
        result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
        Object $deleted = this.getDeleted();
        result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
        Object $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : $balance.hashCode());
        Object $encPan = this.getEncPan();
        result = result * 59 + ($encPan == null ? 43 : $encPan.hashCode());
        Object $createdDate = this.getCreatedDate();
        result = result * 59 + ($createdDate == null ? 43 : $createdDate.hashCode());
        Object $updatedDate = this.getUpdatedDate();
        result = result * 59 + ($updatedDate == null ? 43 : $updatedDate.hashCode());
        Object $humoClient = this.getHumoClient();
        result = result * 59 + ($humoClient == null ? 43 : $humoClient.hashCode());
        return result;
    }

    public String toString() {
        return "Card(id=" + this.getId() + ", token=" + this.getToken() + ", bank=" + this.getBank() + ", holder=" + this.getHolder() + ", pan=" + this.getPan() + ", expDate=" + this.getExpDate() + ", status=" + this.getStatus() + ", phone=" + this.getPhone() + ", name=" + this.getName() + ", theme=" + this.getTheme() + ", sms=" + this.getSms() + ", enabled=" + this.getEnabled() + ", deleted=" + this.getDeleted() + ", balance=" + this.getBalance() + ", encPan=" + this.getEncPan() + ", createdDate=" + this.getCreatedDate() + ", updatedDate=" + this.getUpdatedDate() + ", humoClient=" + this.getHumoClient() + ")";
    }
}
