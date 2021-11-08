package co.com.invima.tramite.service.srvInformacionPago.web.api.rest.v1;


import co.com.invima.canonico.modeloCanonico.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IInformacionPagoController {


    ResponseEntity<GenericResponseDTO> consultarTarifaPorCodigo(@PathVariable String codigoTarifa);

    ResponseEntity<GenericResponseDTO> consultarPorCodigoBarra(@PathVariable String codigoPago);

    ResponseEntity<GenericResponseDTO> consultarPorCodigoPSE(@PathVariable String codigoPago);

    ResponseEntity<GenericResponseDTO> consultarPorCodigoGiroInternacional(@PathVariable String codigoTransferencia);


}

