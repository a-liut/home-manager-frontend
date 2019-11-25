package it.aliut.hmfrontend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * An IoT device registered to the system.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "online",
        "address",
        "heartbeat_url",
        "data",
        "created_at",
        "updated_at"
})
public class Device {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("online")
    private Boolean online;
    @JsonProperty("address")
    private String address;
    @JsonProperty("heartbeat_url")
    private String heartbeatUrl;
    @JsonProperty("data")
    private List<String> data = null;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("online")
    public Boolean getOnline() {
        return online;
    }

    @JsonProperty("online")
    public void setOnline(Boolean online) {
        this.online = online;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("heartbeat_url")
    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    @JsonProperty("heartbeat_url")
    public void setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
    }

    @JsonProperty("data")
    public List<String> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<String> data) {
        this.data = data;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return name;
    }
}