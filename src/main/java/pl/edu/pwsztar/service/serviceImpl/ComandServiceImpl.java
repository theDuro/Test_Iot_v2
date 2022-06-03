package pl.edu.pwsztar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.ComandDto;
import pl.edu.pwsztar.domain.dto.CreateComandDto;
import pl.edu.pwsztar.domain.entity.Comand;
import pl.edu.pwsztar.domain.mapper.AddComandMapper;
import pl.edu.pwsztar.domain.mapper.ComandListMapper;
import pl.edu.pwsztar.domain.mapper.GetComandDtoMaper;
import pl.edu.pwsztar.domain.repository.ComandRepository;

import java.util.List;

@Service
public class ComandServiceImpl implements ComandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComandServiceImpl.class);

    private final ComandRepository comandRepository;
    private final ComandListMapper comandListMapper;
    private final AddComandMapper addComandMapper;
    private final GetComandDtoMaper getComandDtoMaper;

    @Autowired
    public ComandServiceImpl(ComandRepository comandRepository,
                             ComandListMapper comandListMapper,
                             AddComandMapper addComandMapper, GetComandDtoMaper getComandDtoMaper) {

        this.comandRepository = comandRepository;
        this.comandListMapper = comandListMapper;
        this.addComandMapper = addComandMapper;
        this.getComandDtoMaper = getComandDtoMaper;
    }

    @Override
    public List<ComandDto> findAll() {
        List<Comand> comands = comandRepository.findAll();
        return comandListMapper.mapToDto(comands);
    }

    @Override
    public void addComand(CreateComandDto createComandDto) {
        comandRepository.save(addComandMapper.CreateComandDtoToComandDto(createComandDto));
    }

    @Override
    public void deleteComand(Long id) {
       comandRepository.deleteById(id);
    }

    


    @Override
    public void updateComand(CreateComandDto createComandDto, Long id)  throws NullPointerException  {
        if (id == null)

            throw new NullPointerException();
         Comand comand = addComandMapper.CreateComandDtoToComandDto(createComandDto);
         comand.setComandId(id);
         comandRepository.save(comand);
/*
        Comand comandToUpdate = comandRepository.getOne(id);
        comandToUpdate.setLedLimitedValue(ComandDto.getLedLimitedValue());
        comandToUpdate.setLedFrequency(ComandDto.getLedFrequency());
        comandToUpdate.setEnginePower(ComandDto.getEnginePower());
        comandRepository.save(comandToUpdate);
        System.out.print(comandToUpdate);
*/
    }



    @Override
    public ComandDto getComandDtoToIot() {
       Comand comand= comandRepository.getComandToIoT(comandRepository.count());
        return getComandDtoMaper.mapToDto(comandRepository.getComandToIoT(comandRepository.count()));


    }


}
