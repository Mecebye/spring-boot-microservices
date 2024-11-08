package com.example.recommendationservice.service;

import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public void createRecommendation(Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public Recommendation getRecommendationById(int id) {
        Optional<Recommendation> recommendation = recommendationRepository.findById(id);
        return recommendation.orElse(null);
    }

    // get recommendations by product id
    public List<Recommendation> getRecommendationsByProductId(int productId) {
        return recommendationRepository.findByProductId(productId);
    }
}
