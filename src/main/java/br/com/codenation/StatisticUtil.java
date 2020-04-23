package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int)IntStream.of(elements).average().getAsDouble();
	}

	public static int mode(int[] elements) {
		List<Integer> values = Arrays.stream(elements)
				.boxed()
				.collect(Collectors.toList());

		Integer ocorrence = 0;
		Integer mode = 0;

		for (Integer value : values) {
			int frequency = Collections.frequency(values, value);
			if (frequency > ocorrence) {
				ocorrence = frequency;
				mode = value;
			}
		}

		return mode;
	}

	public static int median(int[] elements) {
		List<Integer> values = Arrays.stream(elements)
				.boxed()
				.sorted()
				.collect(Collectors.toList());

		if (values.size() % 2 == 1) {
			return values.get((values.size() / 2));
		}

		return (values.get((values.size() / 2) - 1) + values.get((values.size() / 2))) / 2;
	}
}