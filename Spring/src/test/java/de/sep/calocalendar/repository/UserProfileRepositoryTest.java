package de.sep.calocalendar.repository;

import de.sep.calocalendar.entities.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository userProfileRepository;

    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfile();
        userProfile.setUserName("JohnDoe");
        userProfile.setGender(1);
        userProfile.setAge(30);
        userProfile.setWeight(75000);
        userProfile.setLevelOfPhysicalActivity(3);
    }

    @Test
    public void testCreateUserProfile() {
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        assertThat(savedUserProfile).isNotNull();
        assertThat(savedUserProfile.getId()).isNotNull();
    }

    @Test
    public void testFindUserProfileById() {
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        Optional<UserProfile> fetchedUserProfile = userProfileRepository.findById(savedUserProfile.getId());
        assertThat(fetchedUserProfile).isPresent();
        assertThat(fetchedUserProfile.get().getUserName()).isEqualTo(userProfile.getUserName());
    }

    @Test
    public void testFindAllUserProfiles() {
        userProfileRepository.save(userProfile);

        UserProfile anotherUserProfile = new UserProfile();
        anotherUserProfile.setUserName("JaneDoe");
        anotherUserProfile.setGender(1);
        anotherUserProfile.setAge(28);
        anotherUserProfile.setWeight(65000);
        anotherUserProfile.setLevelOfPhysicalActivity(2);

        userProfileRepository.save(anotherUserProfile);

        List<UserProfile> userProfiles = userProfileRepository.findAll();
        assertThat(userProfiles).hasSize(2);
    }

    @Test
    public void testUpdateUserProfile() {
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        savedUserProfile.setUserName("UpdatedName");
        UserProfile updatedUserProfile = userProfileRepository.save(savedUserProfile);
        assertThat(updatedUserProfile.getUserName()).isEqualTo("UpdatedName");
    }

    @Test
    public void testDeleteUserProfile() {
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        userProfileRepository.deleteById(savedUserProfile.getId());
        Optional<UserProfile> deletedUserProfile = userProfileRepository.findById(savedUserProfile.getId());
        assertThat(deletedUserProfile).isNotPresent();
    }
}
