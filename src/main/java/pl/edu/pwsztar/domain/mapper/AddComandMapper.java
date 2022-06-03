package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateComandDto;
import pl.edu.pwsztar.domain.entity.Comand;

//niedokonczone
@Component
public class AddComandMapper {
    public Comand CreateComandDtoToComandDto(CreateComandDto createComandDto) {

        Comand comand = new Comand();
        comand.setEnginePower(createComandDto.getEnginePower());
        comand.setLedFrequency(createComandDto.getLedFrequency());
        comand.setLedLimitedValue(createComandDto.getLedLimitedValue());
        comand.setUserId(createComandDto.getUserId());


        return comand;
    }

}
