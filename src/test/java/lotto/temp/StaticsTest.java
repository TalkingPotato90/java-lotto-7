package lotto.temp;

import lotto.Lotto;
import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StaticsTest {
    private Statics statics;

    @BeforeEach
    void setUp() {
        statics = new Statics(new CommonIo());
    }

    @Test
    @DisplayName("구입한 로또와 당첨번호가 몇 개 일치하는지 확인하는 테스트")
    void compareLottos(){
        assertThat(statics.compareLottos(
                List.of(new Lotto(List.of(1,2,3,4,5,6)),
                        new Lotto(List.of(1,2,3,4,5,7)),
                        new Lotto(List.of(1,2,3,4,7,8)),
                        new Lotto(List.of(1,2,3,7,8,9)),
                        new Lotto(List.of(1,2,7,8,9,10))),
                List.of(1,2,3,4,5,6))).containsExactly(6,5,4,3,2);
    }

    @Test
    @DisplayName("보너스 번호와 로또가 일치하는지 확인하는 테스트")
    void compareBonusNumber(){
        assertThat(statics.checkBonusNumber(new Lotto(List.of(1,2,3,4,5,6)),6)).isTrue();
        assertThat(statics.checkBonusNumber(new Lotto(List.of(1,2,3,4,5,6)),7)).isFalse();
    }

    @Test
    @DisplayName("일치하는 개수에 따라 올바른 등수를 나타내는지 확인하는 테스트")
    void confirmLottoRank(){
        assertThat(statics.determineRank(2,true)).isEqualTo("꽝");
        assertThat(statics.determineRank(3,true)).isEqualTo("5등");
        assertThat(statics.determineRank(4,true)).isEqualTo("4등");
        assertThat(statics.determineRank(5,false)).isEqualTo("3등");
        assertThat(statics.determineRank(5,true)).isEqualTo("2등");
        assertThat(statics.determineRank(6,true)).isEqualTo("1등");
    }

    @Test
    @DisplayName("등수 리스트를 받아서 당첨 개수를 제대로 나타내는지 확인하는 테스트")
    void checkRankingCount(){
        assertThat(statics.finalRank(List.of("5등","5등","5등","5등","꽝")))
                .containsEntry("5등",4)
                .containsEntry("꽝",1);
        assertThat(statics.finalRank(List.of("5등","4등","3등","5등","꽝")))
                .containsEntry("5등",2)
                .containsEntry("4등",1)
                .containsEntry("3등",1)
                .containsEntry("꽝",1);
    }

    @Test
    @DisplayName("수익률 계산을 제대로 하는지 확인하는 테스트")
    void calculateProfit(){
        assertThat(statics.calculateProfit(5000, 5000)).isEqualTo(100);
        assertThat(statics.calculateProfit(2000, 0)).isEqualTo(0);
        assertThat(statics.calculateProfit(10000, 5000)).isEqualTo(50);
        assertThat(statics.calculateProfit(3000, 10000)).isEqualTo(333.3f);
        assertThat(statics.calculateProfit(9000, 5000)).isEqualTo(55.6f);
    }
}