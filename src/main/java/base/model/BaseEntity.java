package base.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private ID id;
    private Instant creatAt;
    private Instant lastUpdate;

    public ID getId() {
        return id;
    }

    @PrePersist
    public void onCreate(){
        this.creatAt = Instant.now();
        this.lastUpdate = Instant.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.lastUpdate = Instant.now();
    }

    public Instant getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Instant creatAt) {
        this.creatAt = creatAt;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
