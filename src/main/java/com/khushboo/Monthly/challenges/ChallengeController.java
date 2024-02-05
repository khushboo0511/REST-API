package com.khushboo.Monthly.challenges;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeController() {
        Challenge challenge1 = new Challenge(1L, "January", "Learn a new programming language");
        challenges.add(challenge1);
    }
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    @PostMapping("/challenges")
    public String addChallenges(@RequestBody Challenge challenge) {
        challenges.add(challenge);
        return "Challenge added successfuly";
    }
}
