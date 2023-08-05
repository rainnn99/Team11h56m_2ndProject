package team_11h56m.letsdigin.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String id;

    public String getId() {return id;}
}
