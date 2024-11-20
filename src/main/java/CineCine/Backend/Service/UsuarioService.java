package CineCine.Backend.Service;

import CineCine.Backend.Model.Usuario;
import CineCine.Backend.Repository.IUsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe.");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(ObjectId id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));
    }

    public void eliminarUsuario(ObjectId id) {
        usuarioRepository.deleteById(id);
    }
}
