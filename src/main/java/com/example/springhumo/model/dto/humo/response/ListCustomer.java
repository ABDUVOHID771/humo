package com.example.springhumo.model.dto.humo.response;

import java.util.Map;

public class ListCustomer {
    private String mobilePhone;
    private String a3vtsCounty;
    private String clientB;
    private String supplimentaryExpiry;
    private String card;
    private String empName;
    private String bankC;
    private String personCode;
    private String supplementaryCvv2;
    private String rCntry;
    private String uCodl;
    private String rCity;
    private String docSince;
    private String fNames;
    private String notes;
    private String rStreet;
    private String docName;
    private String docType;
    private String surname;
    private String supplimentaryPan;
    private String bDate;
    private String serialNo;
    private String issuedBy;
    private String client;
    private String rEMails;
    private String rPcode;
    private String a3vtsFlag1;
    private String a3vtsFlag2;
    private String idCard;
    private String status;

    public ListCustomer(Map<String, String> params) {
        this.mobilePhone = (String) params.get("R_MOB_PHONE");
        this.a3vtsCounty = (String) params.get("A3VTS_COUNTY");
        this.clientB = (String) params.get("CLIENT_B");
        this.supplimentaryExpiry = (String) params.get("SUPPLEMENTARY_EXPIRY");
        this.card = (String) params.get("CARD");
        this.empName = (String) params.get("EMP_NAME");
        this.bankC = (String) params.get("BANK_C");
        this.personCode = (String) params.get("PERSON_CODE");
        this.supplementaryCvv2 = (String) params.get("SUPPLEMENTARY_CVV2");
        this.rCntry = (String) params.get("R_CNTRY");
        this.uCodl = (String) params.get("U_COD1");
        this.rCity = (String) params.get("R_CITY");
        this.docSince = (String) params.get("DOC_SINCE");
        this.fNames = (String) params.get("F_NAMES");
        this.notes = (String) params.get("NOTES");
        this.rStreet = (String) params.get("R_STREET");
        this.docName = (String) params.get("DOC_NAME");
        this.docType = (String) params.get("DOC_TYPE");
        this.surname = (String) params.get("SURNAME");
        this.supplimentaryPan = (String) params.get("SUPPLEMENTARY_PAN");
        this.bDate = (String) params.get("B_DATE");
        this.serialNo = (String) params.get("SERIAL_NO");
        this.issuedBy = (String) params.get("ISSUED_BY");
        this.client = (String) params.get("CLIENT");
        this.rEMails = (String) params.get("R_E_MAILS");
        this.rPcode = (String) params.get("R_PCODE");
        this.a3vtsFlag1 = (String) params.get("A3VTS_FLAG1");
        this.a3vtsFlag2 = (String) params.get("A3VTS_FLAG2");
        this.idCard = (String) params.get("ID_CARD");
        this.status = (String) params.get("STATUS");
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public String getA3vtsCounty() {
        return this.a3vtsCounty;
    }

    public String getClientB() {
        return this.clientB;
    }

    public String getSupplimentaryExpiry() {
        return this.supplimentaryExpiry;
    }

    public String getCard() {
        return this.card;
    }

    public String getEmpName() {
        return this.empName;
    }

    public String getBankC() {
        return this.bankC;
    }

    public String getPersonCode() {
        return this.personCode;
    }

    public String getSupplementaryCvv2() {
        return this.supplementaryCvv2;
    }

    public String getRCntry() {
        return this.rCntry;
    }

    public String getUCodl() {
        return this.uCodl;
    }

    public String getRCity() {
        return this.rCity;
    }

    public String getDocSince() {
        return this.docSince;
    }

    public String getFNames() {
        return this.fNames;
    }

    public String getNotes() {
        return this.notes;
    }

    public String getRStreet() {
        return this.rStreet;
    }

    public String getDocName() {
        return this.docName;
    }

    public String getDocType() {
        return this.docType;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getSupplimentaryPan() {
        return this.supplimentaryPan;
    }

    public String getBDate() {
        return this.bDate;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public String getIssuedBy() {
        return this.issuedBy;
    }

    public String getClient() {
        return this.client;
    }

    public String getREMails() {
        return this.rEMails;
    }

    public String getRPcode() {
        return this.rPcode;
    }

    public String getA3vtsFlag1() {
        return this.a3vtsFlag1;
    }

    public String getA3vtsFlag2() {
        return this.a3vtsFlag2;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setA3vtsCounty(final String a3vtsCounty) {
        this.a3vtsCounty = a3vtsCounty;
    }

    public void setClientB(final String clientB) {
        this.clientB = clientB;
    }

    public void setSupplimentaryExpiry(final String supplimentaryExpiry) {
        this.supplimentaryExpiry = supplimentaryExpiry;
    }

    public void setCard(final String card) {
        this.card = card;
    }

    public void setEmpName(final String empName) {
        this.empName = empName;
    }

    public void setBankC(final String bankC) {
        this.bankC = bankC;
    }

    public void setPersonCode(final String personCode) {
        this.personCode = personCode;
    }

    public void setSupplementaryCvv2(final String supplementaryCvv2) {
        this.supplementaryCvv2 = supplementaryCvv2;
    }

    public void setRCntry(final String rCntry) {
        this.rCntry = rCntry;
    }

    public void setUCodl(final String uCodl) {
        this.uCodl = uCodl;
    }

    public void setRCity(final String rCity) {
        this.rCity = rCity;
    }

    public void setDocSince(final String docSince) {
        this.docSince = docSince;
    }

    public void setFNames(final String fNames) {
        this.fNames = fNames;
    }

    public void setNotes(final String notes) {
        this.notes = notes;
    }

    public void setRStreet(final String rStreet) {
        this.rStreet = rStreet;
    }

    public void setDocName(final String docName) {
        this.docName = docName;
    }

    public void setDocType(final String docType) {
        this.docType = docType;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setSupplimentaryPan(final String supplimentaryPan) {
        this.supplimentaryPan = supplimentaryPan;
    }

    public void setBDate(final String bDate) {
        this.bDate = bDate;
    }

    public void setSerialNo(final String serialNo) {
        this.serialNo = serialNo;
    }

    public void setIssuedBy(final String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setClient(final String client) {
        this.client = client;
    }

    public void setREMails(final String rEMails) {
        this.rEMails = rEMails;
    }

    public void setRPcode(final String rPcode) {
        this.rPcode = rPcode;
    }

    public void setA3vtsFlag1(final String a3vtsFlag1) {
        this.a3vtsFlag1 = a3vtsFlag1;
    }

    public void setA3vtsFlag2(final String a3vtsFlag2) {
        this.a3vtsFlag2 = a3vtsFlag2;
    }

    public void setIdCard(final String idCard) {
        this.idCard = idCard;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ListCustomer)) {
            return false;
        } else {
            ListCustomer other = (ListCustomer) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$mobilePhone = this.getMobilePhone();
                Object other$mobilePhone = other.getMobilePhone();
                if (this$mobilePhone == null) {
                    if (other$mobilePhone != null) {
                        return false;
                    }
                } else if (!this$mobilePhone.equals(other$mobilePhone)) {
                    return false;
                }

                Object this$a3vtsCounty = this.getA3vtsCounty();
                Object other$a3vtsCounty = other.getA3vtsCounty();
                if (this$a3vtsCounty == null) {
                    if (other$a3vtsCounty != null) {
                        return false;
                    }
                } else if (!this$a3vtsCounty.equals(other$a3vtsCounty)) {
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

                label350:
                {
                    Object this$supplimentaryExpiry = this.getSupplimentaryExpiry();
                    Object other$supplimentaryExpiry = other.getSupplimentaryExpiry();
                    if (this$supplimentaryExpiry == null) {
                        if (other$supplimentaryExpiry == null) {
                            break label350;
                        }
                    } else if (this$supplimentaryExpiry.equals(other$supplimentaryExpiry)) {
                        break label350;
                    }

                    return false;
                }

                label343:
                {
                    Object this$card = this.getCard();
                    Object other$card = other.getCard();
                    if (this$card == null) {
                        if (other$card == null) {
                            break label343;
                        }
                    } else if (this$card.equals(other$card)) {
                        break label343;
                    }

                    return false;
                }

                Object this$empName = this.getEmpName();
                Object other$empName = other.getEmpName();
                if (this$empName == null) {
                    if (other$empName != null) {
                        return false;
                    }
                } else if (!this$empName.equals(other$empName)) {
                    return false;
                }

                label329:
                {
                    Object this$bankC = this.getBankC();
                    Object other$bankC = other.getBankC();
                    if (this$bankC == null) {
                        if (other$bankC == null) {
                            break label329;
                        }
                    } else if (this$bankC.equals(other$bankC)) {
                        break label329;
                    }

                    return false;
                }

                label322:
                {
                    Object this$personCode = this.getPersonCode();
                    Object other$personCode = other.getPersonCode();
                    if (this$personCode == null) {
                        if (other$personCode == null) {
                            break label322;
                        }
                    } else if (this$personCode.equals(other$personCode)) {
                        break label322;
                    }

                    return false;
                }

                Object this$supplementaryCvv2 = this.getSupplementaryCvv2();
                Object other$supplementaryCvv2 = other.getSupplementaryCvv2();
                if (this$supplementaryCvv2 == null) {
                    if (other$supplementaryCvv2 != null) {
                        return false;
                    }
                } else if (!this$supplementaryCvv2.equals(other$supplementaryCvv2)) {
                    return false;
                }

                Object this$rCntry = this.getRCntry();
                Object other$rCntry = other.getRCntry();
                if (this$rCntry == null) {
                    if (other$rCntry != null) {
                        return false;
                    }
                } else if (!this$rCntry.equals(other$rCntry)) {
                    return false;
                }

                label301:
                {
                    Object this$uCodl = this.getUCodl();
                    Object other$uCodl = other.getUCodl();
                    if (this$uCodl == null) {
                        if (other$uCodl == null) {
                            break label301;
                        }
                    } else if (this$uCodl.equals(other$uCodl)) {
                        break label301;
                    }

                    return false;
                }

                label294:
                {
                    Object this$rCity = this.getRCity();
                    Object other$rCity = other.getRCity();
                    if (this$rCity == null) {
                        if (other$rCity == null) {
                            break label294;
                        }
                    } else if (this$rCity.equals(other$rCity)) {
                        break label294;
                    }

                    return false;
                }

                Object this$docSince = this.getDocSince();
                Object other$docSince = other.getDocSince();
                if (this$docSince == null) {
                    if (other$docSince != null) {
                        return false;
                    }
                } else if (!this$docSince.equals(other$docSince)) {
                    return false;
                }

                label280:
                {
                    Object this$fNames = this.getFNames();
                    Object other$fNames = other.getFNames();
                    if (this$fNames == null) {
                        if (other$fNames == null) {
                            break label280;
                        }
                    } else if (this$fNames.equals(other$fNames)) {
                        break label280;
                    }

                    return false;
                }

                Object this$notes = this.getNotes();
                Object other$notes = other.getNotes();
                if (this$notes == null) {
                    if (other$notes != null) {
                        return false;
                    }
                } else if (!this$notes.equals(other$notes)) {
                    return false;
                }

                label266:
                {
                    Object this$rStreet = this.getRStreet();
                    Object other$rStreet = other.getRStreet();
                    if (this$rStreet == null) {
                        if (other$rStreet == null) {
                            break label266;
                        }
                    } else if (this$rStreet.equals(other$rStreet)) {
                        break label266;
                    }

                    return false;
                }

                Object this$docName = this.getDocName();
                Object other$docName = other.getDocName();
                if (this$docName == null) {
                    if (other$docName != null) {
                        return false;
                    }
                } else if (!this$docName.equals(other$docName)) {
                    return false;
                }

                Object this$docType = this.getDocType();
                Object other$docType = other.getDocType();
                if (this$docType == null) {
                    if (other$docType != null) {
                        return false;
                    }
                } else if (!this$docType.equals(other$docType)) {
                    return false;
                }

                Object this$surname = this.getSurname();
                Object other$surname = other.getSurname();
                if (this$surname == null) {
                    if (other$surname != null) {
                        return false;
                    }
                } else if (!this$surname.equals(other$surname)) {
                    return false;
                }

                label238:
                {
                    Object this$supplimentaryPan = this.getSupplimentaryPan();
                    Object other$supplimentaryPan = other.getSupplimentaryPan();
                    if (this$supplimentaryPan == null) {
                        if (other$supplimentaryPan == null) {
                            break label238;
                        }
                    } else if (this$supplimentaryPan.equals(other$supplimentaryPan)) {
                        break label238;
                    }

                    return false;
                }

                label231:
                {
                    Object this$bDate = this.getBDate();
                    Object other$bDate = other.getBDate();
                    if (this$bDate == null) {
                        if (other$bDate == null) {
                            break label231;
                        }
                    } else if (this$bDate.equals(other$bDate)) {
                        break label231;
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

                label217:
                {
                    Object this$issuedBy = this.getIssuedBy();
                    Object other$issuedBy = other.getIssuedBy();
                    if (this$issuedBy == null) {
                        if (other$issuedBy == null) {
                            break label217;
                        }
                    } else if (this$issuedBy.equals(other$issuedBy)) {
                        break label217;
                    }

                    return false;
                }

                label210:
                {
                    Object this$client = this.getClient();
                    Object other$client = other.getClient();
                    if (this$client == null) {
                        if (other$client == null) {
                            break label210;
                        }
                    } else if (this$client.equals(other$client)) {
                        break label210;
                    }

                    return false;
                }

                Object this$rEMails = this.getREMails();
                Object other$rEMails = other.getREMails();
                if (this$rEMails == null) {
                    if (other$rEMails != null) {
                        return false;
                    }
                } else if (!this$rEMails.equals(other$rEMails)) {
                    return false;
                }

                Object this$rPcode = this.getRPcode();
                Object other$rPcode = other.getRPcode();
                if (this$rPcode == null) {
                    if (other$rPcode != null) {
                        return false;
                    }
                } else if (!this$rPcode.equals(other$rPcode)) {
                    return false;
                }

                label189:
                {
                    Object this$a3vtsFlag1 = this.getA3vtsFlag1();
                    Object other$a3vtsFlag1 = other.getA3vtsFlag1();
                    if (this$a3vtsFlag1 == null) {
                        if (other$a3vtsFlag1 == null) {
                            break label189;
                        }
                    } else if (this$a3vtsFlag1.equals(other$a3vtsFlag1)) {
                        break label189;
                    }

                    return false;
                }

                label182:
                {
                    Object this$a3vtsFlag2 = this.getA3vtsFlag2();
                    Object other$a3vtsFlag2 = other.getA3vtsFlag2();
                    if (this$a3vtsFlag2 == null) {
                        if (other$a3vtsFlag2 == null) {
                            break label182;
                        }
                    } else if (this$a3vtsFlag2.equals(other$a3vtsFlag2)) {
                        break label182;
                    }

                    return false;
                }

                Object this$idCard = this.getIdCard();
                Object other$idCard = other.getIdCard();
                if (this$idCard == null) {
                    if (other$idCard != null) {
                        return false;
                    }
                } else if (!this$idCard.equals(other$idCard)) {
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
        return other instanceof ListCustomer;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $mobilePhone = this.getMobilePhone();
        result = result * 59 + ($mobilePhone == null ? 43 : $mobilePhone.hashCode());
        Object $a3vtsCounty = this.getA3vtsCounty();
        result = result * 59 + ($a3vtsCounty == null ? 43 : $a3vtsCounty.hashCode());
        Object $clientB = this.getClientB();
        result = result * 59 + ($clientB == null ? 43 : $clientB.hashCode());
        Object $supplimentaryExpiry = this.getSupplimentaryExpiry();
        result = result * 59 + ($supplimentaryExpiry == null ? 43 : $supplimentaryExpiry.hashCode());
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        Object $empName = this.getEmpName();
        result = result * 59 + ($empName == null ? 43 : $empName.hashCode());
        Object $bankC = this.getBankC();
        result = result * 59 + ($bankC == null ? 43 : $bankC.hashCode());
        Object $personCode = this.getPersonCode();
        result = result * 59 + ($personCode == null ? 43 : $personCode.hashCode());
        Object $supplementaryCvv2 = this.getSupplementaryCvv2();
        result = result * 59 + ($supplementaryCvv2 == null ? 43 : $supplementaryCvv2.hashCode());
        Object $rCntry = this.getRCntry();
        result = result * 59 + ($rCntry == null ? 43 : $rCntry.hashCode());
        Object $uCodl = this.getUCodl();
        result = result * 59 + ($uCodl == null ? 43 : $uCodl.hashCode());
        Object $rCity = this.getRCity();
        result = result * 59 + ($rCity == null ? 43 : $rCity.hashCode());
        Object $docSince = this.getDocSince();
        result = result * 59 + ($docSince == null ? 43 : $docSince.hashCode());
        Object $fNames = this.getFNames();
        result = result * 59 + ($fNames == null ? 43 : $fNames.hashCode());
        Object $notes = this.getNotes();
        result = result * 59 + ($notes == null ? 43 : $notes.hashCode());
        Object $rStreet = this.getRStreet();
        result = result * 59 + ($rStreet == null ? 43 : $rStreet.hashCode());
        Object $docName = this.getDocName();
        result = result * 59 + ($docName == null ? 43 : $docName.hashCode());
        Object $docType = this.getDocType();
        result = result * 59 + ($docType == null ? 43 : $docType.hashCode());
        Object $surname = this.getSurname();
        result = result * 59 + ($surname == null ? 43 : $surname.hashCode());
        Object $supplimentaryPan = this.getSupplimentaryPan();
        result = result * 59 + ($supplimentaryPan == null ? 43 : $supplimentaryPan.hashCode());
        Object $bDate = this.getBDate();
        result = result * 59 + ($bDate == null ? 43 : $bDate.hashCode());
        Object $serialNo = this.getSerialNo();
        result = result * 59 + ($serialNo == null ? 43 : $serialNo.hashCode());
        Object $issuedBy = this.getIssuedBy();
        result = result * 59 + ($issuedBy == null ? 43 : $issuedBy.hashCode());
        Object $client = this.getClient();
        result = result * 59 + ($client == null ? 43 : $client.hashCode());
        Object $rEMails = this.getREMails();
        result = result * 59 + ($rEMails == null ? 43 : $rEMails.hashCode());
        Object $rPcode = this.getRPcode();
        result = result * 59 + ($rPcode == null ? 43 : $rPcode.hashCode());
        Object $a3vtsFlag1 = this.getA3vtsFlag1();
        result = result * 59 + ($a3vtsFlag1 == null ? 43 : $a3vtsFlag1.hashCode());
        Object $a3vtsFlag2 = this.getA3vtsFlag2();
        result = result * 59 + ($a3vtsFlag2 == null ? 43 : $a3vtsFlag2.hashCode());
        Object $idCard = this.getIdCard();
        result = result * 59 + ($idCard == null ? 43 : $idCard.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "ListCustomer(mobilePhone=" + this.getMobilePhone() + ", a3vtsCounty=" + this.getA3vtsCounty() + ", clientB=" + this.getClientB() + ", supplimentaryExpiry=" + this.getSupplimentaryExpiry() + ", card=" + this.getCard() + ", empName=" + this.getEmpName() + ", bankC=" + this.getBankC() + ", personCode=" + this.getPersonCode() + ", supplementaryCvv2=" + this.getSupplementaryCvv2() + ", rCntry=" + this.getRCntry() + ", uCodl=" + this.getUCodl() + ", rCity=" + this.getRCity() + ", docSince=" + this.getDocSince() + ", fNames=" + this.getFNames() + ", notes=" + this.getNotes() + ", rStreet=" + this.getRStreet() + ", docName=" + this.getDocName() + ", docType=" + this.getDocType() + ", surname=" + this.getSurname() + ", supplimentaryPan=" + this.getSupplimentaryPan() + ", bDate=" + this.getBDate() + ", serialNo=" + this.getSerialNo() + ", issuedBy=" + this.getIssuedBy() + ", client=" + this.getClient() + ", rEMails=" + this.getREMails() + ", rPcode=" + this.getRPcode() + ", a3vtsFlag1=" + this.getA3vtsFlag1() + ", a3vtsFlag2=" + this.getA3vtsFlag2() + ", idCard=" + this.getIdCard() + ", status=" + this.getStatus() + ")";
    }
}
