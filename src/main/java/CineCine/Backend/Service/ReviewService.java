package CineCine.Backend.Service;

import CineCine.Backend.Model.Review;
import CineCine.Backend.Repository.IReviewRepository;
import CineCine.Backend.Repository.IUsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final IReviewRepository reviewRepository;
    private final IUsuarioRepository usuarioRepository; // Inyección del repositorio de usuarios

    public ReviewService(IReviewRepository reviewRepository, IUsuarioRepository usuarioRepository) {
        this.reviewRepository = reviewRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Review> obtenerReviewsPorPelicula(String peliculaId) {
        return reviewRepository.findByPeliculaId(peliculaId);
    }

    public List<Review> obtenerReviewsPorUsuario(ObjectId usuarioId) {
        return reviewRepository.findByUsuarioId(usuarioId);
    }

    public Review crearReview(Review review) {
        // Verificar si el usuario existe
        if (!usuarioRepository.existsById(review.getUsuarioId())) {
            throw new IllegalArgumentException("El usuario con el ID proporcionado no existe.");
        }
        // Crear la review si el usuario es válido
        return reviewRepository.save(review);
    }

    public void eliminarReview(ObjectId id) {
        reviewRepository.deleteById(id);
    }
}
