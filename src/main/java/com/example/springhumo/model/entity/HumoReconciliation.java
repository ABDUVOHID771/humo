package com.example.springhumo.model.entity;

import com.example.springhumo.constant.ReconciliationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HumoReconciliation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private Integer paymentId;
    private String terminalId;
    @Column(
            columnDefinition = "enum('CREATED', 'CONFIRMED', 'ERROR')"
    )
    @Enumerated(EnumType.STRING)
    private ReconciliationStatus status;
    private BigDecimal debitsNumber;
    private BigDecimal debitsAmount;
    private BigDecimal creditsReversalNumber;
    private BigDecimal creditsReversalAmount;
    private LocalDateTime created;
    private LocalDateTime updated;

    public HumoReconciliation() {
        this.status = ReconciliationStatus.CREATED;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public ReconciliationStatus getStatus() {
        return this.status;
    }

    public BigDecimal getDebitsNumber() {
        return this.debitsNumber;
    }

    public BigDecimal getDebitsAmount() {
        return this.debitsAmount;
    }

    public BigDecimal getCreditsReversalNumber() {
        return this.creditsReversalNumber;
    }

    public BigDecimal getCreditsReversalAmount() {
        return this.creditsReversalAmount;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    public void setStatus(final ReconciliationStatus status) {
        this.status = status;
    }

    public void setDebitsNumber(final BigDecimal debitsNumber) {
        this.debitsNumber = debitsNumber;
    }

    public void setDebitsAmount(final BigDecimal debitsAmount) {
        this.debitsAmount = debitsAmount;
    }

    public void setCreditsReversalNumber(final BigDecimal creditsReversalNumber) {
        this.creditsReversalNumber = creditsReversalNumber;
    }

    public void setCreditsReversalAmount(final BigDecimal creditsReversalAmount) {
        this.creditsReversalAmount = creditsReversalAmount;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HumoReconciliation)) {
            return false;
        } else {
            HumoReconciliation other = (HumoReconciliation) o;
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

                Object this$paymentId = this.getPaymentId();
                Object other$paymentId = other.getPaymentId();
                if (this$paymentId == null) {
                    if (other$paymentId != null) {
                        return false;
                    }
                } else if (!this$paymentId.equals(other$paymentId)) {
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

                label110:
                {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label110;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label110;
                    }

                    return false;
                }

                label103:
                {
                    Object this$debitsNumber = this.getDebitsNumber();
                    Object other$debitsNumber = other.getDebitsNumber();
                    if (this$debitsNumber == null) {
                        if (other$debitsNumber == null) {
                            break label103;
                        }
                    } else if (this$debitsNumber.equals(other$debitsNumber)) {
                        break label103;
                    }

                    return false;
                }

                Object this$debitsAmount = this.getDebitsAmount();
                Object other$debitsAmount = other.getDebitsAmount();
                if (this$debitsAmount == null) {
                    if (other$debitsAmount != null) {
                        return false;
                    }
                } else if (!this$debitsAmount.equals(other$debitsAmount)) {
                    return false;
                }

                label89:
                {
                    Object this$creditsReversalNumber = this.getCreditsReversalNumber();
                    Object other$creditsReversalNumber = other.getCreditsReversalNumber();
                    if (this$creditsReversalNumber == null) {
                        if (other$creditsReversalNumber == null) {
                            break label89;
                        }
                    } else if (this$creditsReversalNumber.equals(other$creditsReversalNumber)) {
                        break label89;
                    }

                    return false;
                }

                label82:
                {
                    Object this$creditsReversalAmount = this.getCreditsReversalAmount();
                    Object other$creditsReversalAmount = other.getCreditsReversalAmount();
                    if (this$creditsReversalAmount == null) {
                        if (other$creditsReversalAmount == null) {
                            break label82;
                        }
                    } else if (this$creditsReversalAmount.equals(other$creditsReversalAmount)) {
                        break label82;
                    }

                    return false;
                }

                Object this$created = this.getCreated();
                Object other$created = other.getCreated();
                if (this$created == null) {
                    if (other$created != null) {
                        return false;
                    }
                } else if (!this$created.equals(other$created)) {
                    return false;
                }

                Object this$updated = this.getUpdated();
                Object other$updated = other.getUpdated();
                if (this$updated == null) {
                    if (other$updated != null) {
                        return false;
                    }
                } else if (!this$updated.equals(other$updated)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HumoReconciliation;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $paymentId = this.getPaymentId();
        result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $debitsNumber = this.getDebitsNumber();
        result = result * 59 + ($debitsNumber == null ? 43 : $debitsNumber.hashCode());
        Object $debitsAmount = this.getDebitsAmount();
        result = result * 59 + ($debitsAmount == null ? 43 : $debitsAmount.hashCode());
        Object $creditsReversalNumber = this.getCreditsReversalNumber();
        result = result * 59 + ($creditsReversalNumber == null ? 43 : $creditsReversalNumber.hashCode());
        Object $creditsReversalAmount = this.getCreditsReversalAmount();
        result = result * 59 + ($creditsReversalAmount == null ? 43 : $creditsReversalAmount.hashCode());
        Object $created = this.getCreated();
        result = result * 59 + ($created == null ? 43 : $created.hashCode());
        Object $updated = this.getUpdated();
        result = result * 59 + ($updated == null ? 43 : $updated.hashCode());
        return result;
    }

    public String toString() {
        return "HumoReconciliation(id=" + this.getId() + ", paymentId=" + this.getPaymentId() + ", terminalId=" + this.getTerminalId() + ", status=" + this.getStatus() + ", debitsNumber=" + this.getDebitsNumber() + ", debitsAmount=" + this.getDebitsAmount() + ", creditsReversalNumber=" + this.getCreditsReversalNumber() + ", creditsReversalAmount=" + this.getCreditsReversalAmount() + ", created=" + this.getCreated() + ", updated=" + this.getUpdated() + ")";
    }
}
