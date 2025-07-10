package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.Injury;
import com.workoutapp.workoutbackend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InjuryRepository extends JpaRepository<Injury, Long> {
    List<Injury> findAllByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Injury i WHERE i.user.id = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);
}
