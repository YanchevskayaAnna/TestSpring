package model.auxiliary;

import model.Abonent;
import model.Service;
import model.UserType;

import java.util.List;

public class AbonentInfo {

    private Abonent abonent;
    private UserType type;
    private List<Service> services;

    public AbonentInfo() {
    }

    public AbonentInfo(Abonent abonent, UserType type, List<Service> services, Integer balance) {
        this.abonent = abonent;
        this.type = type;

        this.services = services;
        this.balance = balance;
    }

    private Integer balance;

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    @Override
    public String toString() {
        return "AbonentInfo{" +
                "abonent=" + abonent +
                ", type=" + type +
                ", services=" + services +
                ", balance=" + balance +
                '}';
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbonentInfo)) return false;

        AbonentInfo that = (AbonentInfo) o;

        if (abonent != null ? !abonent.equals(that.abonent) : that.abonent != null) return false;
        return false;

    }

    @Override
    public int hashCode() {
        int result = abonent != null ? abonent.hashCode() : 0;
        return result;
    }


}
