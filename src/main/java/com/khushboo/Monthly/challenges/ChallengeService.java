package com.khushboo.Monthly.challenges;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private static List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    public ChallengeService() {
    }

    public static List<Challenge> getAllChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge!=null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/challenges")
    public String addChallenges(@RequestBody Challenge challenge) {
        challenges.add(challenge);
        return "Challenge added successfuly";
    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge: challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }
}
