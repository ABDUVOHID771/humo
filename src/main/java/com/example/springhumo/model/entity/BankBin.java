package com.example.springhumo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(
        name = "bank_bin"
)
public class BankBin {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String bin;
    @ManyToOne
    @JoinColumn(
            name = "bank_id"
    )
    private Bank bank;

    public BankBin() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getBin() {
        return this.bin;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setBin(final String bin) {
        this.bin = bin;
    }

    public void setBank(final Bank bank) {
        this.bank = bank;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BankBin)) {
            return false;
        } else {
            BankBin other = (BankBin) o;
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

                Object this$bin = this.getBin();
                Object other$bin = other.getBin();
                if (this$bin == null) {
                    if (other$bin != null) {
                        return false;
                    }
                } else if (!this$bin.equals(other$bin)) {
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
        return other instanceof BankBin;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $bin = this.getBin();
        result = result * 59 + ($bin == null ? 43 : $bin.hashCode());
        Object $bank = this.getBank();
        result = result * 59 + ($bank == null ? 43 : $bank.hashCode());
        return result;
    }

    public String toString() {
        return "BankBin(id=" + this.getId() + ", bin=" + this.getBin() + ", bank=" + this.getBank() + ")";
    }
}
