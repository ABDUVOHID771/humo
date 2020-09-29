package com.example.springhumo.model.dto.uzCard;

public class CardsNewParam {
    private CardsNewParam.Card card;

    public CardsNewParam() {
    }

    public CardsNewParam.Card getCard() {
        return this.card;
    }

    public void setCard(final CardsNewParam.Card card) {
        this.card = card;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardsNewParam)) {
            return false;
        } else {
            CardsNewParam other = (CardsNewParam) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$card = this.getCard();
                Object other$card = other.getCard();
                if (this$card == null) {
                    if (other$card != null) {
                        return false;
                    }
                } else if (!this$card.equals(other$card)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardsNewParam;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        return result;
    }

    public String toString() {
        return "CardsNewParam(card=" + this.getCard() + ")";
    }

    public static class Card {
        private String pan;
        private String expiry;

        public Card() {
        }

        public String getPan() {
            return this.pan;
        }

        public String getExpiry() {
            return this.expiry;
        }

        public void setPan(final String pan) {
            this.pan = pan;
        }

        public void setExpiry(final String expiry) {
            this.expiry = expiry;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CardsNewParam.Card)) {
                return false;
            } else {
                CardsNewParam.Card other = (CardsNewParam.Card) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$pan = this.getPan();
                    Object other$pan = other.getPan();
                    if (this$pan == null) {
                        if (other$pan != null) {
                            return false;
                        }
                    } else if (!this$pan.equals(other$pan)) {
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

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CardsNewParam.Card;
        }

        public int hashCode() {
            int PRIME = 1;// true
            int result = 1;
            Object $pan = this.getPan();
            result = result * 59 + ($pan == null ? 43 : $pan.hashCode());
            Object $expiry = this.getExpiry();
            result = result * 59 + ($expiry == null ? 43 : $expiry.hashCode());
            return result;
        }

        public String toString() {
            return "CardsNewParam.Card(pan=" + this.getPan() + ", expiry=" + this.getExpiry() + ")";
        }
    }
}
