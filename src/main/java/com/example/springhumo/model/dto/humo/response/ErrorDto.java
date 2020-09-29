package com.example.springhumo.model.dto.humo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(
        localName = "envelop"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ErrorDto {
    @JacksonXmlProperty(
            localName = "provider"
    )
    private String provider;
    @JacksonXmlProperty(
            localName = "error"
    )
    private Integer error;
    @JacksonXmlProperty(
            localName = "description"
    )
    private String description;
    @JacksonXmlProperty(
            localName = "screen"
    )
    private String screen;

    public ErrorDto() {
    }

    public String getProvider() {
        return this.provider;
    }

    public Integer getError() {
        return this.error;
    }

    public String getDescription() {
        return this.description;
    }

    public String getScreen() {
        return this.screen;
    }

    public void setProvider(final String provider) {
        this.provider = provider;
    }

    public void setError(final Integer error) {
        this.error = error;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setScreen(final String screen) {
        this.screen = screen;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorDto)) {
            return false;
        } else {
            ErrorDto other = (ErrorDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$provider = this.getProvider();
                    Object other$provider = other.getProvider();
                    if (this$provider == null) {
                        if (other$provider == null) {
                            break label59;
                        }
                    } else if (this$provider.equals(other$provider)) {
                        break label59;
                    }

                    return false;
                }

                Object this$error = this.getError();
                Object other$error = other.getError();
                if (this$error == null) {
                    if (other$error != null) {
                        return false;
                    }
                } else if (!this$error.equals(other$error)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                Object this$screen = this.getScreen();
                Object other$screen = other.getScreen();
                if (this$screen == null) {
                    if (other$screen != null) {
                        return false;
                    }
                } else if (!this$screen.equals(other$screen)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $provider = this.getProvider();
        result = result * 59 + ($provider == null ? 43 : $provider.hashCode());
        Object $error = this.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $screen = this.getScreen();
        result = result * 59 + ($screen == null ? 43 : $screen.hashCode());
        return result;
    }

    public String toString() {
        return "ErrorDto(provider=" + this.getProvider() + ", error=" + this.getError() + ", description=" + this.getDescription() + ", screen=" + this.getScreen() + ")";
    }
}
