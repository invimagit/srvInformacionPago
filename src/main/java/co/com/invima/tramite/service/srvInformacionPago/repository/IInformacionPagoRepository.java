package co.com.invima.tramite.service.srvInformacionPago.repository;

import co.com.invima.canonico.modeloCanonico.entities.tarifa.TarifaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;


@Repository
public interface IInformacionPagoRepository extends JpaRepository<TarifaDAO, Integer> {

    @Procedure("Tramite.USP_InformacionPagoTarifa_S")
    String consultarTarifaPorCodigo(String codigoTarifa);
/*
   @Procedure("Tramite.USP_InformacionTramite_S")
    String consultarPorCodigoBarra(String codigoPago);

   @Procedure("Tramite.USP_InformacionTramite_S")
    String consultarPorCodigoPSE(String codigoPago);

   @Procedure("Tramite.USP_InformacionTramite_S")
    String consultarPorCodigoGiroInternacional(String codigoTransferencia);


 */

}
