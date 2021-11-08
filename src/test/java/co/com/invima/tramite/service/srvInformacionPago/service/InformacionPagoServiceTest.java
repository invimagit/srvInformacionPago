package co.com.invima.tramite.service.srvInformacionPago.service;

import co.com.invima.canonico.modeloCanonico.dto.generic.GenericResponseDTO;
import co.com.invima.tramite.service.srvInformacionPago.commons.ConfiguradorSpring;
import co.com.invima.tramite.service.srvInformacionPago.commons.converter.InfoPagoConverter;
import co.com.invima.tramite.service.srvInformacionPago.web.api.rest.v1.InformacionPagoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfiguradorSpring.class})
public class InformacionPagoServiceTest {

    @Autowired
    InformacionPagoController pagoController;

    @Autowired
    InfoPagoConverter infoPagoConverter;


    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void consultarTarifaPorCodigo() {
        String codigoTarifa = "2100";
        try {
            ResponseEntity<GenericResponseDTO> response = pagoController.consultarTarifaPorCodigo(codigoTarifa);
            Object respuesta = response.getBody().getObjectResponse();
            System.out.println(respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void consultarPorCodigoBarra() {
        String codigoPago = "143";
        try {
            ResponseEntity<GenericResponseDTO> response = pagoController.consultarPorCodigoBarra(codigoPago);
            Object respuesta = response.getBody().getObjectResponse();
            System.out.println(respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void consultarPorCodigoPSE() {
        String codigoPago = "143";
        try {
            ResponseEntity<GenericResponseDTO> response = pagoController.consultarPorCodigoPSE(codigoPago);
            Object respuesta = response.getBody().getObjectResponse();
            System.out.println(respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void consultarPorCodigoGiroInternacional() {
        String codigoTransferencia = "143";
        try {
            ResponseEntity<GenericResponseDTO> response = pagoController.consultarPorCodigoGiroInternacional(codigoTransferencia);
            Object respuesta = response.getBody().getObjectResponse();
            System.out.println(respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    }

