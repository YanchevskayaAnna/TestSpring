package model;

import javax.persistence.*;

@Entity
@Table(name="services")
@NamedQuery(name = "Service.getAll", query = "SELECT c from Service c")
public class Service extends _IDEntity{

    @Column
    private String name;

    @Column
    private int subscriptionFee;

    public Service() {
    }

    public Service(String name, int subscriptionFee) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;

        if (id != null ? !id.equals(service.id) : service.id != null) return false;
        if (subscriptionFee != service.subscriptionFee) return false;
        return name != null ? name.equals(service.name) : service.name == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + subscriptionFee;
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", subscriptionFee=" + subscriptionFee +
                '}';
    }
}
