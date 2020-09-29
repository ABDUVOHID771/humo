package com.example.springhumo.model.dto.humo.response;

import com.example.springhumo.util.CardUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardHistoryResponseDto {
    @JsonProperty("REC_DATE")
    private String recDate;
    @JsonProperty("LOCKING_FLAG")
    private String lockingFlag;
    @JsonProperty("POINT_CODE")
    private String pointCode;
    @JsonProperty("EXP_DATE")
    private String expDate;
    @JsonProperty("CTIME")
    private String cTime;
    @JsonProperty("TRAN_TYPE")
    private String tranType;
    @JsonProperty("INTERNAL_NO")
    private String internalNo;
    @JsonProperty("CARD")
    private String card;
    @JsonProperty("APR_CODE")
    private String aprCode;
    @JsonProperty("MERCHANT")
    private String merchant;
    @JsonProperty("TRAN_AMT")
    private String tranAmount;
    @JsonProperty("MCC_CODE")
    private String mccCode;
    @JsonProperty("GROUPC")
    private String groupC;
    @JsonProperty("COUNTRY")
    private String country;
    @JsonProperty("CARD_ACCT")
    private String cardAcct;
    @JsonProperty("ADD_INFO")
    private String addInfo;
    @JsonProperty("ACCNT_CCY")
    private String accntCcy;
    @JsonProperty("COUNTERPARTY")
    private String counterParty;
    @JsonProperty("BANK_C")
    private String bankC;
    @JsonProperty("AMOUNT_NET")
    private String amountNet;
    @JsonProperty("DEAL_DESC")
    private String dealDesc;
    @JsonProperty("POST_DATE")
    private String postDate;
    @JsonProperty("TR_CODE")
    private String trCode;
    @JsonProperty("CCY_EXP")
    private String ccyExp;
    @JsonProperty("TRAN_CCY")
    private String tranCcy;
    @JsonProperty("TR_FEE")
    private String trFee;
    @JsonProperty("TRAN_DATE_TIME")
    private String tranDateTime;
    @JsonProperty("STAN")
    private String stan;
    @JsonProperty("CLIENT")
    private String client;
    @JsonProperty("APR_SCR")
    private String aprScr;
    @JsonProperty("CITY")
    private String city;
    @JsonProperty("CL_ACCT_KEY")
    private String clAccntKey;
    @JsonProperty("TR_CODE2")
    private String trCode2;
    @JsonProperty("TR_FEE2")
    private String trFee2;
    @JsonProperty("FLD_104")
    private String fld104;
    @JsonProperty("ACCOUNT_NO")
    private String accountNo;
    @JsonProperty("ACQREF_NR")
    private String acqrefNr;
    @JsonProperty("ABVR_NAME")
    private String abvrName;
    @JsonProperty("TERM_ID")
    private String termId;

    public CardHistoryResponseDto(List<Map> items, List<Map> multiref) {
        List<String> keys = (List) items.stream().map((map) -> {
            return map.get("href").toString().replaceAll("#", "");
        }).collect(Collectors.toList());
        System.out.println(keys);
        Map keyAndValue = (Map) multiref.stream().filter((map) -> {
            return keys.contains(map.get("id")) && map.get("value") != null && ((Map) map.get("value")).get("content") != null;
        }).collect(Collectors.toMap((o) -> {
            return ((Map) o.get("name")).get("content");
        }, (o) -> {
            return ((Map) o.get("value")).get("content");
        }));
        this.recDate = keyAndValue.getOrDefault("REC_DATE", "").toString();
        this.lockingFlag = keyAndValue.getOrDefault("LOCKING_FLAG", "").toString();
        this.pointCode = keyAndValue.getOrDefault("POINT_CODE", "").toString();
        this.expDate = keyAndValue.getOrDefault("EXP_DATE", "").toString();
        this.cTime = keyAndValue.getOrDefault("CTIME", "").toString();
        this.tranType = keyAndValue.getOrDefault("TRAN_TYPE", "").toString();
        this.internalNo = keyAndValue.getOrDefault("INTERNAL_NO", "").toString();
        this.card = keyAndValue.getOrDefault("CARD", "").toString();
        this.card = CardUtil.maskPan(this.card);
        this.aprCode = keyAndValue.getOrDefault("APR_CODE", "").toString();
        this.merchant = keyAndValue.getOrDefault("MERCHANT", "").toString();
        this.tranAmount = keyAndValue.getOrDefault("TRAN_AMT", "").toString();
        this.mccCode = keyAndValue.getOrDefault("MCC_CODE", "").toString();
        this.groupC = keyAndValue.getOrDefault("GROUPC", "").toString();
        this.country = keyAndValue.getOrDefault("COUNTRY", "").toString();
        this.cardAcct = keyAndValue.getOrDefault("CARD_ACCT", "").toString();
        this.addInfo = keyAndValue.getOrDefault("ADD_INFO", "").toString();
        this.accntCcy = keyAndValue.getOrDefault("ACCNT_CCY", "").toString();
        this.counterParty = keyAndValue.getOrDefault("COUNTERPARTY", "").toString();
        this.bankC = keyAndValue.getOrDefault("BANK_C", "").toString();
        this.amountNet = keyAndValue.getOrDefault("AMOUNT_NET", "").toString();
        this.dealDesc = keyAndValue.getOrDefault("DEAL_DESC", "").toString();
        this.postDate = keyAndValue.getOrDefault("POST_DATE", "").toString();
        this.trCode = keyAndValue.getOrDefault("TR_CODE", "").toString();
        this.ccyExp = keyAndValue.getOrDefault("CCY_EXP", "").toString();
        this.tranCcy = keyAndValue.getOrDefault("TRAN_CCY", "").toString();
        this.trFee = keyAndValue.getOrDefault("TR_FEE", "").toString();
        this.tranDateTime = keyAndValue.getOrDefault("TRAN_DATE_TIME", "").toString();
        this.stan = keyAndValue.getOrDefault("STAN", "").toString();
        this.client = keyAndValue.getOrDefault("CLIENT", "").toString();
        this.aprScr = keyAndValue.getOrDefault("APR_SCR", "").toString();
        this.city = keyAndValue.getOrDefault("CITY", "").toString();
        this.clAccntKey = keyAndValue.getOrDefault("CL_ACCT_KEY", "").toString();
        this.trCode2 = keyAndValue.getOrDefault("TR_CODE2", "").toString();
        this.trFee2 = keyAndValue.getOrDefault("TR_FEE2", "").toString();
        this.fld104 = keyAndValue.getOrDefault("FLD_104", "").toString();
        this.accountNo = keyAndValue.getOrDefault("ACCOUNT_NO", "").toString();
        this.acqrefNr = keyAndValue.getOrDefault("ACQREF_NR", "").toString();
        this.abvrName = keyAndValue.getOrDefault("ABVR_NAME", "").toString();
        this.termId = keyAndValue.getOrDefault("TERM_ID", "").toString();
    }

    public String getRecDate() {
        return this.recDate;
    }

    public String getLockingFlag() {
        return this.lockingFlag;
    }

    public String getPointCode() {
        return this.pointCode;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public String getCTime() {
        return this.cTime;
    }

    public String getTranType() {
        return this.tranType;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public String getCard() {
        return this.card;
    }

    public String getAprCode() {
        return this.aprCode;
    }

    public String getMerchant() {
        return this.merchant;
    }

    public String getTranAmount() {
        return this.tranAmount;
    }

    public String getMccCode() {
        return this.mccCode;
    }

    public String getGroupC() {
        return this.groupC;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCardAcct() {
        return this.cardAcct;
    }

    public String getAddInfo() {
        return this.addInfo;
    }

    public String getAccntCcy() {
        return this.accntCcy;
    }

    public String getCounterParty() {
        return this.counterParty;
    }

    public String getBankC() {
        return this.bankC;
    }

    public String getAmountNet() {
        return this.amountNet;
    }

    public String getDealDesc() {
        return this.dealDesc;
    }

    public String getPostDate() {
        return this.postDate;
    }

    public String getTrCode() {
        return this.trCode;
    }

    public String getCcyExp() {
        return this.ccyExp;
    }

    public String getTranCcy() {
        return this.tranCcy;
    }

    public String getTrFee() {
        return this.trFee;
    }

    public String getTranDateTime() {
        return this.tranDateTime;
    }

    public String getStan() {
        return this.stan;
    }

    public String getClient() {
        return this.client;
    }

    public String getAprScr() {
        return this.aprScr;
    }

    public String getCity() {
        return this.city;
    }

    public String getClAccntKey() {
        return this.clAccntKey;
    }

    public String getTrCode2() {
        return this.trCode2;
    }

    public String getTrFee2() {
        return this.trFee2;
    }

    public String getFld104() {
        return this.fld104;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public String getAcqrefNr() {
        return this.acqrefNr;
    }

    public String getAbvrName() {
        return this.abvrName;
    }

    public String getTermId() {
        return this.termId;
    }

    @JsonProperty("REC_DATE")
    public void setRecDate(final String recDate) {
        this.recDate = recDate;
    }

    @JsonProperty("LOCKING_FLAG")
    public void setLockingFlag(final String lockingFlag) {
        this.lockingFlag = lockingFlag;
    }

    @JsonProperty("POINT_CODE")
    public void setPointCode(final String pointCode) {
        this.pointCode = pointCode;
    }

    @JsonProperty("EXP_DATE")
    public void setExpDate(final String expDate) {
        this.expDate = expDate;
    }

    @JsonProperty("CTIME")
    public void setCTime(final String cTime) {
        this.cTime = cTime;
    }

    @JsonProperty("TRAN_TYPE")
    public void setTranType(final String tranType) {
        this.tranType = tranType;
    }

    @JsonProperty("INTERNAL_NO")
    public void setInternalNo(final String internalNo) {
        this.internalNo = internalNo;
    }

    @JsonProperty("CARD")
    public void setCard(final String card) {
        this.card = card;
    }

    @JsonProperty("APR_CODE")
    public void setAprCode(final String aprCode) {
        this.aprCode = aprCode;
    }

    @JsonProperty("MERCHANT")
    public void setMerchant(final String merchant) {
        this.merchant = merchant;
    }

    @JsonProperty("TRAN_AMT")
    public void setTranAmount(final String tranAmount) {
        this.tranAmount = tranAmount;
    }

    @JsonProperty("MCC_CODE")
    public void setMccCode(final String mccCode) {
        this.mccCode = mccCode;
    }

    @JsonProperty("GROUPC")
    public void setGroupC(final String groupC) {
        this.groupC = groupC;
    }

    @JsonProperty("COUNTRY")
    public void setCountry(final String country) {
        this.country = country;
    }

    @JsonProperty("CARD_ACCT")
    public void setCardAcct(final String cardAcct) {
        this.cardAcct = cardAcct;
    }

    @JsonProperty("ADD_INFO")
    public void setAddInfo(final String addInfo) {
        this.addInfo = addInfo;
    }

    @JsonProperty("ACCNT_CCY")
    public void setAccntCcy(final String accntCcy) {
        this.accntCcy = accntCcy;
    }

    @JsonProperty("COUNTERPARTY")
    public void setCounterParty(final String counterParty) {
        this.counterParty = counterParty;
    }

    @JsonProperty("BANK_C")
    public void setBankC(final String bankC) {
        this.bankC = bankC;
    }

    @JsonProperty("AMOUNT_NET")
    public void setAmountNet(final String amountNet) {
        this.amountNet = amountNet;
    }

    @JsonProperty("DEAL_DESC")
    public void setDealDesc(final String dealDesc) {
        this.dealDesc = dealDesc;
    }

    @JsonProperty("POST_DATE")
    public void setPostDate(final String postDate) {
        this.postDate = postDate;
    }

    @JsonProperty("TR_CODE")
    public void setTrCode(final String trCode) {
        this.trCode = trCode;
    }

    @JsonProperty("CCY_EXP")
    public void setCcyExp(final String ccyExp) {
        this.ccyExp = ccyExp;
    }

    @JsonProperty("TRAN_CCY")
    public void setTranCcy(final String tranCcy) {
        this.tranCcy = tranCcy;
    }

    @JsonProperty("TR_FEE")
    public void setTrFee(final String trFee) {
        this.trFee = trFee;
    }

    @JsonProperty("TRAN_DATE_TIME")
    public void setTranDateTime(final String tranDateTime) {
        this.tranDateTime = tranDateTime;
    }

    @JsonProperty("STAN")
    public void setStan(final String stan) {
        this.stan = stan;
    }

    @JsonProperty("CLIENT")
    public void setClient(final String client) {
        this.client = client;
    }

    @JsonProperty("APR_SCR")
    public void setAprScr(final String aprScr) {
        this.aprScr = aprScr;
    }

    @JsonProperty("CITY")
    public void setCity(final String city) {
        this.city = city;
    }

    @JsonProperty("CL_ACCT_KEY")
    public void setClAccntKey(final String clAccntKey) {
        this.clAccntKey = clAccntKey;
    }

    @JsonProperty("TR_CODE2")
    public void setTrCode2(final String trCode2) {
        this.trCode2 = trCode2;
    }

    @JsonProperty("TR_FEE2")
    public void setTrFee2(final String trFee2) {
        this.trFee2 = trFee2;
    }

    @JsonProperty("FLD_104")
    public void setFld104(final String fld104) {
        this.fld104 = fld104;
    }

    @JsonProperty("ACCOUNT_NO")
    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    @JsonProperty("ACQREF_NR")
    public void setAcqrefNr(final String acqrefNr) {
        this.acqrefNr = acqrefNr;
    }

    @JsonProperty("ABVR_NAME")
    public void setAbvrName(final String abvrName) {
        this.abvrName = abvrName;
    }

    @JsonProperty("TERM_ID")
    public void setTermId(final String termId) {
        this.termId = termId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardHistoryResponseDto)) {
            return false;
        } else {
            CardHistoryResponseDto other = (CardHistoryResponseDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label479:
                {
                    Object this$recDate = this.getRecDate();
                    Object other$recDate = other.getRecDate();
                    if (this$recDate == null) {
                        if (other$recDate == null) {
                            break label479;
                        }
                    } else if (this$recDate.equals(other$recDate)) {
                        break label479;
                    }

                    return false;
                }

                Object this$lockingFlag = this.getLockingFlag();
                Object other$lockingFlag = other.getLockingFlag();
                if (this$lockingFlag == null) {
                    if (other$lockingFlag != null) {
                        return false;
                    }
                } else if (!this$lockingFlag.equals(other$lockingFlag)) {
                    return false;
                }

                Object this$pointCode = this.getPointCode();
                Object other$pointCode = other.getPointCode();
                if (this$pointCode == null) {
                    if (other$pointCode != null) {
                        return false;
                    }
                } else if (!this$pointCode.equals(other$pointCode)) {
                    return false;
                }

                label458:
                {
                    Object this$expDate = this.getExpDate();
                    Object other$expDate = other.getExpDate();
                    if (this$expDate == null) {
                        if (other$expDate == null) {
                            break label458;
                        }
                    } else if (this$expDate.equals(other$expDate)) {
                        break label458;
                    }

                    return false;
                }

                label451:
                {
                    Object this$cTime = this.getCTime();
                    Object other$cTime = other.getCTime();
                    if (this$cTime == null) {
                        if (other$cTime == null) {
                            break label451;
                        }
                    } else if (this$cTime.equals(other$cTime)) {
                        break label451;
                    }

                    return false;
                }

                Object this$tranType = this.getTranType();
                Object other$tranType = other.getTranType();
                if (this$tranType == null) {
                    if (other$tranType != null) {
                        return false;
                    }
                } else if (!this$tranType.equals(other$tranType)) {
                    return false;
                }

                Object this$internalNo = this.getInternalNo();
                Object other$internalNo = other.getInternalNo();
                if (this$internalNo == null) {
                    if (other$internalNo != null) {
                        return false;
                    }
                } else if (!this$internalNo.equals(other$internalNo)) {
                    return false;
                }

                label430:
                {
                    Object this$card = this.getCard();
                    Object other$card = other.getCard();
                    if (this$card == null) {
                        if (other$card == null) {
                            break label430;
                        }
                    } else if (this$card.equals(other$card)) {
                        break label430;
                    }

                    return false;
                }

                label423:
                {
                    Object this$aprCode = this.getAprCode();
                    Object other$aprCode = other.getAprCode();
                    if (this$aprCode == null) {
                        if (other$aprCode == null) {
                            break label423;
                        }
                    } else if (this$aprCode.equals(other$aprCode)) {
                        break label423;
                    }

                    return false;
                }

                Object this$merchant = this.getMerchant();
                Object other$merchant = other.getMerchant();
                if (this$merchant == null) {
                    if (other$merchant != null) {
                        return false;
                    }
                } else if (!this$merchant.equals(other$merchant)) {
                    return false;
                }

                label409:
                {
                    Object this$tranAmount = this.getTranAmount();
                    Object other$tranAmount = other.getTranAmount();
                    if (this$tranAmount == null) {
                        if (other$tranAmount == null) {
                            break label409;
                        }
                    } else if (this$tranAmount.equals(other$tranAmount)) {
                        break label409;
                    }

                    return false;
                }

                Object this$mccCode = this.getMccCode();
                Object other$mccCode = other.getMccCode();
                if (this$mccCode == null) {
                    if (other$mccCode != null) {
                        return false;
                    }
                } else if (!this$mccCode.equals(other$mccCode)) {
                    return false;
                }

                label395:
                {
                    Object this$groupC = this.getGroupC();
                    Object other$groupC = other.getGroupC();
                    if (this$groupC == null) {
                        if (other$groupC == null) {
                            break label395;
                        }
                    } else if (this$groupC.equals(other$groupC)) {
                        break label395;
                    }

                    return false;
                }

                Object this$country = this.getCountry();
                Object other$country = other.getCountry();
                if (this$country == null) {
                    if (other$country != null) {
                        return false;
                    }
                } else if (!this$country.equals(other$country)) {
                    return false;
                }

                Object this$cardAcct = this.getCardAcct();
                Object other$cardAcct = other.getCardAcct();
                if (this$cardAcct == null) {
                    if (other$cardAcct != null) {
                        return false;
                    }
                } else if (!this$cardAcct.equals(other$cardAcct)) {
                    return false;
                }

                label374:
                {
                    Object this$addInfo = this.getAddInfo();
                    Object other$addInfo = other.getAddInfo();
                    if (this$addInfo == null) {
                        if (other$addInfo == null) {
                            break label374;
                        }
                    } else if (this$addInfo.equals(other$addInfo)) {
                        break label374;
                    }

                    return false;
                }

                label367:
                {
                    Object this$accntCcy = this.getAccntCcy();
                    Object other$accntCcy = other.getAccntCcy();
                    if (this$accntCcy == null) {
                        if (other$accntCcy == null) {
                            break label367;
                        }
                    } else if (this$accntCcy.equals(other$accntCcy)) {
                        break label367;
                    }

                    return false;
                }

                Object this$counterParty = this.getCounterParty();
                Object other$counterParty = other.getCounterParty();
                if (this$counterParty == null) {
                    if (other$counterParty != null) {
                        return false;
                    }
                } else if (!this$counterParty.equals(other$counterParty)) {
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

                label346:
                {
                    Object this$amountNet = this.getAmountNet();
                    Object other$amountNet = other.getAmountNet();
                    if (this$amountNet == null) {
                        if (other$amountNet == null) {
                            break label346;
                        }
                    } else if (this$amountNet.equals(other$amountNet)) {
                        break label346;
                    }

                    return false;
                }

                label339:
                {
                    Object this$dealDesc = this.getDealDesc();
                    Object other$dealDesc = other.getDealDesc();
                    if (this$dealDesc == null) {
                        if (other$dealDesc == null) {
                            break label339;
                        }
                    } else if (this$dealDesc.equals(other$dealDesc)) {
                        break label339;
                    }

                    return false;
                }

                Object this$postDate = this.getPostDate();
                Object other$postDate = other.getPostDate();
                if (this$postDate == null) {
                    if (other$postDate != null) {
                        return false;
                    }
                } else if (!this$postDate.equals(other$postDate)) {
                    return false;
                }

                Object this$trCode = this.getTrCode();
                Object other$trCode = other.getTrCode();
                if (this$trCode == null) {
                    if (other$trCode != null) {
                        return false;
                    }
                } else if (!this$trCode.equals(other$trCode)) {
                    return false;
                }

                label318:
                {
                    Object this$ccyExp = this.getCcyExp();
                    Object other$ccyExp = other.getCcyExp();
                    if (this$ccyExp == null) {
                        if (other$ccyExp == null) {
                            break label318;
                        }
                    } else if (this$ccyExp.equals(other$ccyExp)) {
                        break label318;
                    }

                    return false;
                }

                label311:
                {
                    Object this$tranCcy = this.getTranCcy();
                    Object other$tranCcy = other.getTranCcy();
                    if (this$tranCcy == null) {
                        if (other$tranCcy == null) {
                            break label311;
                        }
                    } else if (this$tranCcy.equals(other$tranCcy)) {
                        break label311;
                    }

                    return false;
                }

                Object this$trFee = this.getTrFee();
                Object other$trFee = other.getTrFee();
                if (this$trFee == null) {
                    if (other$trFee != null) {
                        return false;
                    }
                } else if (!this$trFee.equals(other$trFee)) {
                    return false;
                }

                label297:
                {
                    Object this$tranDateTime = this.getTranDateTime();
                    Object other$tranDateTime = other.getTranDateTime();
                    if (this$tranDateTime == null) {
                        if (other$tranDateTime == null) {
                            break label297;
                        }
                    } else if (this$tranDateTime.equals(other$tranDateTime)) {
                        break label297;
                    }

                    return false;
                }

                Object this$stan = this.getStan();
                Object other$stan = other.getStan();
                if (this$stan == null) {
                    if (other$stan != null) {
                        return false;
                    }
                } else if (!this$stan.equals(other$stan)) {
                    return false;
                }

                label283:
                {
                    Object this$client = this.getClient();
                    Object other$client = other.getClient();
                    if (this$client == null) {
                        if (other$client == null) {
                            break label283;
                        }
                    } else if (this$client.equals(other$client)) {
                        break label283;
                    }

                    return false;
                }

                Object this$aprScr = this.getAprScr();
                Object other$aprScr = other.getAprScr();
                if (this$aprScr == null) {
                    if (other$aprScr != null) {
                        return false;
                    }
                } else if (!this$aprScr.equals(other$aprScr)) {
                    return false;
                }

                Object this$city = this.getCity();
                Object other$city = other.getCity();
                if (this$city == null) {
                    if (other$city != null) {
                        return false;
                    }
                } else if (!this$city.equals(other$city)) {
                    return false;
                }

                label262:
                {
                    Object this$clAccntKey = this.getClAccntKey();
                    Object other$clAccntKey = other.getClAccntKey();
                    if (this$clAccntKey == null) {
                        if (other$clAccntKey == null) {
                            break label262;
                        }
                    } else if (this$clAccntKey.equals(other$clAccntKey)) {
                        break label262;
                    }

                    return false;
                }

                label255:
                {
                    Object this$trCode2 = this.getTrCode2();
                    Object other$trCode2 = other.getTrCode2();
                    if (this$trCode2 == null) {
                        if (other$trCode2 == null) {
                            break label255;
                        }
                    } else if (this$trCode2.equals(other$trCode2)) {
                        break label255;
                    }

                    return false;
                }

                Object this$trFee2 = this.getTrFee2();
                Object other$trFee2 = other.getTrFee2();
                if (this$trFee2 == null) {
                    if (other$trFee2 != null) {
                        return false;
                    }
                } else if (!this$trFee2.equals(other$trFee2)) {
                    return false;
                }

                Object this$fld104 = this.getFld104();
                Object other$fld104 = other.getFld104();
                if (this$fld104 == null) {
                    if (other$fld104 != null) {
                        return false;
                    }
                } else if (!this$fld104.equals(other$fld104)) {
                    return false;
                }

                label234:
                {
                    Object this$accountNo = this.getAccountNo();
                    Object other$accountNo = other.getAccountNo();
                    if (this$accountNo == null) {
                        if (other$accountNo == null) {
                            break label234;
                        }
                    } else if (this$accountNo.equals(other$accountNo)) {
                        break label234;
                    }

                    return false;
                }

                label227:
                {
                    Object this$acqrefNr = this.getAcqrefNr();
                    Object other$acqrefNr = other.getAcqrefNr();
                    if (this$acqrefNr == null) {
                        if (other$acqrefNr == null) {
                            break label227;
                        }
                    } else if (this$acqrefNr.equals(other$acqrefNr)) {
                        break label227;
                    }

                    return false;
                }

                Object this$abvrName = this.getAbvrName();
                Object other$abvrName = other.getAbvrName();
                if (this$abvrName == null) {
                    if (other$abvrName != null) {
                        return false;
                    }
                } else if (!this$abvrName.equals(other$abvrName)) {
                    return false;
                }

                Object this$termId = this.getTermId();
                Object other$termId = other.getTermId();
                if (this$termId == null) {
                    if (other$termId != null) {
                        return false;
                    }
                } else if (!this$termId.equals(other$termId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardHistoryResponseDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $recDate = this.getRecDate();
        result = result * 59 + ($recDate == null ? 43 : $recDate.hashCode());
        Object $lockingFlag = this.getLockingFlag();
        result = result * 59 + ($lockingFlag == null ? 43 : $lockingFlag.hashCode());
        Object $pointCode = this.getPointCode();
        result = result * 59 + ($pointCode == null ? 43 : $pointCode.hashCode());
        Object $expDate = this.getExpDate();
        result = result * 59 + ($expDate == null ? 43 : $expDate.hashCode());
        Object $cTime = this.getCTime();
        result = result * 59 + ($cTime == null ? 43 : $cTime.hashCode());
        Object $tranType = this.getTranType();
        result = result * 59 + ($tranType == null ? 43 : $tranType.hashCode());
        Object $internalNo = this.getInternalNo();
        result = result * 59 + ($internalNo == null ? 43 : $internalNo.hashCode());
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        Object $aprCode = this.getAprCode();
        result = result * 59 + ($aprCode == null ? 43 : $aprCode.hashCode());
        Object $merchant = this.getMerchant();
        result = result * 59 + ($merchant == null ? 43 : $merchant.hashCode());
        Object $tranAmount = this.getTranAmount();
        result = result * 59 + ($tranAmount == null ? 43 : $tranAmount.hashCode());
        Object $mccCode = this.getMccCode();
        result = result * 59 + ($mccCode == null ? 43 : $mccCode.hashCode());
        Object $groupC = this.getGroupC();
        result = result * 59 + ($groupC == null ? 43 : $groupC.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $cardAcct = this.getCardAcct();
        result = result * 59 + ($cardAcct == null ? 43 : $cardAcct.hashCode());
        Object $addInfo = this.getAddInfo();
        result = result * 59 + ($addInfo == null ? 43 : $addInfo.hashCode());
        Object $accntCcy = this.getAccntCcy();
        result = result * 59 + ($accntCcy == null ? 43 : $accntCcy.hashCode());
        Object $counterParty = this.getCounterParty();
        result = result * 59 + ($counterParty == null ? 43 : $counterParty.hashCode());
        Object $bankC = this.getBankC();
        result = result * 59 + ($bankC == null ? 43 : $bankC.hashCode());
        Object $amountNet = this.getAmountNet();
        result = result * 59 + ($amountNet == null ? 43 : $amountNet.hashCode());
        Object $dealDesc = this.getDealDesc();
        result = result * 59 + ($dealDesc == null ? 43 : $dealDesc.hashCode());
        Object $postDate = this.getPostDate();
        result = result * 59 + ($postDate == null ? 43 : $postDate.hashCode());
        Object $trCode = this.getTrCode();
        result = result * 59 + ($trCode == null ? 43 : $trCode.hashCode());
        Object $ccyExp = this.getCcyExp();
        result = result * 59 + ($ccyExp == null ? 43 : $ccyExp.hashCode());
        Object $tranCcy = this.getTranCcy();
        result = result * 59 + ($tranCcy == null ? 43 : $tranCcy.hashCode());
        Object $trFee = this.getTrFee();
        result = result * 59 + ($trFee == null ? 43 : $trFee.hashCode());
        Object $tranDateTime = this.getTranDateTime();
        result = result * 59 + ($tranDateTime == null ? 43 : $tranDateTime.hashCode());
        Object $stan = this.getStan();
        result = result * 59 + ($stan == null ? 43 : $stan.hashCode());
        Object $client = this.getClient();
        result = result * 59 + ($client == null ? 43 : $client.hashCode());
        Object $aprScr = this.getAprScr();
        result = result * 59 + ($aprScr == null ? 43 : $aprScr.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $clAccntKey = this.getClAccntKey();
        result = result * 59 + ($clAccntKey == null ? 43 : $clAccntKey.hashCode());
        Object $trCode2 = this.getTrCode2();
        result = result * 59 + ($trCode2 == null ? 43 : $trCode2.hashCode());
        Object $trFee2 = this.getTrFee2();
        result = result * 59 + ($trFee2 == null ? 43 : $trFee2.hashCode());
        Object $fld104 = this.getFld104();
        result = result * 59 + ($fld104 == null ? 43 : $fld104.hashCode());
        Object $accountNo = this.getAccountNo();
        result = result * 59 + ($accountNo == null ? 43 : $accountNo.hashCode());
        Object $acqrefNr = this.getAcqrefNr();
        result = result * 59 + ($acqrefNr == null ? 43 : $acqrefNr.hashCode());
        Object $abvrName = this.getAbvrName();
        result = result * 59 + ($abvrName == null ? 43 : $abvrName.hashCode());
        Object $termId = this.getTermId();
        result = result * 59 + ($termId == null ? 43 : $termId.hashCode());
        return result;
    }

    public String toString() {
        return "CardHistoryResponseDto(recDate=" + this.getRecDate() + ", lockingFlag=" + this.getLockingFlag() + ", pointCode=" + this.getPointCode() + ", expDate=" + this.getExpDate() + ", cTime=" + this.getCTime() + ", tranType=" + this.getTranType() + ", internalNo=" + this.getInternalNo() + ", card=" + this.getCard() + ", aprCode=" + this.getAprCode() + ", merchant=" + this.getMerchant() + ", tranAmount=" + this.getTranAmount() + ", mccCode=" + this.getMccCode() + ", groupC=" + this.getGroupC() + ", country=" + this.getCountry() + ", cardAcct=" + this.getCardAcct() + ", addInfo=" + this.getAddInfo() + ", accntCcy=" + this.getAccntCcy() + ", counterParty=" + this.getCounterParty() + ", bankC=" + this.getBankC() + ", amountNet=" + this.getAmountNet() + ", dealDesc=" + this.getDealDesc() + ", postDate=" + this.getPostDate() + ", trCode=" + this.getTrCode() + ", ccyExp=" + this.getCcyExp() + ", tranCcy=" + this.getTranCcy() + ", trFee=" + this.getTrFee() + ", tranDateTime=" + this.getTranDateTime() + ", stan=" + this.getStan() + ", client=" + this.getClient() + ", aprScr=" + this.getAprScr() + ", city=" + this.getCity() + ", clAccntKey=" + this.getClAccntKey() + ", trCode2=" + this.getTrCode2() + ", trFee2=" + this.getTrFee2() + ", fld104=" + this.getFld104() + ", accountNo=" + this.getAccountNo() + ", acqrefNr=" + this.getAcqrefNr() + ", abvrName=" + this.getAbvrName() + ", termId=" + this.getTermId() + ")";
    }
}
