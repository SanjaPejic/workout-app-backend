package com.workoutapp.workoutbackend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "how_to_step", uniqueConstraints = @UniqueConstraint(columnNames = {"exercise_id","step_number"}))
public class HowToStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "step_number", nullable = false)
    private int stepNumber;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public HowToStep() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HowToStep howToStep = (HowToStep) o;
        return Objects.equals(id, howToStep.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
