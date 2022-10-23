package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

//      responsavel por fazer a conversao
@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO parkingDTO(Parking parking){
//        com a dependencia do mapper é possivel:
//        basta essa linha para pegar o objeto e passar todos os atributos para o outro objeto
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

//    precisa converter a lista, começa convetendo um objeto
    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingsList) {
        return null;
    }
}
