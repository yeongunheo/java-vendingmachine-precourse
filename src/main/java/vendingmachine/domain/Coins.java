package vendingmachine.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TEN = 10;
	private static final int FIFTIETH = 50;
	private static final int ONE_HUNDRED = 100;
	private static final int FIVE_HUNDRED = 500;
	private static final List coins = Arrays.asList(TEN, FIFTIETH, ONE_HUNDRED, FIVE_HUNDRED);

	private static final Map<Coin, Count> coinsCount;

	static {
		coinsCount = new LinkedHashMap<>();
		coinsCount.put(Coin.COIN_500, new Count(ZERO));
		coinsCount.put(Coin.COIN_100, new Count(ZERO));
		coinsCount.put(Coin.COIN_50, new Count(ZERO));
		coinsCount.put(Coin.COIN_10, new Count(ZERO));
	}

	public static Map<Coin, Count> moneyToCoins(String holdingMoney) {
		int moneySum = Integer.parseInt(holdingMoney);
		while (moneySum > 0) {
			int randomCoin = Randoms.pickNumberInList(coins);
			if (randomCoin <= moneySum) {
				coinsCount.put(Coin.of(randomCoin), coinsCount.get(Coin.of(randomCoin)).add(ONE));
				moneySum -= randomCoin;
			}
		}
		return coinsCount;
	}
}