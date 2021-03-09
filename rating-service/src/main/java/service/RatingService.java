package service;

import common.RatingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.entity.Rating;
import persistence.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;

    public List<Rating> findRatingsByBookId(String bookId){
        return repository.findRatingsByBookId(bookId);
    }

    public List<Rating> findAllRatings(){
        return repository.findAll();
    }

    public Rating findRatingById(Long ratingId) throws RatingNotFoundException {
        return repository.findById(ratingId)
                .orElseThrow(() -> new RatingNotFoundException("Rating Not Found with ID : " + ratingId));
    }

    public void createRating(Rating rating){
        repository.save(rating);
    }

    public void deleteRating(Long ratingId){
        repository.deleteById(ratingId);
    }

    public void updateRating(Rating rating, Long ratingId){
        repository.findById(ratingId)
                .map(request -> {
                    request.setStars(rating.getStars());

                    return repository.save(request);
                });
    }

}
