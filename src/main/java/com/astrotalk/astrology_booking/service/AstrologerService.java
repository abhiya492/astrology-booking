package com.astrotalk.astrology_booking.service;

import com.astrotalk.astrology_booking.model.Astrologer;
import com.astrotalk.astrology_booking.repository.AstrologerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstrologerService {

    @Autowired
    private AstrologerRepository astrologerRepository;

    public Astrologer addAstrologer(Astrologer astrologer) {
        return astrologerRepository.save(astrologer);
    }

    public List<Astrologer> getAllAstrologers() {
        return astrologerRepository.findAll();
    }
}
