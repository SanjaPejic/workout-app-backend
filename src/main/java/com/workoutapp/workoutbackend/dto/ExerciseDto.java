package com.workoutapp.workoutbackend.dto;

import java.util.List;

public class ExerciseDto {
    private Long id;
    private String name;
    private String imageURL;
    private String description;
    private String videoURL;
    private List<String> howToSteps;
    private List<TargetMuscleDto>  targetMuscles;

    public ExerciseDto(Long id, String name, String imageURL, String description, String videoURL, List<String> howToSteps, List<TargetMuscleDto> targetMuscles) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.videoURL = videoURL;
        this.howToSteps = howToSteps;
        this.targetMuscles = targetMuscles;
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

    public List<String> getHowToSteps() {
        return howToSteps;
    }

    public void setHowToSteps(List<String> howToSteps) {
        this.howToSteps = howToSteps;
    }

    public List<TargetMuscleDto> getTargetMuscles() {
        return targetMuscles;
    }

    public void setTargetMuscles(List<TargetMuscleDto> targetMuscles) {
        this.targetMuscles = targetMuscles;
    }
}
