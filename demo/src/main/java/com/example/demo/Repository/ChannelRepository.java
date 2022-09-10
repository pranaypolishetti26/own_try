package com.example.demo.Repository;
import com.example.demo.Domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    Optional<Channel> findByChannelId(int channelId);
    List<Channel> findBychannelName(String channelName);
}
