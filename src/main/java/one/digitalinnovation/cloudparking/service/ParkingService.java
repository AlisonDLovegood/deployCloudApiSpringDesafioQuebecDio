package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.exception.ParkingNotFoundException;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    private static Map<String, Parking> parkingMap = new HashMap();

    public List<Parking> findAll(){
//        substituindo codigo antigo pelo novo do repositorio
        return parkingRepository.findAll();
//        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(()->
                new ParkingNotFoundException(id));
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking byId = findById(id);
        byId.setColor(parkingCreate.getColor());
        parkingRepository.save(byId);
        return byId;
    }

    public Parking exit(String id) {
//        recuperar id do carro
//        atualizar data de saida
//        calcular o valor
        return null;
    }
}
