package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

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
        Parking parking = new Parking(id, "KIZ-8909", "PE", "CORSA", "CINZA");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

//    nao fazer com que o bd gere automaticamente a chave, por padrao utiliza-se uma chave gerada pelo uuid do java
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
