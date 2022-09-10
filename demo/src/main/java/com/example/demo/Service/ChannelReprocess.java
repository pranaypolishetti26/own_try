package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class ChannelReprocess {
    private int channelId;
    private int reprocessChannelId;
    private String status;

    public int getRchannel() {
        return reprocessChannelId;
    }

    public void setRchannel(int reprocessChannelId) {
        this.reprocessChannelId = reprocessChannelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
