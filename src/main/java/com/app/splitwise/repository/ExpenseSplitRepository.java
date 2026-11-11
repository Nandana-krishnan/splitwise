package com.app.splitwise.repository;

import com.app.splitwise.entity.ExpenseSplit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseSplitRepository extends JpaRepository<ExpenseSplit, Long> {
    List<ExpenseSplit> findByExpenseId(Long expenseId);
    List<ExpenseSplit> findByUserId(Long userId);
    List<ExpenseSplit> findByUserIdAndPaid(Long userId, Boolean paid);

    @Query("SELECT SUM(es.shareAmount) FROM ExpenseSplit es WHERE es.user.id = :userId AND es.paid = false")
    java.math.BigDecimal getTotalUnpaidAmountByUser(Long userId);
}