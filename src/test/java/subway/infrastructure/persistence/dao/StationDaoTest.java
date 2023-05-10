package subway.infrastructure.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import subway.common.RepositoryTest;
import subway.infrastructure.persistence.entity.StationEntity;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("StationDao 은(는)")
@RepositoryTest
class StationDaoTest {

    private final StationEntity stationEntity = new StationEntity("미역");

    @Autowired
    private StationDao stationDao;

    @Test
    void 역을_저장한다() {
        // when
        stationDao.save(stationEntity);

        // then
        assertThat(stationDao.findByName("미역")).isPresent();
    }

    @Test
    void 역을_조회한다() {
        // given
        stationDao.save(stationEntity);

        // when & then
        assertThat(stationDao.findByName("미역")).isPresent();
    }

    @Test
    void 역이_없는_경우() {
        // when & then
        assertThat(stationDao.findByName("미역")).isEmpty();
    }
}
