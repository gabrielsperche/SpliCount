package splitec.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import splitec.entities.Entrada;
import splitec.entities.Saida;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Utils {
    public static List<Entrada> entradaEncodedToList(String encoded) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = new String(Base64.getDecoder().decode(encoded));
        List<Entrada> dataList = Arrays.asList(objectMapper.readValue(data, Entrada[].class));
        return dataList;
    }

    public static List<Saida> saidaEncodedToList(String encoded) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = new String(Base64.getDecoder().decode(encoded));
        List<Saida> dataList = Arrays.asList(objectMapper.readValue(data, Saida[].class));
        return dataList;
    }
}
