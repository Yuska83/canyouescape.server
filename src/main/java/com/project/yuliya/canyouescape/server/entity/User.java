package com.project.yuliya.canyouescape.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "globalId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "increment", strategy = "increment")
    private long globalId;

    @Column(name = "localId")
    private int localId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "time")
    private long time;

    public User()
    {

    }


    public long getGlobalId() {
        return globalId;
    }

    public void setGlobalId(long globalId) {
        this.globalId = globalId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
