package co.com.invima.tramite.service.srvInformacionPago.web.api.rest.v1;


import co.com.invima.canonico.modeloCanonico.dto.generic.GenericRequestDTO;
import co.com.invima.canonico.modeloCanonico.dto.generic.GenericResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.invima.tramite.service.srvInformacionPago.service.IInformacionPagoService;

@RestController
@RequestMapping("/v1/InformacionPago")
@CrossOrigin(origins = "*",
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class InformacionPagoController implements IInformacionPagoController {

    private final IInformacionPagoService service;

    @Autowired
    public InformacionPagoController(IInformacionPagoService service) {
        this.service = service;
    }


    @Override
    @GetMapping("/consultarTarifa/{codigoTarifa}")
    @ApiOperation(value = "Consulta tarifa por código", notes = "Consulta tarifa por código")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarTarifaPorCodigo(@ApiParam(type = "String", value =
            "el parametro usuario debe ser un json con la siguiente estructura:" +
                    "<br>" +
                    "{ <br> request:"
                    + " {<br>"
                    + "     \"codigoTarifa\": \"\",<br>" +
                    "}<br>"

                    + "      }<br>", example = "2100", required = true) @PathVariable String codigoTarifa) {
        return service.consultarTarifaPorCodigo(codigoTarifa);
    }

    @Override
    @GetMapping("/consultarCodigoBarras/{codigoPago}")
    @ApiOperation(value = "Consulta código de barras  por código pago", notes = "Consulta código de barras  por código pago")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoBarra(@ApiParam(type = "String", value =
            "el parametro usuario debe ser un json con la siguiente estructura:" +
                    "<br>" +
                    "{ <br> request:"
                    + " {<br>"
                    + "     \"codigoPago\": \"\",<br>" +
                    "}<br>"

                    + "      }<br>", example = "2524", required = true) @PathVariable String codigoPago) {
        return service.consultarPorCodigoBarra(codigoPago);
    }


    @Override
    @GetMapping("/consultarPSE/{codigoPago}")
    @ApiOperation(value = "Consulta PSE por código de pago ", notes = "Consulta PSE por código de pago")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoPSE(@ApiParam(type = "String", value =
            "el parametro usuario debe ser un json con la siguiente estructura:" +
                    "<br>" +
                    "{ <br> request:"
                    + " {<br>"
                    + "     \"codigoPago\": \"\",<br>" +
                    "}<br>"

                    + "      }<br>", example = "2321", required = true) @PathVariable String codigoPago) {
        return service.consultarPorCodigoPSE(codigoPago);
    }


    @Override
    @GetMapping("/consultarGiroInternacional/{codigoTransferencia}")
    @ApiOperation(value = "Consulta tramite por id", notes = "Consulta tramite por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity<GenericResponseDTO> consultarPorCodigoGiroInternacional(@ApiParam(type = "String", value =
            "el parametro usuario debe ser un json con la siguiente estructura:" +
                    "<br>" +
                    "{ <br> request:"
                    + " {<br>"
                    + "     \"codigoTransferencia\": \"\",<br>" +
                    "}<br>"

                    + "      }<br>", example = "1617", required = true) @PathVariable String codigoTransferencia) {
        return service.consultarPorCodigoGiroInternacional(codigoTransferencia);
    }



}
