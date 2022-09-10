package com.example.demo.Service;

import com.example.demo.Domain.ReprocessRequest;
import com.example.demo.Repository.ChannelRepository;
import com.example.demo.Repository.ReprocessRequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.example.demo.Domain.Channel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ChannelReprocessServiceTest {

    @InjectMocks
    private ChannelReprocessService channelReprocessService;

    @Mock
    private ChannelRepository channelRepository;

    @Mock
    private ReprocessRequestRepository reprocessRequestRepository;

    @Test
    public void getPosts() {
        Channel channel = new Channel();
        channel.setChannelId(1);
        channel.setChannelName("demo");
        List<ReprocessRequest> reprocessRequests = new ArrayList<>();
        ReprocessRequest firstRequest = new ReprocessRequest();
        firstRequest.setRequestId(33);
        firstRequest.setRchannel(1);
        firstRequest.setTimeStamps(new Timestamp(new Date().getTime()));
        firstRequest.setRchannel(1);
        ReprocessRequest secondRequest = new ReprocessRequest();
        secondRequest.setRequestId(34);
        secondRequest.setRchannel(1);
        secondRequest.setTimeStamps(new Timestamp(new Date().getTime()));
        secondRequest.setRchannel(1);
        reprocessRequests.add(firstRequest);
        reprocessRequests.add(secondRequest);
        when(channelRepository.findByChannelId(anyInt())).thenReturn(Optional.of(channel));
        when(reprocessRequestRepository.findByRequestId(anyInt())).thenReturn(reprocessRequests);
        assertNotNull(channelReprocessService.getPosts(channel));
    }
}