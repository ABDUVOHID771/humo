package com.example.springhumo.model.dto.humo.response;

import com.example.springhumo.constant.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JacksonXmlRootElement(
        localName = "envelop"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class CheckPaymentResponseEnvelopDto {
    @JacksonXmlProperty(
            localName = "paymentID"
    )
    private Integer paymentId;
    @JacksonXmlProperty(
            localName = "details"
    )
    private CheckPaymentResponseEnvelopDto.Details details;
    @JacksonXmlProperty(
            localName = "status"
    )
    private PaymentStatus status;

    public Map<String, String> getItemsMap() {
        Map<String, String> resultMap = new HashMap();
        if (this.details != null && this.details.items != null) {
            resultMap = (Map) this.details.getItems().stream().collect(Collectors.toMap(CheckPaymentResponseEnvelopDto.Item::getName, CheckPaymentResponseEnvelopDto.Item::getValue));
        }

        return (Map) resultMap;
    }

    public CheckPaymentResponseEnvelopDto() {
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public CheckPaymentResponseEnvelopDto.Details getDetails() {
        return this.details;
    }

    public PaymentStatus getStatus() {
        return this.status;
    }

    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setDetails(final CheckPaymentResponseEnvelopDto.Details details) {
        this.details = details;
    }

    public void setStatus(final PaymentStatus status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CheckPaymentResponseEnvelopDto)) {
            return false;
        } else {
            CheckPaymentResponseEnvelopDto other = (CheckPaymentResponseEnvelopDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$paymentId = this.getPaymentId();
                    Object other$paymentId = other.getPaymentId();
                    if (this$paymentId == null) {
                        if (other$paymentId == null) {
                            break label47;
                        }
                    } else if (this$paymentId.equals(other$paymentId)) {
                        break label47;
                    }

                    return false;
                }

                Object this$details = this.getDetails();
                Object other$details = other.getDetails();
                if (this$details == null) {
                    if (other$details != null) {
                        return false;
                    }
                } else if (!this$details.equals(other$details)) {
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
        return other instanceof CheckPaymentResponseEnvelopDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $paymentId = this.getPaymentId();
        result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
        Object $details = this.getDetails();
        result = result * 59 + ($details == null ? 43 : $details.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "CheckPaymentResponseEnvelopDto(paymentId=" + this.getPaymentId() + ", details=" + this.getDetails() + ", status=" + this.getStatus() + ")";
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Item {
        private String name;
        private String value;

        public Item() {
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setValue(final String value) {
            this.value = value;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CheckPaymentResponseEnvelopDto.Item)) {
                return false;
            } else {
                CheckPaymentResponseEnvelopDto.Item other = (CheckPaymentResponseEnvelopDto.Item) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name != null) {
                            return false;
                        }
                    } else if (!this$name.equals(other$name)) {
                        return false;
                    }

                    Object this$value = this.getValue();
                    Object other$value = other.getValue();
                    if (this$value == null) {
                        if (other$value != null) {
                            return false;
                        }
                    } else if (!this$value.equals(other$value)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CheckPaymentResponseEnvelopDto.Item;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Object $value = this.getValue();
            result = result * 59 + ($value == null ? 43 : $value.hashCode());
            return result;
        }

        public String toString() {
            return "CheckPaymentResponseEnvelopDto.Item(name=" + this.getName() + ", value=" + this.getValue() + ")";
        }
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Details {
        @JacksonXmlProperty(
                localName = "item"
        )
        @JacksonXmlElementWrapper(
                useWrapping = false
        )
        private List<CheckPaymentResponseEnvelopDto.Item> items;

        public Details() {
        }

        public List<CheckPaymentResponseEnvelopDto.Item> getItems() {
            return this.items;
        }

        public void setItems(final List<CheckPaymentResponseEnvelopDto.Item> items) {
            this.items = items;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof CheckPaymentResponseEnvelopDto.Details)) {
                return false;
            } else {
                CheckPaymentResponseEnvelopDto.Details other = (CheckPaymentResponseEnvelopDto.Details) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
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
            return other instanceof CheckPaymentResponseEnvelopDto.Details;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $items = this.getItems();
            result = result * 59 + ($items == null ? 43 : $items.hashCode());
            return result;
        }

        public String toString() {
            return "CheckPaymentResponseEnvelopDto.Details(items=" + this.getItems() + ")";
        }
    }
}
