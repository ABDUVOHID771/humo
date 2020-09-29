package com.example.springhumo.model.dto.humo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.HashMap;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class MultirefObj {
    @JsonProperty
    private String id;
    @JsonProperty
    private String root;
    @JsonProperty
    private Object name;
    @JsonProperty
    private Object value;
    @JsonProperty
    private MultirefObj.Row[] row;

    public String getName() {
        HashMap<Object, Object> nameMap = (HashMap) this.name;
        return nameMap == null ? "" : nameMap.getOrDefault("", "").toString();
    }

    public Object getValue() {
        HashMap<Object, Object> valueMap = (HashMap) this.value;
        return valueMap == null ? "" : valueMap.getOrDefault("", "").toString();
    }

    public String getId() {
        return this.id;
    }

    public String getRoot() {
        return this.root;
    }

    public MultirefObj.Row[] getRow() {
        return this.row;
    }

    @JsonProperty
    public void setId(final String id) {
        this.id = id;
    }

    @JsonProperty
    public void setRoot(final String root) {
        this.root = root;
    }

    @JsonProperty
    public void setName(final Object name) {
        this.name = name;
    }

    @JsonProperty
    public void setValue(final Object value) {
        this.value = value;
    }

    @JsonProperty
    public void setRow(final MultirefObj.Row[] row) {
        this.row = row;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MultirefObj)) {
            return false;
        } else {
            MultirefObj other = (MultirefObj) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label63:
                {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label63;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label63;
                    }

                    return false;
                }

                Object this$root = this.getRoot();
                Object other$root = other.getRoot();
                if (this$root == null) {
                    if (other$root != null) {
                        return false;
                    }
                } else if (!this$root.equals(other$root)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                label42:
                {
                    Object this$value = this.getValue();
                    Object other$value = other.getValue();
                    if (this$value == null) {
                        if (other$value == null) {
                            break label42;
                        }
                    } else if (this$value.equals(other$value)) {
                        break label42;
                    }

                    return false;
                }

                if (!Arrays.deepEquals(this.getRow(), other.getRow())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MultirefObj;
    }

    public int hashCode() {
        int PRIME = 1; //true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());//new int result
        Object $root = this.getRoot();
        result = result * 59 + ($root == null ? 43 : $root.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getRow());
        return result;
    }

    public String toString() {
        return "MultirefObj(id=" + this.getId() + ", root=" + this.getRoot() + ", name=" + this.getName() + ", value=" + this.getValue() + ", row=" + Arrays.deepToString(this.getRow()) + ")";
    }

    public MultirefObj(final String id, final String root, final Object name, final Object value, final MultirefObj.Row[] row) {
        this.id = id;
        this.root = root;
        this.name = name;
        this.value = value;
        this.row = row;
    }

    public MultirefObj() {
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Row {
        private String href;

        public String getHref() {
            return this.href;
        }

        public void setHref(final String href) {
            this.href = href;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof MultirefObj.Row)) {
                return false;
            } else {
                MultirefObj.Row other = (MultirefObj.Row) o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$href = this.getHref();
                    Object other$href = other.getHref();
                    if (this$href == null) {
                        if (other$href != null) {
                            return false;
                        }
                    } else if (!this$href.equals(other$href)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof MultirefObj.Row;
        }

        public int hashCode() {
            int PRIME = 1; //true
            int result = 1;
            Object $href = this.getHref();
            result = result * 59 + ($href == null ? 43 : $href.hashCode());
            return result;
        }

        public String toString() {
            return "MultirefObj.Row(href=" + this.getHref() + ")";
        }

        public Row(final String href) {
            this.href = href;
        }

        public Row() {
        }
    }
}
