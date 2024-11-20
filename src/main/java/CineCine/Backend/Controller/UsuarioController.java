package CineCine.Backend.Controller;

import CineCine.Backend.Model.Usuario;
import CineCine.Backend.Service.UsuarioService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listarUser")
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable String id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(new ObjectId(id));
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(new ObjectId(id));
        return ResponseEntity.ok("Usuario eliminado con éxito.");
    }
}
