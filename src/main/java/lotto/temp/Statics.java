package lotto.temp;

import lotto.model.Lotto;
import lotto.util.CommonIo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statics {
    private final CommonIo io;

    public Statics(CommonIo io) {
        this.io = io;
    }

    public void printStaticsFormat(){
        io.printMessage("당첨 통계");
        io.printMessage("---");
    }

    // TODO : 일치 숫자 계산과 결과를 리스트로 만드는 기능의 분리 필요
    public List<Integer> compareLottos(List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matches = new ArrayList<>();

        lottos.forEach(lotto -> {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            matches.add(matchCount);
        });

        return matches;
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    // TODO : 반환형 수정 필요할 수 있음
    public String determineRank(int matchCount, boolean isBonusContain) {
        String rank = "";

        if (matchCount < 3) {
            return "꽝";
        }
        if (matchCount == 3){
            return "5등";
        }
        if (matchCount == 4){
            return "4등";
        }
        if (matchCount == 5 && !isBonusContain){
            return "3등";
        }
        if (matchCount == 5 && isBonusContain){
            return "2등";
        }
        if (matchCount == 6){
            return "1등";
        }

        return rank;
    }

    // TODO : 심각!!!
    public Map<String,Integer> finalRank(List<String> ranking){
        Map<String,Integer> ranks = new HashMap<>();
        int noRank = 0;
        int rank5 = 0;
        int rank4 = 0;
        int rank3 = 0;
        int rank2 = 0;
        int rank1 = 0;

        for (String s : ranking) {
            if (s.equals("꽝")) {
                noRank++;
            }
            if (s.equals("5등")) {
                rank5++;
            }
            if (s.equals("4등")) {
                rank4++;
            }
            if (s.equals("3등")) {
                rank3++;
            }
            if (s.equals("2등")) {
                rank2++;
            }
            if (s.equals("1등")) {
                rank1++;
            }
        }

        ranks.put("꽝",noRank);
        ranks.put("5등",rank5);
        ranks.put("4등",rank4);
        ranks.put("3등",rank3);
        ranks.put("2등",rank2);
        ranks.put("1등",rank1);

        return ranks;
    }

    public void printWinningResult(int matchCount, int prize, int rankCount){
        io.printMessage(matchCount +"개 일치 (" + prize + "원) - " + rankCount + "개");
    }

    public float calculateProfit(int money, int totalPrize){
        float profit = ((float)totalPrize / money) * 100;
        return Math.round(profit * 10) / 10.0f;
    }

    public void printProfit(float profit) {
        io.printMessage("총 수익률은 " + profit + "%입니다.");
    }
}
