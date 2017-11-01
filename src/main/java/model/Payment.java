package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="payments")
@NamedQuery(name = "Payment.getAll", query = "SELECT c from Payment c")
public class Payment extends _IDEntity{

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "abonent_id",
            referencedColumnName = "id")
    private Abonent abonent;

    @Column
    private LocalDate paymentDay;

    @Column
    private int value;

    public Payment() {
    }

    public Payment(Abonent abonent, LocalDate paymentDay, int value) {
        this.abonent = abonent;
        this.paymentDay = paymentDay;
        this.value = value;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(LocalDate paymentDay) {
        this.paymentDay = paymentDay;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (value != payment.value) return false;
        if (abonent != null ? !abonent.equals(payment.abonent) : payment.abonent != null) return false;
        return paymentDay != null ? paymentDay.equals(payment.paymentDay) : payment.paymentDay == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (abonent != null ? abonent.hashCode() : 0);
        result = 31 * result + (paymentDay != null ? paymentDay.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }
}
