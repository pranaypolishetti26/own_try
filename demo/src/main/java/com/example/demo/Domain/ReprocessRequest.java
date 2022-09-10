package com.example.demo.Domain;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;

@Service
@Entity
@Table(name = "reprocessrequest",schema = "local")
public class ReprocessRequest {
    @Id
    @Column(name = "requestid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;
    @Column(name = "time_stamp")
    private Timestamp timeStamps;
    @Column(name = "status")
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "channelid", nullable = false,insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ReprocessRequest reprocessRequest;
    private int channelid;
    public int getRchannel() { return channelid; }
    public void setRchannel(int channelId) { this.channelid  = channelId;}
    public Timestamp getTimeStamps() {
        return timeStamps;
    }
    public void setTimeStamps(Timestamp timeStamps) {
        this.timeStamps = timeStamps;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getRequestId() {
        return requestId;
    }
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
