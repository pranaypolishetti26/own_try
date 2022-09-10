package com.example.demo.Repository;
import com.example.demo.Domain.ReprocessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReprocessRequestRepository extends JpaRepository<ReprocessRequest, Integer> {
    List<ReprocessRequest> findByRequestId(int channelId);
}
