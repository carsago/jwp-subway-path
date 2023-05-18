package subway.domain.fee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import subway.domain.Line;


@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("LineFeePolicy 은(는)")
class LineFeePolicyTest {

    private final LineFeePolicy lineFeePolicy = new LineFeePolicy();
    
    @Test
    void 노선의_추가_요금이_없으면_기본_요금을_반환한다() {
        // given
        FeeInformation feeInformation = new FeeInformation(10,
                List.of(
                        new Line("1호선", null, 0),
                        new Line("2호선", null, 0)
                )
        );

        // when
        int fee = lineFeePolicy.calculate(feeInformation);

        // then
        assertThat(fee).isEqualTo(0);
    }

    @Test
    void 여러_노선중_추가_요금이_가장_높은_노선을_반영한다() {
        // given
        FeeInformation feeInformation = new FeeInformation(10,
                List.of(
                        new Line("1호선", null, 100),
                        new Line("2호선", null, 200),
                        new Line("3호선", null, 300)
                )
        );
        // when
        int fee = lineFeePolicy.calculate(feeInformation);

        // then
        assertThat(fee).isEqualTo(300);
    }
}
