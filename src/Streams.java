import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {

//	Count the no of names starting with alphabet A
	@Test
	public void demo() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amit");
		names.add("Kumar");
		names.add("Akash");
		names.add("Donr");
		names.add("Amar");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A"))
				;
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
//	Above solution with java stream

	@Test
	public void demoStream() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amit");
		names.add("Kumar");
		names.add("Akash");
		names.add("Donr");
		names.add("Amar");
		long all = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(all);

//		Print all the names have length>4 
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

//		Print only one name have length 4>
		names.stream().filter(d -> d.length() > 4).limit(1).forEach(d -> System.out.println(d));

	}

	@Test
	public void streamMap() {
//		print names with last char as "t" and covert to Uppercase and create stream directly
		Stream.of("Amit", "Sugit", "Mohit", "Don", "Rohan").filter(s -> s.endsWith("t")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

//		print names which has first letter "a" with uppercase ans shorted
		List<String> names = Arrays.asList("Amit", "Sugit", "Mohit", "Don", "Rohan");
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));
	}

	@Test
	public void streamMearge() {
//		Mearging two different list and printin in shorted order

		ArrayList<String> names = new ArrayList<String>();
		names.add("mom");
		names.add("Kumar");
		names.add("Akash");

		List<String> names1 = Arrays.asList("Amit", "Sugit", "Mohit", "Don", "Rohan");
		Stream<String> newstream = Stream.concat(names.stream(), names1.stream());
		newstream.sorted().forEach(s -> System.out.print(s));

//		search Don is present or not 
		boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("don"));
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
//		do modification on list and again convert to list
		List<String> ls = Stream.of("Amit", "Sugit", "Mohit", "Don", "Rohan").filter(s -> s.endsWith("t"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());

//		pint the unique numbers in shorted order and print 3rd index famous interview question
		List<Integer> values = Arrays.asList(3, 3, 3, 4, 5, 6, 7, 7, 8, 8, 9);
		List<Integer> lst = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(lst.get(2));
	}

}
