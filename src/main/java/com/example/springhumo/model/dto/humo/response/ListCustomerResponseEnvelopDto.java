package com.example.springhumo.model.dto.humo.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Arrays;

public class ListCustomerResponseEnvelopDto {
    @JacksonXmlProperty(
            localName = "Body"
    )
    private ListCustomerResponseEnvelopDto.Body body;

    public ListCustomerResponseEnvelopDto() {
    }

    public ListCustomerResponseEnvelopDto.Body getBody() {
        return this.body;
    }

    public void setBody(final ListCustomerResponseEnvelopDto.Body body) {
        this.body = body;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ListCustomerResponseEnvelopDto)) {
            return false;
        } else {
            ListCustomerResponseEnvelopDto other = (ListCustomerResponseEnvelopDto) o;
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
        return other instanceof ListCustomerResponseEnvelopDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $body = this.getBody();
        result = result * 59 + ($body == null ? 43 : $body.hashCode());
        return result;
    }

    public String toString() {
        return "ListCustomerResponseEnvelopDto(body=" + this.getBody() + ")";
    }

    public static class Body {
        @JacksonXmlProperty(
                localName = "listCustomersResponse"
        )
        private Object listCustomersResponse;
        @JacksonXmlProperty(
                localName = "multiRef"
        )
        @JacksonXmlElementWrapper(
                useWrapping = false
        )
        private JsonNode[] multiRef;

        public Body() {
        }

        public Object getListCustomersResponse() {
            return this.listCustomersResponse;
        }

        public JsonNode[] getMultiRef() {
            return this.multiRef;
        }

        public void setListCustomersResponse(final Object listCustomersResponse) {
            this.listCustomersResponse = listCustomersResponse;
        }

        public void setMultiRef(final JsonNode[] multiRef) {
            this.multiRef = multiRef;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof ListCustomerResponseEnvelopDto.Body)) {
                return false;
            } else {
                ListCustomerResponseEnvelopDto.Body other = (ListCustomerResponseEnvelopDto.Body) o;
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
            return other instanceof ListCustomerResponseEnvelopDto.Body;
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
            return "ListCustomerResponseEnvelopDto.Body(listCustomersResponse=" + this.getListCustomersResponse() + ", multiRef=" + Arrays.deepToString(this.getMultiRef()) + ")";
        }
    }
}
