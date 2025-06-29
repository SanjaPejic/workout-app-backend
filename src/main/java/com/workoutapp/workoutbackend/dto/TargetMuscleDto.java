package com.workoutapp.workoutbackend.dto;

public class TargetMuscleDto {
    private Long id;
    private int percentage;
    private MuscleDto muscle;

    public TargetMuscleDto(Long id, int percentage, MuscleDto muscle) {
        this.id = id;
        this.percentage = percentage;
        this.muscle = muscle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public MuscleDto getMuscle() {
        return muscle;
    }

    public void setMuscle(MuscleDto muscle) {
        this.muscle = muscle;
    }
}
