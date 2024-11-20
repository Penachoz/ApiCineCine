package CineCine.Backend.Repository;

import CineCine.Backend.Model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    // Agrega métodos de consulta personalizados si es necesario
    boolean existsByEmail(String email);
}
