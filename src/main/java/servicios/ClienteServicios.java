package servicios;

import modelo.Cliente;
import modelo.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.ClienteRepositorio;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClienteServicios {
    //Conecto con el Repositorio de Cliente
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    public Cliente postCliente(Cliente cliente)throws Exception {
         return clienteRepositorio.save(cliente);
    }
    public ClienteDto getCliente(int id) throws Exception{
        Optional<Cliente> cliente= clienteRepositorio.findById(id);
        if(cliente.isEmpty()) {
            return null;
        }else{return ClienteDto.get();
            //no se como salir de este If.
            //si llego hasta aca es porque el Id es valido
            }
        // No me doy cuenta como concatenar el calculo de la edad en el ciclo del IF
        // me da error al ponerlo detro
    }
    // Calcula edad del cliente en cuestión
    private int calculoEdad(LocalDate fechaNacimiento){
        LocalDate fechaActual=LocalDate.now();
        return Period.between(fechaNacimiento,fechaActual).getYears();
    }

}










