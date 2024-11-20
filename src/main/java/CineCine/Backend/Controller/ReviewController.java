package CineCine.Backend.Controller;

import CineCine.Backend.Model.Review;
import CineCine.Backend.Service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/pelicula/{peliculaId}")
    public List<Review> obtenerPorPelicula(@PathVariable String peliculaId) {
        return reviewService.obtenerReviewsPorPelicula(peliculaId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Review> obtenerPorUsuario(@PathVariable String usuarioId) {
        return reviewService.obtenerReviewsPorUsuario(new ObjectId(usuarioId));
    }

    @PostMapping("/crearReview")
    public ResponseEntity<Review> crearReview(@RequestBody Review review) {
        Review nuevaReview = reviewService.crearReview(review);
        return ResponseEntity.ok(nuevaReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReview(@PathVariable String id) {
        reviewService.eliminarReview(new ObjectId(id));
        return ResponseEntity.ok("Review eliminada con éxito.");
    }
}
