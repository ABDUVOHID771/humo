package com.example.springhumo.model.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HumoClient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String clientId;
    @Column(
            name = "client_b"
    )
    private String clientB;
    private String docsId;
    private String docName;
    private String serialNo;
    private String mobPhone;
    private String surname;
    private String firstName;
    private LocalDate birthDate;

    public static HumoClient.HumoClientBuilder builder() {
        return new HumoClient.HumoClientBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientB() {
        return this.clientB;
    }

    public String getDocsId() {
        return this.docsId;
    }

    public String getDocName() {
        return this.docName;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public String getMobPhone() {
        return this.mobPhone;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public void setClientB(final String clientB) {
        this.clientB = clientB;
    }

    public void setDocsId(final String docsId) {
        this.docsId = docsId;
    }

    public void setDocName(final String docName) {
        this.docName = docName;
    }

    public void setSerialNo(final String serialNo) {
        this.serialNo = serialNo;
    }

    public void setMobPhone(final String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HumoClient)) {
            return false;
        } else {
            HumoClient other = (HumoClient) o;
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

                Object this$clientId = this.getClientId();
                Object other$clientId = other.getClientId();
                if (this$clientId == null) {
                    if (other$clientId != null) {
                        return false;
                    }
                } else if (!this$clientId.equals(other$clientId)) {
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

                label110:
                {
                    Object this$docsId = this.getDocsId();
                    Object other$docsId = other.getDocsId();
                    if (this$docsId == null) {
                        if (other$docsId == null) {
                            break label110;
                        }
                    } else if (this$docsId.equals(other$docsId)) {
                        break label110;
                    }

                    return false;
                }

                label103:
                {
                    Object this$docName = this.getDocName();
                    Object other$docName = other.getDocName();
                    if (this$docName == null) {
                        if (other$docName == null) {
                            break label103;
                        }
                    } else if (this$docName.equals(other$docName)) {
                        break label103;
                    }

                    return false;
                }

                Object this$serialNo = this.getSerialNo();
                Object other$serialNo = other.getSerialNo();
                if (this$serialNo == null) {
                    if (other$serialNo != null) {
                        return false;
                    }
                } else if (!this$serialNo.equals(other$serialNo)) {
                    return false;
                }

                label89:
                {
                    Object this$mobPhone = this.getMobPhone();
                    Object other$mobPhone = other.getMobPhone();
                    if (this$mobPhone == null) {
                        if (other$mobPhone == null) {
                            break label89;
                        }
                    } else if (this$mobPhone.equals(other$mobPhone)) {
                        break label89;
                    }

                    return false;
                }

                label82:
                {
                    Object this$surname = this.getSurname();
                    Object other$surname = other.getSurname();
                    if (this$surname == null) {
                        if (other$surname == null) {
                            break label82;
                        }
                    } else if (this$surname.equals(other$surname)) {
                        break label82;
                    }

                    return false;
                }

                Object this$firstName = this.getFirstName();
                Object other$firstName = other.getFirstName();
                if (this$firstName == null) {
                    if (other$firstName != null) {
                        return false;
                    }
                } else if (!this$firstName.equals(other$firstName)) {
                    return false;
                }

                Object this$birthDate = this.getBirthDate();
                Object other$birthDate = other.getBirthDate();
                if (this$birthDate == null) {
                    if (other$birthDate != null) {
                        return false;
                    }
                } else if (!this$birthDate.equals(other$birthDate)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HumoClient;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $clientId = this.getClientId();
        result = result * 59 + ($clientId == null ? 43 : $clientId.hashCode());
        Object $clientB = this.getClientB();
        result = result * 59 + ($clientB == null ? 43 : $clientB.hashCode());
        Object $docsId = this.getDocsId();
        result = result * 59 + ($docsId == null ? 43 : $docsId.hashCode());
        Object $docName = this.getDocName();
        result = result * 59 + ($docName == null ? 43 : $docName.hashCode());
        Object $serialNo = this.getSerialNo();
        result = result * 59 + ($serialNo == null ? 43 : $serialNo.hashCode());
        Object $mobPhone = this.getMobPhone();
        result = result * 59 + ($mobPhone == null ? 43 : $mobPhone.hashCode());
        Object $surname = this.getSurname();
        result = result * 59 + ($surname == null ? 43 : $surname.hashCode());
        Object $firstName = this.getFirstName();
        result = result * 59 + ($firstName == null ? 43 : $firstName.hashCode());
        Object $birthDate = this.getBirthDate();
        result = result * 59 + ($birthDate == null ? 43 : $birthDate.hashCode());
        return result;
    }

    public String toString() {
        return "HumoClient(id=" + this.getId() + ", clientId=" + this.getClientId() + ", clientB=" + this.getClientB() + ", docsId=" + this.getDocsId() + ", docName=" + this.getDocName() + ", serialNo=" + this.getSerialNo() + ", mobPhone=" + this.getMobPhone() + ", surname=" + this.getSurname() + ", firstName=" + this.getFirstName() + ", birthDate=" + this.getBirthDate() + ")";
    }

    public HumoClient(final Long id, final String clientId, final String clientB, final String docsId, final String docName, final String serialNo, final String mobPhone, final String surname, final String firstName, final LocalDate birthDate) {
        this.id = id;
        this.clientId = clientId;
        this.clientB = clientB;
        this.docsId = docsId;
        this.docName = docName;
        this.serialNo = serialNo;
        this.mobPhone = mobPhone;
        this.surname = surname;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public HumoClient() {
    }

    public static class HumoClientBuilder {
        private Long id;
        private String clientId;
        private String clientB;
        private String docsId;
        private String docName;
        private String serialNo;
        private String mobPhone;
        private String surname;
        private String firstName;
        private LocalDate birthDate;

        HumoClientBuilder() {
        }

        public HumoClient.HumoClientBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public HumoClient.HumoClientBuilder clientId(final String clientId) {
            this.clientId = clientId;
            return this;
        }

        public HumoClient.HumoClientBuilder clientB(final String clientB) {
            this.clientB = clientB;
            return this;
        }

        public HumoClient.HumoClientBuilder docsId(final String docsId) {
            this.docsId = docsId;
            return this;
        }

        public HumoClient.HumoClientBuilder docName(final String docName) {
            this.docName = docName;
            return this;
        }

        public HumoClient.HumoClientBuilder serialNo(final String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public HumoClient.HumoClientBuilder mobPhone(final String mobPhone) {
            this.mobPhone = mobPhone;
            return this;
        }

        public HumoClient.HumoClientBuilder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public HumoClient.HumoClientBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public HumoClient.HumoClientBuilder birthDate(final LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public HumoClient build() {
            return new HumoClient(this.id, this.clientId, this.clientB, this.docsId, this.docName, this.serialNo, this.mobPhone, this.surname, this.firstName, this.birthDate);
        }

        public String toString() {
            return "HumoClient.HumoClientBuilder(id=" + this.id + ", clientId=" + this.clientId + ", clientB=" + this.clientB + ", docsId=" + this.docsId + ", docName=" + this.docName + ", serialNo=" + this.serialNo + ", mobPhone=" + this.mobPhone + ", surname=" + this.surname + ", firstName=" + this.firstName + ", birthDate=" + this.birthDate + ")";
        }
    }
}
