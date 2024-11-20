package CineCine.Backend.Repository;

import CineCine.Backend.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByPeliculaId(String peliculaId);
    List<Review> findByUsuarioEmail(String usuarioEmail); // Cambié el nombre del método para usar email
}
