package lotto.temp;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.CommonIo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTemp {
    private final CommonIo io;

    public LottoTemp(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase() {
        io.printMessage("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount() {
        return io.receiveInput();
    }

    public int convertInputToInt(String input) {
        return io.convertStringToInt(input);
    }

    public int convertMoneyToTicket(int amount) {
        return amount / 1000;
    }

    public Lotto createSingleLotto() {
        List<Integer> singleLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(singleLottoNumber);
    }

    public List<Lotto> createMultipleLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }

    public void printTicketCount(int ticketCount){
        io.printMessage(ticketCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottoNumbers(List<Lotto> lottos){
        lottos.forEach(lotto -> io.printMessage(lotto.toString()));
    }

    public void printRequestWinningNumbers(){
        io.printMessage("당첨 번호를 입력해 주세요.");
    }

    public String inputWinningNumbers() {
        return io.receiveInput();
    }


    // TODO: 문자열 분리와 정수 리스트 변경을 한번에 하고 있음. 수정 필요
    public List<Integer> createWinningNumbers(String rawWinningNumbers) {
        String[] numbers = rawWinningNumbers.split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public void printRequestBonusNumber(){
        io.printMessage("보너스 번호를 입력해 주세요.");
    }

    public String inputBonusNumber() {
        return io.receiveInput();
    }

    public void printStaticsFormat(){
        io.printMessage("당첨 통계");
        io.printMessage("---");
    }

    public void printProfit(int profit) {
        io.printMessage("총 수익률은 " + profit + "%입니다.");
    }
}
