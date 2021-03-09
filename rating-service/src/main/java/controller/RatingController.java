package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import persistence.entity.Rating;
import service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @GetMapping("/")
    public List<Rating> findAllRatings(){
        return service.findAllRatings();
    }

    @GetMapping("/{bookId}")
    public List<Rating> findRatingsByBookId(@PathVariable String bookId){
        return service.findRatingsByBookId(bookId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRating(@RequestBody Rating rating){
        service.createRating(rating);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateRating(@RequestBody Rating rating, @PathVariable Long ratingId){
        service.updateRating(rating, ratingId);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRating(@PathVariable Long ratingId){
        service.deleteRating(ratingId);
    }

}
