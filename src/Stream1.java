import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Stream1 {
	
	//@Test
	public void regular() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vikram");
		names.add("Ram");
		names.add("Aom");
		names.add("Aanu");
		names.add("Drishya");
		names.add("Anny");
		
		int count = 0;
		for(int i =0; i < names.size();i++)
		{
			
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}			
		}
		System.out.println(count);
		
	}
	
	//@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vikram");
		names.add("Ram");
		names.add("Aom");
		names.add("Aanu");
		names.add("Drishya");
		names.add("Anny");
		
		//There is no life for intermediate operation if there is no terminal operation
		//Terminal operation will execute only if inter operation (filter) returns true
		//we can create stream
		//how to use filter in stream API
		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		//Alternate solutions
		long d = Stream.of("Vikram","Tana","Nana","Aanu","Drishya","Anny").filter(s ->
				{
					 s.startsWith("A");
					 return true;
					 
				}).count();
		System.out.println(d);
		//print all the names of arrayList
		names.stream().filter(s -> s.length()>4).forEach(s-> System.out.println(s));
		names.stream().filter(s -> s.length()>4).limit(1).forEach(s-> System.out.println(s));
	}
	
	//@Test
	public void streamMp()
	{	
		ArrayList<String> names1= new ArrayList<String>();
		names1.add("man");
		names1.add("don");
		names1.add("women");
		
		
		//print names which have last letter as "a" with uppercase
		Stream.of("Vikram","Tana","Nana","Aanu","Drishya","Anny").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
		.forEach(s-> System.out.println(s));
		
		List<String> names= Arrays.asList("Vikram","Tana","Nana","Aanu","Drishya","Anny");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		//Merging two different lists
		Stream<String> newStream = Stream.concat(names1.stream(), names.stream());
		//newStream.sorted().forEach(s->System.out.println("Concated: "+ s));
		
		boolean flag = newStream.anyMatch(s-> s.equalsIgnoreCase("Drishya"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Vikram","Tana","Nana","Aanu","Drishya","Anny").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//This is the most important question for interview
		
		List<Integer> values= Arrays.asList(5,6,9,3,7,3,5,7,6,6);
		//print unique number from this array
		//sort the array
		values.stream().distinct().forEach(s-> System.out.println("Unique number: "+s));
		
		//sorted and print the second value
		List<Integer> ls2= values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Sorted value: "+ls2);
		
		System.out.println("Second value: "+ls2.get(2));
	}
	
	
	
	
	
	
}
