package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="service_abonents")
@NamedQuery(name = "ServiceAbonent.getAll", query = "SELECT c from ServiceAbonent c")
public class ServiceAbonent extends _IDEntity{

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id",
            referencedColumnName = "id")
    private Service service;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "abonent_id",
            referencedColumnName = "id")
    private Abonent abonent;

    @Column
    private LocalDate dateFrom;

    @Column
    private LocalDate dateTo;

    public ServiceAbonent(Service service, Abonent abonent, LocalDate dateFrom, LocalDate dateTo) {
        this.service = service;
        this.abonent = abonent;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public ServiceAbonent() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceAbonent)) return false;

        ServiceAbonent that = (ServiceAbonent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (abonent != null ? !abonent.equals(that.abonent) : that.abonent != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(that.dateTo) : that.dateTo == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (abonent != null ? abonent.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceAbonent{" +
                "service=" + service +
                ", abonent=" + abonent +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
