package com.workoutapp.workoutbackend.dto;

public class InjuryDto {
    private Long id;
    private UserDto user;
    private MuscleDto muscle;

    public InjuryDto(Long id, UserDto user, MuscleDto muscle) {
        this.id = id;
        this.user = user;
        this.muscle = muscle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public MuscleDto getMuscle() {
        return muscle;
    }

    public void setMuscle(MuscleDto muscle) {
        this.muscle = muscle;
    }
}
