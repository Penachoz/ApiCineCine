package CineCine.Backend.Controller;

import CineCine.Backend.Model.Review;
import CineCine.Backend.Service.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/pelicula/{peliculaId}")
    public List<Review> obtenerPorPelicula(@PathVariable String peliculaId) {
        return reviewService.obtenerReviewsPorPelicula(peliculaId);
    }

    @GetMapping("/usuario/{usuarioEmail}")
    public List<Review> obtenerPorUsuario(@PathVariable String usuarioEmail) {
        return reviewService.obtenerReviewsPorUsuarioEmail(usuarioEmail);
    }


    @PostMapping("/crearReview")
    public ResponseEntity<Review> crearReview(@RequestBody Review review) {
        Review nuevaReview = reviewService.crearReview(review);
        return ResponseEntity.ok(nuevaReview);
    }

}
