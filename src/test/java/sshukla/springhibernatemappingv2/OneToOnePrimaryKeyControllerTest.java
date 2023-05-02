package sshukla.springhibernatemappingv2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sshukla.springhibernatemappingv2.onetoone.controller.OneToOneForeignKeyController;
import sshukla.springhibernatemappingv2.onetoone.model.foreignkey.User;
import sshukla.springhibernatemappingv2.onetoone.model.foreignkey.UserProfile;
import sshukla.springhibernatemappingv2.onetoone.repo.UserProfileRepo;
import sshukla.springhibernatemappingv2.onetoone.repo.UserRepo;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by `Seemant Shukla` on 29-04-2023
 */
@ExtendWith(MockitoExtension.class)
public class OneToOnePrimaryKeyControllerTest {
    @Mock
    private UserRepo userRepo;

    @Mock
    private UserProfileRepo userProfileRepo;

    @InjectMocks
    private OneToOneForeignKeyController controller;

    @Test
    void createUser_shouldReturnUserWithProfile() {
        // given
        User user = new User();
        user.setName("John Doe");
        UserProfile profile = new UserProfile();
        profile.setPhoneNumber("234567890");
        user.setUserProfile(profile);

        String userId = UUID.randomUUID().toString();
        when(userRepo.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            savedUser.setId(userId);
            savedUser.getUserProfile().setId(UUID.randomUUID().toString());
            return savedUser;
        });

        // when
        ResponseEntity<User> response = controller.createUser(user);

        // then
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userId, response.getBody().getId());
        assertEquals(profile.getPhoneNumber(), response.getBody().getUserProfile().getPhoneNumber());

        verify(userRepo, times(1)).save(any(User.class));
    }

}
