package com.example.demo.Service;

import com.example.demo.Domain.Channel;
import com.example.demo.Domain.ReprocessRequest;
import com.example.demo.Repository.ChannelRepository;
import com.example.demo.Repository.ReprocessRequestRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ChannelReprocessService {

    private final ChannelRepository channelRepository;
    private final ReprocessRequestRepository reprocessRequestRepository;

    public ChannelReprocessService(ChannelRepository channelRepository, ReprocessRequestRepository reprocessRequestRepository) {
        this.channelRepository = channelRepository;
        this.reprocessRequestRepository = reprocessRequestRepository;
    }

    public List<ReprocessRequest> getPosts(Channel channel){
        Optional<Channel> ch = channelRepository.findByChannelId(channel.getChannelId());
        if(ch.isPresent())
        {
            List<ReprocessRequest> reprocessRequests = reprocessRequestRepository.findAll();
            reprocessRequests = reprocessRequests.stream().filter(x -> x.getRchannel() == ch.get().getChannelId()).collect(Collectors.toList());
            return reprocessRequests;
        }
        return null;
    }
    public String addPosts(Channel channel, ReprocessRequest reprocessRequest){
            channelRepository.save(channel);
            reprocessRequest.setTimeStamps(new Timestamp(new Date().getTime()));
            reprocessRequestRepository.save(reprocessRequest);
        return "success!!";
    }
}
