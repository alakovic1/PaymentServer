package ba.unsa.etf.si.payment.repository;

import ba.unsa.etf.si.payment.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByBankAccount_Id(Long id);
    List<Transaction> findByApplicationUser_Id(Long id);
    List<Transaction> findAllByCreatedAtBetween(Date startDate, Date endDate);
    List<Transaction> findAllByApplicationUser_IdAndMerchant_MerchantName(Long id, String merchantName);
}