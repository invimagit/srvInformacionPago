package co.com.invima.tramite.service.srvInformacionPago.service;


import co.com.invima.canonico.modeloCanonico.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;


public interface IInformacionPagoService {
    
        ResponseEntity<GenericResponseDTO> consultarTarifaPorCodigo(String codigoTarifa);

        ResponseEntity<GenericResponseDTO> consultarPorCodigoBarra(String codigoPago);

        ResponseEntity<GenericResponseDTO> consultarPorCodigoPSE(String codigoPago);

        ResponseEntity<GenericResponseDTO> consultarPorCodigoGiroInternacional(String codigoTransferencia);

}
