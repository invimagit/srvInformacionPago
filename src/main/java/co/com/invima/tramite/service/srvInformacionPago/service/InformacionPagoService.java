package co.com.invima.tramite.service.srvInformacionPago.service;

import co.com.invima.canonico.modeloCanonico.dto.generic.GenericResponseDTO;
import co.com.invima.tramite.service.srvInformacionPago.commons.converter.InfoPagoConverter;
import co.com.invima.tramite.service.srvInformacionPago.repository.IInformacionPagoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InformacionPagoService implements IInformacionPagoService {


    private final IInformacionPagoRepository iInformacionPagoRepository;
    private final ModelMapper modelMapper;

    private final InfoPagoConverter infoPagoConverter;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public InformacionPagoService(InfoPagoConverter infoPagoConverter, ModelMapper modelMapper, IInformacionPagoRepository iInformacionPagoRepository) {

        this.infoPagoConverter = infoPagoConverter;
        this.modelMapper = modelMapper;
        this.iInformacionPagoRepository = iInformacionPagoRepository;
    }


    @Override
    public ResponseEntity<GenericResponseDTO> consultarTarifaPorCodigo(String codigoTarifa) {
        JSONParser parse = new JSONParser();

        try {

            String pagoTarifa = iInformacionPagoRepository.consultarTarifaPorCodigo(codigoTarifa) ;
            JSONObject json = (JSONObject)  parse.parse(pagoTarifa);

            JSONObject respuestGenerica = (JSONObject) json.get("respuesta");
            String codigo = (String) respuestGenerica.get("codigo");


            if (codigo.equals("00")) {
                JSONArray mensaje = (JSONArray) json.get("mensaje");
                return new ResponseEntity<>(GenericResponseDTO.builder().message("Se Consulta la tarifa por código").objectResponse(mensaje)
                        .statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
            }
            else {
                String descripcion = (String) respuestGenerica.get("mensaje");
                return new ResponseEntity<>(GenericResponseDTO.builder().message(descripcion)
                        .objectResponse(new JSONObject()).statusCode(HttpStatus.CONFLICT.value()).build(),
                        HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error  consultando el trámite por código de tarifa:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoBarra(String codigoPago) {
        JSONParser parse = new JSONParser();

        try {
            String respuestaPagoCodigoBarra = "{" +
                "\"entidadRecaudado\": \"Banco Davivienda\", " +
                "\"tipoCuenta\": \"Cuenta Corriente\", " +
                "\"numeroCuenta\": 002869998688," +
                "\"fechaConsignacion\": \"2022-08-19\", " +
                "\"ciudad\": \"Bolivia\", " +
                "\"valorPagado\": 2886850 " +
            "}";

            // String pagoTarifa = iInformacionPagoRepository.consultarPorCodigoBarra(codigoPago) ;
            JSONObject json = (JSONObject)  parse.parse(respuestaPagoCodigoBarra);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se consulta la información por código de barras: ")
                    .objectResponse(json).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error  consultando la información por código de barras:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoPSE(String codigoPago) {
        JSONParser parse = new JSONParser();

        try {
            String respuestaPagoPSE = "{" +
                    "\"tipoDocumento\": \"CC\", " +
                    "\"numeroDocumento\": \"987654321\", " +
                    "\"nombre\": \"Ana Paz\"," +
                    "\"entidadFinanciera\": \"Davivienda\", " +
                    "\"valor\": \"2886850\", " +
                    "\"fechaTransaccion\": \" 24-08-2020 \" " +
                    "\"estado\": \"Aprobada\" " +
                    "\"numeroAprobado\": 123456 " +
                    "}";

            // String pagoTarifa = iInformacionPagoRepository.consultarPorCodigoBarra(codigoPago) ;
            JSONObject json = (JSONObject)  parse.parse(respuestaPagoPSE);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se consulta el pago por PSE: ")
                    .objectResponse(json).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error  consultando el pago por PSE:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoGiroInternacional(String codigoTransferencia) {
        JSONParser parse = new JSONParser();

        try {
            String respuestaPagoGiroInternacional = "{" +
                    "\"entidadRecaudado\": \"Banco Davivienda\", " +
                    "\"tipoCuenta\": \"Cuenta Corriente\", " +
                    "\"numeroCuenta\": 002869998688," +
                    "\"fechaTransferencia\": \"2022-08-19\", " +
                    "\"paisOrigen\": \"Bolivia\", " +
                    "\"valorPagado\": 2886850 " +
                    "}";

            // String pagoTarifa = iInformacionPagoRepository.consultarPorCodigoBarra(codigoPago) ;
            JSONObject json = (JSONObject)  parse.parse(respuestaPagoGiroInternacional);

            return new ResponseEntity<>(GenericResponseDTO.builder().message("Se consulta el pago por giro internacional: ")
                    .objectResponse(json).statusCode(HttpStatus.OK.value()).build(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(GenericResponseDTO.builder().message("Error  consultando el pago por giro internacional:  " + e.getMessage())
                    .objectResponse(false).statusCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
        }
    }

}
