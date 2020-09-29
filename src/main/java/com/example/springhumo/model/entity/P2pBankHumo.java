package com.example.springhumo.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class P2pBankHumo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Integer id;
    @Column(
            name = "interbank_merchant"
    )
    private String interbankMerchant;
    @Column(
            name = "interbank_terminal"
    )
    private String interbankTerminal;
    @Column(
            name = "interbank_switch_id"
    )
    private String interbankSwitchId;
    @Column(
            name = "interbank_pcnt"
    )
    private Double interbankPercent;
    @Column(
            name = "interbank_ipg_pcnt"
    )
    private Double interbankIpgPercent;
    @Column(
            name = "intrabank_merchant"
    )
    private String intrabankMerchant;
    @Column(
            name = "intrabank_terminal"
    )
    private String intrabankTerminal;
    @Column(
            name = "intrabank_switch_id"
    )
    private String intrabankSwitchId;
    @Column(
            name = "intrabank_pcnt"
    )
    private Double intrabankPercent;
    @Column(
            name = "intrabank_ipg_pcnt"
    )
    private Double intrabankIpgPercent;
    @Column(
            name = "sum_max_onetime"
    )
    private Long sumMaxOneTime;
    @Column(
            name = "sum_max_month"
    )
    private Long sumMaxMonth;
    @Column(
            name = "ext_service"
    )
    private Boolean extService;
    @Column(
            name = "enabled"
    )
    private Boolean enabled;
    @Column(
            name = "deleted"
    )
    private Boolean deleted;
    @Column(
            name = "instime"
    )
    private LocalDateTime instime;
    @Column(
            name = "updtime"
    )
    private LocalDateTime updtime;
    @ManyToOne
    @JoinColumn(
            name = "bank_id"
    )
    private Bank bank;

    public P2pBankHumo() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getInterbankMerchant() {
        return this.interbankMerchant;
    }

    public String getInterbankTerminal() {
        return this.interbankTerminal;
    }

    public String getInterbankSwitchId() {
        return this.interbankSwitchId;
    }

    public Double getInterbankPercent() {
        return this.interbankPercent;
    }

    public Double getInterbankIpgPercent() {
        return this.interbankIpgPercent;
    }

    public String getIntrabankMerchant() {
        return this.intrabankMerchant;
    }

    public String getIntrabankTerminal() {
        return this.intrabankTerminal;
    }

    public String getIntrabankSwitchId() {
        return this.intrabankSwitchId;
    }

    public Double getIntrabankPercent() {
        return this.intrabankPercent;
    }

    public Double getIntrabankIpgPercent() {
        return this.intrabankIpgPercent;
    }

    public Long getSumMaxOneTime() {
        return this.sumMaxOneTime;
    }

    public Long getSumMaxMonth() {
        return this.sumMaxMonth;
    }

    public Boolean getExtService() {
        return this.extService;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public LocalDateTime getInstime() {
        return this.instime;
    }

    public LocalDateTime getUpdtime() {
        return this.updtime;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setInterbankMerchant(final String interbankMerchant) {
        this.interbankMerchant = interbankMerchant;
    }

    public void setInterbankTerminal(final String interbankTerminal) {
        this.interbankTerminal = interbankTerminal;
    }

    public void setInterbankSwitchId(final String interbankSwitchId) {
        this.interbankSwitchId = interbankSwitchId;
    }

    public void setInterbankPercent(final Double interbankPercent) {
        this.interbankPercent = interbankPercent;
    }

    public void setInterbankIpgPercent(final Double interbankIpgPercent) {
        this.interbankIpgPercent = interbankIpgPercent;
    }

    public void setIntrabankMerchant(final String intrabankMerchant) {
        this.intrabankMerchant = intrabankMerchant;
    }

    public void setIntrabankTerminal(final String intrabankTerminal) {
        this.intrabankTerminal = intrabankTerminal;
    }

    public void setIntrabankSwitchId(final String intrabankSwitchId) {
        this.intrabankSwitchId = intrabankSwitchId;
    }

    public void setIntrabankPercent(final Double intrabankPercent) {
        this.intrabankPercent = intrabankPercent;
    }

    public void setIntrabankIpgPercent(final Double intrabankIpgPercent) {
        this.intrabankIpgPercent = intrabankIpgPercent;
    }

    public void setSumMaxOneTime(final Long sumMaxOneTime) {
        this.sumMaxOneTime = sumMaxOneTime;
    }

    public void setSumMaxMonth(final Long sumMaxMonth) {
        this.sumMaxMonth = sumMaxMonth;
    }

    public void setExtService(final Boolean extService) {
        this.extService = extService;
    }

    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    public void setDeleted(final Boolean deleted) {
        this.deleted = deleted;
    }

    public void setInstime(final LocalDateTime instime) {
        this.instime = instime;
    }

    public void setUpdtime(final LocalDateTime updtime) {
        this.updtime = updtime;
    }

    public void setBank(final Bank bank) {
        this.bank = bank;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof P2pBankHumo)) {
            return false;
        } else {
            P2pBankHumo other = (P2pBankHumo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label239: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label239;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label239;
                    }

                    return false;
                }

                Object this$interbankMerchant = this.getInterbankMerchant();
                Object other$interbankMerchant = other.getInterbankMerchant();
                if (this$interbankMerchant == null) {
                    if (other$interbankMerchant != null) {
                        return false;
                    }
                } else if (!this$interbankMerchant.equals(other$interbankMerchant)) {
                    return false;
                }

                Object this$interbankTerminal = this.getInterbankTerminal();
                Object other$interbankTerminal = other.getInterbankTerminal();
                if (this$interbankTerminal == null) {
                    if (other$interbankTerminal != null) {
                        return false;
                    }
                } else if (!this$interbankTerminal.equals(other$interbankTerminal)) {
                    return false;
                }

                label218: {
                    Object this$interbankSwitchId = this.getInterbankSwitchId();
                    Object other$interbankSwitchId = other.getInterbankSwitchId();
                    if (this$interbankSwitchId == null) {
                        if (other$interbankSwitchId == null) {
                            break label218;
                        }
                    } else if (this$interbankSwitchId.equals(other$interbankSwitchId)) {
                        break label218;
                    }

                    return false;
                }

                label211: {
                    Object this$interbankPercent = this.getInterbankPercent();
                    Object other$interbankPercent = other.getInterbankPercent();
                    if (this$interbankPercent == null) {
                        if (other$interbankPercent == null) {
                            break label211;
                        }
                    } else if (this$interbankPercent.equals(other$interbankPercent)) {
                        break label211;
                    }

                    return false;
                }

                Object this$interbankIpgPercent = this.getInterbankIpgPercent();
                Object other$interbankIpgPercent = other.getInterbankIpgPercent();
                if (this$interbankIpgPercent == null) {
                    if (other$interbankIpgPercent != null) {
                        return false;
                    }
                } else if (!this$interbankIpgPercent.equals(other$interbankIpgPercent)) {
                    return false;
                }

                Object this$intrabankMerchant = this.getIntrabankMerchant();
                Object other$intrabankMerchant = other.getIntrabankMerchant();
                if (this$intrabankMerchant == null) {
                    if (other$intrabankMerchant != null) {
                        return false;
                    }
                } else if (!this$intrabankMerchant.equals(other$intrabankMerchant)) {
                    return false;
                }

                label190: {
                    Object this$intrabankTerminal = this.getIntrabankTerminal();
                    Object other$intrabankTerminal = other.getIntrabankTerminal();
                    if (this$intrabankTerminal == null) {
                        if (other$intrabankTerminal == null) {
                            break label190;
                        }
                    } else if (this$intrabankTerminal.equals(other$intrabankTerminal)) {
                        break label190;
                    }

                    return false;
                }

                label183: {
                    Object this$intrabankSwitchId = this.getIntrabankSwitchId();
                    Object other$intrabankSwitchId = other.getIntrabankSwitchId();
                    if (this$intrabankSwitchId == null) {
                        if (other$intrabankSwitchId == null) {
                            break label183;
                        }
                    } else if (this$intrabankSwitchId.equals(other$intrabankSwitchId)) {
                        break label183;
                    }

                    return false;
                }

                Object this$intrabankPercent = this.getIntrabankPercent();
                Object other$intrabankPercent = other.getIntrabankPercent();
                if (this$intrabankPercent == null) {
                    if (other$intrabankPercent != null) {
                        return false;
                    }
                } else if (!this$intrabankPercent.equals(other$intrabankPercent)) {
                    return false;
                }

                label169: {
                    Object this$intrabankIpgPercent = this.getIntrabankIpgPercent();
                    Object other$intrabankIpgPercent = other.getIntrabankIpgPercent();
                    if (this$intrabankIpgPercent == null) {
                        if (other$intrabankIpgPercent == null) {
                            break label169;
                        }
                    } else if (this$intrabankIpgPercent.equals(other$intrabankIpgPercent)) {
                        break label169;
                    }

                    return false;
                }

                Object this$sumMaxOneTime = this.getSumMaxOneTime();
                Object other$sumMaxOneTime = other.getSumMaxOneTime();
                if (this$sumMaxOneTime == null) {
                    if (other$sumMaxOneTime != null) {
                        return false;
                    }
                } else if (!this$sumMaxOneTime.equals(other$sumMaxOneTime)) {
                    return false;
                }

                label155: {
                    Object this$sumMaxMonth = this.getSumMaxMonth();
                    Object other$sumMaxMonth = other.getSumMaxMonth();
                    if (this$sumMaxMonth == null) {
                        if (other$sumMaxMonth == null) {
                            break label155;
                        }
                    } else if (this$sumMaxMonth.equals(other$sumMaxMonth)) {
                        break label155;
                    }

                    return false;
                }

                Object this$extService = this.getExtService();
                Object other$extService = other.getExtService();
                if (this$extService == null) {
                    if (other$extService != null) {
                        return false;
                    }
                } else if (!this$extService.equals(other$extService)) {
                    return false;
                }

                Object this$enabled = this.getEnabled();
                Object other$enabled = other.getEnabled();
                if (this$enabled == null) {
                    if (other$enabled != null) {
                        return false;
                    }
                } else if (!this$enabled.equals(other$enabled)) {
                    return false;
                }

                label134: {
                    Object this$deleted = this.getDeleted();
                    Object other$deleted = other.getDeleted();
                    if (this$deleted == null) {
                        if (other$deleted == null) {
                            break label134;
                        }
                    } else if (this$deleted.equals(other$deleted)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$instime = this.getInstime();
                    Object other$instime = other.getInstime();
                    if (this$instime == null) {
                        if (other$instime == null) {
                            break label127;
                        }
                    } else if (this$instime.equals(other$instime)) {
                        break label127;
                    }

                    return false;
                }

                Object this$updtime = this.getUpdtime();
                Object other$updtime = other.getUpdtime();
                if (this$updtime == null) {
                    if (other$updtime != null) {
                        return false;
                    }
                } else if (!this$updtime.equals(other$updtime)) {
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
        return other instanceof P2pBankHumo;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $id = this.getId();
         result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $interbankMerchant = this.getInterbankMerchant();
        result = result * 59 + ($interbankMerchant == null ? 43 : $interbankMerchant.hashCode());
        Object $interbankTerminal = this.getInterbankTerminal();
        result = result * 59 + ($interbankTerminal == null ? 43 : $interbankTerminal.hashCode());
        Object $interbankSwitchId = this.getInterbankSwitchId();
        result = result * 59 + ($interbankSwitchId == null ? 43 : $interbankSwitchId.hashCode());
        Object $interbankPercent = this.getInterbankPercent();
        result = result * 59 + ($interbankPercent == null ? 43 : $interbankPercent.hashCode());
        Object $interbankIpgPercent = this.getInterbankIpgPercent();
        result = result * 59 + ($interbankIpgPercent == null ? 43 : $interbankIpgPercent.hashCode());
        Object $intrabankMerchant = this.getIntrabankMerchant();
        result = result * 59 + ($intrabankMerchant == null ? 43 : $intrabankMerchant.hashCode());
        Object $intrabankTerminal = this.getIntrabankTerminal();
        result = result * 59 + ($intrabankTerminal == null ? 43 : $intrabankTerminal.hashCode());
        Object $intrabankSwitchId = this.getIntrabankSwitchId();
        result = result * 59 + ($intrabankSwitchId == null ? 43 : $intrabankSwitchId.hashCode());
        Object $intrabankPercent = this.getIntrabankPercent();
        result = result * 59 + ($intrabankPercent == null ? 43 : $intrabankPercent.hashCode());
        Object $intrabankIpgPercent = this.getIntrabankIpgPercent();
        result = result * 59 + ($intrabankIpgPercent == null ? 43 : $intrabankIpgPercent.hashCode());
        Object $sumMaxOneTime = this.getSumMaxOneTime();
        result = result * 59 + ($sumMaxOneTime == null ? 43 : $sumMaxOneTime.hashCode());
        Object $sumMaxMonth = this.getSumMaxMonth();
        result = result * 59 + ($sumMaxMonth == null ? 43 : $sumMaxMonth.hashCode());
        Object $extService = this.getExtService();
        result = result * 59 + ($extService == null ? 43 : $extService.hashCode());
        Object $enabled = this.getEnabled();
        result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
        Object $deleted = this.getDeleted();
        result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
        Object $instime = this.getInstime();
        result = result * 59 + ($instime == null ? 43 : $instime.hashCode());
        Object $updtime = this.getUpdtime();
        result = result * 59 + ($updtime == null ? 43 : $updtime.hashCode());
        Object $bank = this.getBank();
        result = result * 59 + ($bank == null ? 43 : $bank.hashCode());
        return result;
    }

    public String toString() {
        return "P2pBankHumo(id=" + this.getId() + ", interbankMerchant=" + this.getInterbankMerchant() + ", interbankTerminal=" + this.getInterbankTerminal() + ", interbankSwitchId=" + this.getInterbankSwitchId() + ", interbankPercent=" + this.getInterbankPercent() + ", interbankIpgPercent=" + this.getInterbankIpgPercent() + ", intrabankMerchant=" + this.getIntrabankMerchant() + ", intrabankTerminal=" + this.getIntrabankTerminal() + ", intrabankSwitchId=" + this.getIntrabankSwitchId() + ", intrabankPercent=" + this.getIntrabankPercent() + ", intrabankIpgPercent=" + this.getIntrabankIpgPercent() + ", sumMaxOneTime=" + this.getSumMaxOneTime() + ", sumMaxMonth=" + this.getSumMaxMonth() + ", extService=" + this.getExtService() + ", enabled=" + this.getEnabled() + ", deleted=" + this.getDeleted() + ", instime=" + this.getInstime() + ", updtime=" + this.getUpdtime() + ", bank=" + this.getBank() + ")";
    }
}
