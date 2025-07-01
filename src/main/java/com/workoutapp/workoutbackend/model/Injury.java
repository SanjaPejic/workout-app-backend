package com.workoutapp.workoutbackend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "injury", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "muscle_id"}))
public class Injury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    public Injury() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
        this.muscle = muscle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Injury injury = (Injury) o;
        return Objects.equals(id, injury.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
