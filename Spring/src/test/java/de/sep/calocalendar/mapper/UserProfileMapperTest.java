package de.sep.calocalendar.mapper;

import de.sep.calocalendar.entities.UserProfile;
import de.sep.calocalendar.model.UserProfileModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserProfileMapperTest {

    private final UserProfileMapper mapper = new UserProfileMapperImpl();

    private UserProfile entity;
    private UserProfileModel model;

    @BeforeEach
    void Setup(){

        model = new UserProfileModel();
        model.setId(1L);
        model.setUserName("TestUser");
        model.setAge(25);
        model.setWeight(75000);
        model.setGender(1);
        model.setLevelOfPhysicalActivity(2);

        entity = new UserProfile();
        entity.setId(1L);
        entity.setUserName("TestUser");
        entity.setAge(25);
        entity.setWeight(75000);
        entity.setGender(1);
        entity.setLevelOfPhysicalActivity(2);
    }

    @Test
    void toEntity_WhenModelProvided_ThenCorrectEntity() {
        var actual = mapper.toEntity(model);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(entity.getId());
        assertThat(actual.getUserName()).isEqualTo(entity.getUserName());
        assertThat(actual.getAge()).isEqualTo(entity.getAge());
        assertThat(actual.getWeight()).isEqualTo(entity.getWeight());
        assertThat(actual.getGender()).isEqualTo(entity.getGender());
        assertThat(actual.getLevelOfPhysicalActivity()).isEqualTo(entity.getLevelOfPhysicalActivity());
    }

    @Test
    void toModel_WhenEntityProvided_ThenCorrectModel() {
        var actual = mapper.toModel(entity);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(model.getId());
        assertThat(actual.getUserName()).isEqualTo(model.getUserName());
        assertThat(actual.getAge()).isEqualTo(model.getAge());
        assertThat(actual.getWeight()).isEqualTo(model.getWeight());
        assertThat(actual.getGender()).isEqualTo(model.getGender());
        assertThat(actual.getLevelOfPhysicalActivity()).isEqualTo(model.getLevelOfPhysicalActivity());
    }

}
