package co.com.invima.tramite.service.srvInformacionPago.commons.converter;

import co.com.invima.canonico.modeloCanonico.dto.tarifa.TarifaDTO;
import co.com.invima.canonico.modeloCanonico.dto.tramite.TramiteDTO;
import co.com.invima.canonico.modeloCanonico.entities.tarifa.TarifaDAO;
import co.com.invima.canonico.modeloCanonico.entities.tramite.TramiteDAO;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InfoPagoConverter {


    /**
     * @param tarifaDAO
     * @return tarifaDTO
     * @author Cruiz
     * method to convert TarifaDAO to ´TarifaDTO
     */
    public TarifaDTO tarifaDAOtoDTO(TarifaDAO tarifaDAO, ModelMapper modelMapper) {
        TarifaDTO tarifaDTO = new TarifaDTO();
        modelMapper.map(tarifaDAO, tarifaDTO);
        return tarifaDTO;

    }


    /**
     * @param tarifaDTO
     * @return tarifaDAO
     * @author JBermeo
     * method to convert TramiteDTO to TramiteDAO
     */
    public TarifaDAO tarifaDTOtoDAO(TarifaDTO tarifaDTO,
                                    ModelMapper modelMapper) throws NotFoundException {
        TarifaDAO tarifaDAO = new TarifaDAO();
        modelMapper.map(tarifaDTO, tarifaDAO);

        return tarifaDAO;
    }
}
