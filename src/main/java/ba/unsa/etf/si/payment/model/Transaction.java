package ba.unsa.etf.si.payment.model;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@Check(constraints = "totalPrice >= 0")
public class Transaction extends AuditModel {
    @Id
    @GeneratedValue(generator = "transaction_generator")
    @SequenceGenerator(
            name = "transaction_generator",
            sequenceName = "transaction_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bank_account_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  BankAccount bankAccount;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "merchant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Merchant merchant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "application_user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ApplicationUser applicationUser;

    @Column(name = "totalPrice", nullable = false)
    private Double totalPrice;

    @Column(columnDefinition = "text")
    private String service;

    @Column(columnDefinition = "text")
    private String receiptId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double amount) {
        this.totalPrice = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }
}
