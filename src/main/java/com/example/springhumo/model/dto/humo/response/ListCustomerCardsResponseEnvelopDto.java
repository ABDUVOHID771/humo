package com.example.springhumo.model.dto.humo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Arrays;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ListCustomerCardsResponseEnvelopDto {
    @JacksonXmlProperty(
            localName = "Body"
    )
    private ListCustomerCardsResponseEnvelopDto.Body body;

    public ListCustomerCardsResponseEnvelopDto() {
    }

    public ListCustomerCardsResponseEnvelopDto.Body getBody() {
        return this.body;
    }

    public void setBody(final ListCustomerCardsResponseEnvelopDto.Body body) {
        this.body = body;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ListCustomerCardsResponseEnvelopDto)) {
            return false;
        } else {
            ListCustomerCardsResponseEnvelopDto other = (ListCustomerCardsResponseEnvelopDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$body = this.getBody();
                Object other$body = other.getBody();
                if (this$body == null) {
                    if (other$body != null) {
                        return false;
                    }
                } else if (!this$body.equals(other$body)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ListCustomerCardsResponseEnvelopDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $body = this.getBody();
        result = result * 59 + ($body == null ? 43 : $body.hashCode());
        return result;
    }

    public String toString() {
        return "ListCustomerCardsResponseEnvelopDto(body=" + this.getBody() + ")";
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class ListCustomerCardsResponseDetails {
        @JacksonXmlProperty(
                localName = "ResponseInfo"
        )
        private JsonNode responseInfo;
        @JacksonXmlProperty(
                localName = "Details"
        )
        private JsonNode details;

        public ListCustomerCardsResponseDetails() {
        }

        public JsonNode getResponseInfo() {
            return this.responseInfo;
        }

        public JsonNode getDetails() {
            return this.details;
        }

        public void setResponseInfo(final JsonNode responseInfo) {
            this.responseInfo = responseInfo;
        }

        public void setDetails(final JsonNode details) {
            this.details = details;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails)) {
                return false;
            } else {
                ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails other = (ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$responseInfo = this.getResponseInfo();
                    Object other$responseInfo = other.getResponseInfo();
                    if (this$responseInfo == null) {
                        if (other$responseInfo != null) {
                            return false;
                        }
                    } else if (!this$responseInfo.equals(other$responseInfo)) {
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

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $responseInfo = this.getResponseInfo();
            result = result * 59 + ($responseInfo == null ? 43 : $responseInfo.hashCode());
            Object $details = this.getDetails();
            result = result * 59 + ($details == null ? 43 : $details.hashCode());
            return result;
        }

        public String toString() {
            return "ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails(responseInfo=" + this.getResponseInfo() + ", details=" + this.getDetails() + ")";
        }
    }

    public static class Body {
        @JacksonXmlProperty(
                localName = "listCustomerCardsResponse"
        )
        private ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails listCustomersResponse;
        @JacksonXmlProperty(
                localName = "multiRef"
        )
        @JacksonXmlElementWrapper(
                useWrapping = false
        )
        private JsonNode[] multiRef;

        public Body() {
        }

        public ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails getListCustomersResponse() {
            return this.listCustomersResponse;
        }

        public JsonNode[] getMultiRef() {
            return this.multiRef;
        }

        public void setListCustomersResponse(final ListCustomerCardsResponseEnvelopDto.ListCustomerCardsResponseDetails listCustomersResponse) {
            this.listCustomersResponse = listCustomersResponse;
        }

        public void setMultiRef(final JsonNode[] multiRef) {
            this.multiRef = multiRef;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof ListCustomerCardsResponseEnvelopDto.Body)) {
                return false;
            } else {
                ListCustomerCardsResponseEnvelopDto.Body other = (ListCustomerCardsResponseEnvelopDto.Body) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$listCustomersResponse = this.getListCustomersResponse();
                    Object other$listCustomersResponse = other.getListCustomersResponse();
                    if (this$listCustomersResponse == null) {
                        if (other$listCustomersResponse == null) {
                            return Arrays.deepEquals(this.getMultiRef(), other.getMultiRef());
                        }
                    } else if (this$listCustomersResponse.equals(other$listCustomersResponse)) {
                        return Arrays.deepEquals(this.getMultiRef(), other.getMultiRef());
                    }

                    return false;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ListCustomerCardsResponseEnvelopDto.Body;
        }

        public int hashCode() {
            int PRIME = 1;//true
            int result = 1;
            Object $listCustomersResponse = this.getListCustomersResponse();
            result = result * 59 + ($listCustomersResponse == null ? 43 : $listCustomersResponse.hashCode());
            result = result * 59 + Arrays.deepHashCode(this.getMultiRef());
            return result;
        }

        public String toString() {
            return "ListCustomerCardsResponseEnvelopDto.Body(listCustomersResponse=" + this.getListCustomersResponse() + ", multiRef=" + Arrays.deepToString(this.getMultiRef()) + ")";
        }
    }
}
