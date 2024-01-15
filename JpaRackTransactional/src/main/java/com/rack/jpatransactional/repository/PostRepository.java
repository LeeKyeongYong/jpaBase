package com.rack.jpatransactional.repository;

import com.rack.jpatransactional.entity.Post;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUsername(String username);

    @Lock(LockModeType.PESSIMISTIC_READ) //쿼리문에서 lock in SHARE MODE; 생성이됨
    Optional<Post> findWithShareLockById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE) //쿼리문에서 For Update; 생성이됨
    Optional<Post> findWithwriteLockById(Long id);//경쟁관계발생하는 경우
}
