package com.yash.practice.solution;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);

		// collect the result of a Stream into Set
		Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
		System.out.println(numberSet);

		// collect the result of a Stream into list
		List<Integer> numberList = numbers.stream().collect(Collectors.toList());
		System.out.println(numberList);

		// create Map from the elements of Stream (first remove the duplicates)
		Map<Integer, Integer> numberMap = numbers.stream().distinct().collect(Collectors.toMap(n -> n, n -> n));
		System.out.println(numberMap);

		// find summary statistics from a Stream of numbers
		IntSummaryStatistics numberSummaryStatistics = numbers.stream().mapToInt(num -> num).summaryStatistics();
		System.out.println(numberSummaryStatistics);

		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean, List<Integer>> partitionedList = numbers.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		System.out.println(partitionedList);

		// create comma separated string from numbers
		String commaSeparatedString = numbers.stream().map(n -> n.toString()).collect(Collectors.joining(","));
		System.out.println(commaSeparatedString);

	}
}
