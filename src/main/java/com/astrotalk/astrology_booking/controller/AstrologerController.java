package com.astrotalk.astrology_booking.controller;

import com.astrotalk.astrology_booking.model.Astrologer;
import com.astrotalk.astrology_booking.service.AstrologerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/astrologers")
public class AstrologerController {

    @Autowired
    private AstrologerService astrologerService;

    @PostMapping
    public Astrologer addAstrologer(@RequestBody Astrologer astrologer) {
        return astrologerService.addAstrologer(astrologer);
    }

    @GetMapping
    public List<Astrologer> getAllAstrologers() {
        return astrologerService.getAllAstrologers();
    }
}
