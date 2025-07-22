package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Page<Exercise> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("""
        SELECT e FROM Exercise e
        JOIN e.exerciseTargetMuscles etm
        JOIN etm.muscle m
        WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))
        AND m.name IN :muscleNames
        GROUP BY e
        HAVING COUNT(DISTINCT m.name) = :muscleCount
    """)
    Page<Exercise> findByNameContainingIgnoreCaseAndTargetMusclesIn(@Param("name") String name, @Param("muscleNames") List<String> targetMuscNames, @Param("muscleCount") long targetMuscCount, Pageable pageable);
}
