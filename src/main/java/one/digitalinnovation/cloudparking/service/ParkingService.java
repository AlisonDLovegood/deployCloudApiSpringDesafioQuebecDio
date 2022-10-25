package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.exception.ParkingNotFoundException;
import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {
//    como nao ha bd ainda, criei uma lista de dados
    private static Map<String, Parking> parkingMap = new HashMap();
//    inicializando ela com um registro
    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "KIZ-8909", "PE", "CORSA", "CINZA");
        Parking parking1 = new Parking(id1, "KIZ-8990", "PE", "CORSA", "PRETO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

//    nao fazer com que o bd gere automaticamente a chave, por padrao utiliza-se uma chave gerada pelo uuid do java
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
//        se nao existir ja entra na exception
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking byId = findById(id);
        byId.setColor(parkingCreate.getColor());
        parkingMap.replace(id, byId);
        return byId;
    }
}
