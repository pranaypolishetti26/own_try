package com.example.demo.Domain;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
@Entity
@Table(name = "channel",schema = "local")
public class Channel{
    @Id
    @Column(name = "channelid")
    private Integer channelId;
    @Column(name = "channelname")
    private String channelName;
    @OneToMany(targetEntity=ReprocessRequest.class, mappedBy="reprocessRequest",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<ReprocessRequest> requestList;
    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public Integer getChannelId() {
        return channelId;
    }
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}