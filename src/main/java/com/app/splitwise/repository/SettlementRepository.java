package com.app.splitwise.repository;

import com.app.splitwise.entity.Settlement;
import com.app.splitwise.entity.SettlementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    List<Settlement> findByGroupId(Long groupId);
    List<Settlement> findByReceiverIdAndStatus(Long receiverId, SettlementStatus status);
}