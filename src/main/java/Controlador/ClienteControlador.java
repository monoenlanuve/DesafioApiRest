package Controlador;

import Mediador.Mediador;
import modelo.Cliente;
import modelo.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//Mapeo el EndPoint de Cliente
@RequestMapping(path="api/v1/cliente")
public class ClienteControlador {
@Autowired
private Cliente clienteServicio;
@PostMapping
public ResponseEntity<Object> postCliente(@RequestBody Cliente cliente) {
    try {
          System.out.println(cliente);
         //LLamo al Servicio para guardar mi cliente
          Cliente clienteGuardado = clienteServicio.postCliente(cliente);
          return Mediador.generateResponse(
          "Cliente creado correctamente",
                  HttpStatus.OK,
                  clienteGuardado);
     } catch (Exception e) {
            return Mediador.generateResponse
                    (e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);

        }
    }
@GetMapping(path= {"id"})
public ResponseEntity<Object>GetCliente(@PathVariable int id) {
    try {
        System.out.println(id);
        //Conecto con el controlador con el Servicio.
        Cliente clienteEncontrado=clienteServicio.getId_cliente(id);
        return Mediador.generateResponse (
                "Cliente enviado correctamente",
                HttpStatus.OK,
                clienteEncontrado);

    } catch (Exception e) {
        return Mediador.generateResponse
                ( e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);

    }
}


}


