package com.example.demo.Service;

import com.example.demo.Domain.Channel;
import com.example.demo.Domain.ReprocessRequest;
import com.example.demo.Repository.ChannelRepository;
import com.example.demo.Repository.ReprocessRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReprocessRequestService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private ReprocessRequestRepository reprocessRequestRepository;
    public List<ReprocessRequest> getAllRequestResponse(Channel channel){
        Optional<Channel> ch = channelRepository.findByChannelId(channel.getChannelId());
        if(ch.isPresent())
        {
            List<ReprocessRequest> reprocessRequests = reprocessRequestRepository.findAll();
            reprocessRequests = reprocessRequests.stream().filter(x -> x.getRchannel() == ch.get().getChannelId()).collect(Collectors.toList());
            return reprocessRequests;
        }
        return null;
    }
    public List<ReprocessRequest> createRequestResponse(ChannelReprocess channelReprocess){
        Channel channel = new Channel();
        channel.setChannelId(channelReprocess.getChannelId());
        channelRepository.save(channel);
        ReprocessRequest reprocessRequest = new ReprocessRequest();
        reprocessRequest.setRchannel(channelReprocess.getRchannel());
        reprocessRequest.setTimeStamps(new Timestamp(new Date().getTime()));
        reprocessRequest.setStatus(channelReprocess.getStatus());
        reprocessRequestRepository.save(reprocessRequest);
        return getAllRequestResponse(channel);
    }
}
