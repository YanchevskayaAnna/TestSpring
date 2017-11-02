package model.auxiliary;

import model.Abonent;
import model.Service;
import model.UserType;

import java.util.List;

public class AbonentInfo {

    private String name;
    private UserType type;
    private List<Service> services;

    public AbonentInfo() {
    }

    public AbonentInfo(String name, UserType type, List<Service> services, Integer balance) {
        this.name = name;
        this.type = type;

        this.services = services;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer balance;

    @Override
    public String toString() {
        return "AbonentInfo{" +
                "abonent=" + name +
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

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return false;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }


}
