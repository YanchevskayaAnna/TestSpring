package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User extends _IDEntity{

    @Column
    private String login;

    @Column
    private String pass;

    @Column(name = "usertype")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Abonent> abonentList;

    /*Есть запрос: String queryString = "SELECT a.user,  AVG(c.duration) FROM Call c join c.abonent a  WHERE c.date >= :dateFrom and c.date <= :dateTo GROUP BY a.user";
    Если написать:
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Abonent> abonentList;
    то в базу данных удет сделано 4 запроса:
    Hibernate: select abonent1_.user_id as col_0_0_, avg(call0_.duration) as col_1_0_, user2_.id as id1_5_, user2_.login as login2_5_, user2_.pass as pass3_5_, user2_.usertype as usertype4_5_ from calls call0_ inner join abonents abonent1_ on call0_.abonent_id=abonent1_.id inner join users user2_ on abonent1_.user_id=user2_.id where call0_.date>=? and call0_.date<=? group by abonent1_.user_id
    Hibernate: select abonentlis0_.user_id as user3_5_1_, abonentlis0_.id as id1_0_1_, abonentlis0_.id as id1_0_0_, abonentlis0_.name as name2_0_0_, abonentlis0_.user_id as user3_0_0_ from abonents abonentlis0_ where abonentlis0_.user_id=?
    Hibernate: select abonentlis0_.user_id as user3_5_1_, abonentlis0_.id as id1_0_1_, abonentlis0_.id as id1_0_0_, abonentlis0_.name as name2_0_0_, abonentlis0_.user_id as user3_0_0_ from abonents abonentlis0_ where abonentlis0_.user_id=?
    Hibernate: select abonentlis0_.user_id as user3_5_1_, abonentlis0_.id as id1_0_1_, abonentlis0_.id as id1_0_0_, abonentlis0_.name as name2_0_0_, abonentlis0_.user_id as user3_0_0_ from abonents abonentlis0_ where abonentlis0_.user_id=?

    Если написать:
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT) ( по умолчанию - это предыдущий вариант   @Fetch(FetchMode.JOIN))
    private List<Abonent> abonentList;
    то в базу данных будет идти 1 запрос:
    Hibernate: select abonent1_.user_id as col_0_0_, avg(call0_.duration) as col_1_0_, user2_.id as id1_5_, user2_.login as login2_5_, user2_.pass as pass3_5_, user2_.usertype as usertype4_5_ from calls call0_ inner join abonents abonent1_ on call0_.abonent_id=abonent1_.id inner join users user2_ on abonent1_.user_id=user2_.id where call0_.date>=? and call0_.date<=? group by abonent1_.user_id
    */

    public User(String login, String pass, UserType userType) {
        this.login = login;
        this.pass = pass;
        this.userType = userType;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public List<Abonent> getAbonentList() {
        return abonentList;
    }

    public void setAbonentList(List<Abonent> abonentList) {
        this.abonentList = abonentList;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        return userType == user.userType;

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", userType=" + userType +
                //", abonentList=" + abonentList +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

}
