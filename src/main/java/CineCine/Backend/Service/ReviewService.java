package CineCine.Backend.Service;

import CineCine.Backend.Model.Review;
import CineCine.Backend.Repository.IReviewRepository;
import CineCine.Backend.Repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private final IReviewRepository reviewRepository;
    private final IUsuarioRepository usuarioRepository; // Inyección del repositorio de usuarios
    
    public ReviewService(IReviewRepository reviewRepository, IUsuarioRepository usuarioRepository) {
        this.reviewRepository = reviewRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Review> obtenerReviewsPorPelicula(String peliculaId) {
        return reviewRepository.findByPeliculaId(peliculaId);
    }

    public List<Review> obtenerReviewsPorUsuarioEmail(String usuarioEmail) {
        return reviewRepository.findByUsuarioEmail(usuarioEmail);
    }

    public Review crearReview(Review review) {
        // Verificar si el usuario con el email proporcionado existe
        if (!usuarioRepository.existsByEmail(review.getUsuarioEmail())) {
            throw new IllegalArgumentException("El usuario con el email proporcionado no existe.");
        }
        // Crear la review si el usuario es válido
        return reviewRepository.save(review);
    }

    public void eliminarReview(String id) {
        reviewRepository.deleteById(id);
    }
}
