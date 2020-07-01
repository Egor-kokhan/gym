package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.SetEntity;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.entity.Visit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T19:27:10+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class CommonMapperImpl extends CommonMapper {

    @Override
    public GymnasticDTO gymnasticToGymnasticDto(Gymnastic source) {
        if ( source == null ) {
            return null;
        }

        GymnasticDTO gymnasticDTO = new GymnasticDTO();

        if ( source.getId() != null ) {
            gymnasticDTO.setId( source.getId() );
        }
        gymnasticDTO.setName( source.getName() );
        gymnasticDTO.setDescription( source.getDescription() );

        return gymnasticDTO;
    }

    @Override
    public Gymnastic gymnasticDtoToGymnastic(GymnasticDTO source) {
        if ( source == null ) {
            return null;
        }

        Gymnastic gymnastic = new Gymnastic();

        gymnastic.setId( source.getId() );
        gymnastic.setName( source.getName() );
        gymnastic.setDescription( source.getDescription() );

        return gymnastic;
    }

    @Override
    public List<GymnasticDTO> gymnasticToGymnasticDto(List<Gymnastic> source) {
        if ( source == null ) {
            return null;
        }

        List<GymnasticDTO> list = new ArrayList<GymnasticDTO>( source.size() );
        for ( Gymnastic gymnastic : source ) {
            list.add( gymnasticToGymnasticDto( gymnastic ) );
        }

        return list;
    }

    @Override
    public PersonDTO personToPersonDTO(Person source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( source.getId() );
        personDTO.setFirstName( source.getFirstName() );
        personDTO.setLastName( source.getLastName() );
        personDTO.setAge( source.getAge() );

        return personDTO;
    }

    @Override
    public Person personDtoToPerson(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        Person person = new Person();

        person.setVisits( visitDTOListToVisitList( source.getVisits() ) );
        person.setId( source.getId() );
        person.setFirstName( source.getFirstName() );
        person.setLastName( source.getLastName() );
        person.setAge( source.getAge() );

        return person;
    }

    @Override
    public List<PersonDTO> personToPersonDTO(List<Person> source) {
        if ( source == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( source.size() );
        for ( Person person : source ) {
            list.add( personToPersonDTO( person ) );
        }

        return list;
    }

    @Override
    public VisitDTO visitToVisitDto(Visit source) {
        if ( source == null ) {
            return null;
        }

        VisitDTO visitDTO = new VisitDTO();

        visitDTO.setId( source.getId() );
        visitDTO.setCreationDateTime( source.getCreationDateTime() );
        visitDTO.setPerson( personToPersonDTO( source.getPerson() ) );

        return visitDTO;
    }

    @Override
    public Visit visitDtoToVisit(VisitDTO source) {
        if ( source == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setId( source.getId() );
        visit.setCreationDateTime( source.getCreationDateTime() );
        visit.setPerson( personDtoToPerson( source.getPerson() ) );

        return visit;
    }

    @Override
    public List<VisitDTO> visitToVisitDto(List<Visit> source) {
        if ( source == null ) {
            return null;
        }

        List<VisitDTO> list = new ArrayList<VisitDTO>( source.size() );
        for ( Visit visit : source ) {
            list.add( visitToVisitDto( visit ) );
        }

        return list;
    }

    @Override
    public SetEntityDTO setEntityToSetEntityDto(SetEntity source) {
        if ( source == null ) {
            return null;
        }

        SetEntityDTO setEntityDTO = new SetEntityDTO();

        setEntityDTO.setId( source.getId() );
        setEntityDTO.setRepeats( source.getRepeats() );
        setEntityDTO.setWeight( source.getWeight() );

        return setEntityDTO;
    }

    @Override
    public SetEntity setEntityDtoToSetEntity(SetEntityDTO source) {
        if ( source == null ) {
            return null;
        }

        SetEntity setEntity = new SetEntity();

        setEntity.setId( source.getId() );
        setEntity.setRepeats( source.getRepeats() );
        setEntity.setWeight( source.getWeight() );

        return setEntity;
    }

    @Override
    public List<SetEntityDTO> setEntityToSetEntityDto(List<SetEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<SetEntityDTO> list = new ArrayList<SetEntityDTO>( source.size() );
        for ( SetEntity setEntity : source ) {
            list.add( setEntityToSetEntityDto( setEntity ) );
        }

        return list;
    }

    @Override
    public TrainingDTO trainingToTrainingDTO(Training source) {
        if ( source == null ) {
            return null;
        }

        TrainingDTO trainingDTO = new TrainingDTO();

        trainingDTO.setId( source.getId() );
        trainingDTO.setName( source.getName() );
        trainingDTO.setDescription( source.getDescription() );

        return trainingDTO;
    }

    @Override
    public Training trainingDtoToTraining(TrainingDTO source) {
        if ( source == null ) {
            return null;
        }

        Training training = new Training();

        training.setId( source.getId() );
        training.setName( source.getName() );
        training.setDescription( source.getDescription() );

        return training;
    }

    @Override
    public List<TrainingDTO> trainingToTrainingDTO(List<Training> source) {
        if ( source == null ) {
            return null;
        }

        List<TrainingDTO> list = new ArrayList<TrainingDTO>( source.size() );
        for ( Training training : source ) {
            list.add( trainingToTrainingDTO( training ) );
        }

        return list;
    }

    protected List<Visit> visitDTOListToVisitList(List<VisitDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Visit> list1 = new ArrayList<Visit>( list.size() );
        for ( VisitDTO visitDTO : list ) {
            list1.add( visitDtoToVisit( visitDTO ) );
        }

        return list1;
    }
}
