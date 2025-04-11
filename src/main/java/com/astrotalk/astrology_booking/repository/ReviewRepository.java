package com.astrotalk.astrology_booking.repository;

import com.astrotalk.astrology_booking.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {}
