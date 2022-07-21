package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.AddressGenerator;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.domain.PersonGenerator;
import com.example.gerenciarpessoas.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    public void shouldSucessCreate() {
        Person person = PersonGenerator.buildCreatePerson();

        Mockito.when(repository.save(any())).thenReturn(person);

        Person personCreated = service.savePerson(person);

        Assertions.assertEquals("Anderson Santiago", personCreated.getName());
        Assertions.assertEquals(LocalDate.parse("2000-01-25"), personCreated.getBirthDate());

        Mockito.verify(repository, times(1)).save(any());
    }
    @Test
    public void shouldSucessUpdate() {
        Person person = PersonGenerator.buildUpdatePerson();

        Mockito.when(repository.save(any())).thenReturn(person);

        Person personCreated = service.savePerson(person);

        Assertions.assertEquals("Santiago Anderson", personCreated.getName());
        Assertions.assertEquals(LocalDate.parse("1999-12-20"), personCreated.getBirthDate());
        Assertions.assertEquals(AddressGenerator.buildCreateAddress(),personCreated.getAddress());

        Mockito.verify(repository, times(1)).save(any());
    }

}
