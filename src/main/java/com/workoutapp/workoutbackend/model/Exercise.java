package com.workoutapp.workoutbackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable=false, unique=true)
    private String name;

    @Column(name = "image_url", nullable = false, unique = true)
    private String imageURL;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "video_url", nullable = false, unique = true)
    private String videoURL;

    @OneToMany(
            mappedBy = "exercise",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("stepNumber ASC")
    private List<HowToStep> howToSteps = new ArrayList<>();

    @OneToMany(
            mappedBy = "exercise",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ExerciseTargetMuscle> exerciseTargetMuscles = new ArrayList<>();

    public void addStep(HowToStep step){
        howToSteps.add(step);
        step.setExercise(this);
    }

    public void removeStep(HowToStep step){
        howToSteps.remove(step);
        step.setExercise(null);
    }

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public List<HowToStep> getHowToSteps() { return howToSteps; }

    public List<ExerciseTargetMuscle> getExerciseTargetMuscles() { return exerciseTargetMuscles; }
}
