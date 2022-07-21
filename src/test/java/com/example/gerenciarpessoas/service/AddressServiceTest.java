package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.Address;
import com.example.gerenciarpessoas.domain.AddressGenerator;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.domain.PersonGenerator;
import com.example.gerenciarpessoas.repository.AddressRepository;
import com.example.gerenciarpessoas.repository.PersonRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    private AddressRepository repository;
    @Mock
    private PersonService personService;
    @InjectMocks
    private AddressService service;


    @Test
    public void shouldSucessCreate() {
        Address address = AddressGenerator.buildCreateAddress();
        Person person = PersonGenerator.buildCreatePerson();

        Mockito.when(repository.save(any())).thenReturn(address);
        Mockito.when(personService.findByPersonId(any())).thenReturn(person);

        Address addressCreated = service.saveAddress(person.getId(), address);
        Assertions.assertEquals("Rua da Paz", addressCreated.getStreet());
        Assertions.assertEquals("40330370", addressCreated.getZipCode());
        Assertions.assertEquals(81, addressCreated.getNumber());
        Assertions.assertEquals("Salvador", addressCreated.getCity());
        Assertions.assertTrue(addressCreated.getMainAddress());

        Mockito.verify(repository, times(1)).save(any());

    }

}
