package com.astrotalk.astrology_booking.repository;

import com.astrotalk.astrology_booking.model.Astrologer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AstrologerRepository extends MongoRepository<Astrologer, String> {}
