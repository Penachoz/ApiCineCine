package CineCine.Backend.Repository;

import CineCine.Backend.Model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IReviewRepository extends MongoRepository<Review, ObjectId> {
    // Encuentra reviews por usuario
    List<Review> findByUsuarioId(ObjectId usuarioId);

    // Encuentra reviews por película
    List<Review> findByPeliculaId(String peliculaId);
}
