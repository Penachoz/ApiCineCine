package CineCine.Backend.Controller;

import CineCine.Backend.Model.Review;
import CineCine.Backend.Service.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/{usuarioEmail}")
    public List<Review> obtenerPorUsuario(@PathVariable String usuarioEmail) {
        List<Review> reviews = reviewService.obtenerReviewsPorUsuarioEmail(usuarioEmail);
        if (reviews.isEmpty()) {
            return new ArrayList<>(); // Retorna una lista vacía si no se encuentran reviews
        }
        return reviews;
    }
    @GetMapping("/pelicula/{peliculaId}")
    public List<Review> obtenerPorPelicula(@PathVariable String peliculaId) {
        return reviewService.obtenerReviewsPorPelicula(peliculaId);
    }

    


    @PostMapping("/crearReview")
    public ResponseEntity<Review> crearReview(@RequestBody Review review) {
        Review nuevaReview = reviewService.crearReview(review);
        return ResponseEntity.ok(nuevaReview);
    }

}
