package lotto.temp;

import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    private Winning winning;

    @BeforeEach
    void setUp() {
        winning = new Winning(new CommonIo());
    }

    @Test
    @DisplayName("입력받은 당첨번호 콤마를 기준으로 분리")
    void separateWinningNumber(){
        assertThat(winning.createWinningNumbers("1,2,3,4,5,6"))
                .containsExactly(1,2,3,4,5,6);
        assertThat(winning.createWinningNumbers("3,5,14,26,34,45"))
                .containsExactly(3,5,14,26,34,45);
    }


}