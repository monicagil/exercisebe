package com.training.exercise;

import com.training.exercise.mapper.UserMapper;
import com.training.exercise.model.User;
import com.training.exercise.persistence.RepositoryResolver;
import com.training.exercise.persistence.UserRepository;
import com.training.exercise.service.UserService;
import com.training.exercise.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private RepositoryResolver repositoryResolver;
    @Mock
    private UserRepository userRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        given(repositoryResolver.get(UserRepository.class)).willReturn(userRepository);
        userService = new UserServiceImpl(repositoryResolver, Mappers.getMapper(UserMapper.class));
    }

    @Test
    public void testFindAll() {
        // Given
        PageRequest pageRequest = PageRequest.of(0, 20);
        given(userRepository.findAll(pageRequest))
                .willReturn(new PageImpl<>(new ArrayList<>(), pageRequest, 0));

        // When
        Page<User> result = userService.findAll(pageRequest);

        // Then
        assertNotNull(result);
        then(userRepository).should(times(1)).findAll(pageRequest);
    }

    @Test
    public void testFindById() {
        // Given
        Long optimizationId = 1L;
        given(userRepository.findById(optimizationId))
                .willReturn(Optional.of(new User()));

        // When
        User result = userService.findById(optimizationId);

        // Then
        assertNotNull(result);
        then(userRepository).should(times(1)).findById(optimizationId);
    }

    @Test
    public void testCreateUser() {
        // Given
        User newUser = new User();
        newUser.setName("name");
        newUser.setUserName("User name");
        newUser.setAge(11);
        newUser.setEmail("email@com.co");
        newUser.setGender(User.Sex.FEMALE);

        User persistedUser = new User();
        persistedUser.setName(newUser.getName());
        persistedUser.setUserName(newUser.getUserName());
        persistedUser.setAge(newUser.getAge());
        persistedUser.setId(1L);
        persistedUser.setEmail(newUser.getEmail());
        persistedUser.setGender(newUser.getGender());

        given(userRepository.save(any(User.class))).willReturn(persistedUser);

        // When
        User result = userService.createUser(newUser);

        // Then
        assertNotNull(result);
        assertEquals(result.getUserName(), persistedUser.getUserName());
        assertEquals(result.getName(), persistedUser.getName());
        assertEquals(result.getAge(), persistedUser.getAge());
        assertEquals(result.getEmail(), persistedUser.getEmail());
        assertEquals(result.getGender(), persistedUser.getGender());
        then(userRepository).should(times(1)).save(any(User.class));
    }
}
