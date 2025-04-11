package com.astrotalk.astrology_booking.repository;

import com.astrotalk.astrology_booking.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
