package com.example.springhumo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Result implements Serializable {
    private static final long serialVersionUID = -8457257838264102466L;
    private static final Logger logger = LogManager.getLogger(Result.class);
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;

    public Result() {
    }

    public Result(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Result(Result result) {
        this();
        this.code = result.getCode();
        this.description = result.getDescription();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Result{code='" + this.code + '\'' + ", description='" + this.description + '\'' + '}';
    }
}
