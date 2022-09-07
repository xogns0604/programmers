package Study;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

////�����ڷ�
//https://futurecreator.github.io/2018/08/26/java-8-streams/

////��Ʈ���� ��� ���� 
/*��Ʈ�� ����� for-loop���� �ǹ̰� �������� 
Collection�� �Ǵ� ��Ʈ�� �ҽ��� ũ�Ⱑ ����� ũ�ų�, ��ǻ�� ������ CPU-intensive�� ������ ����� �ſ� ��ξ� �Ѵ�. 
���� ��Ʈ���� ����Ϸ���, ��Ʈ�� �ҽ��� Collection�� split�ϱ� ���� �ڷ� �����̾�� �ϸ�, �����ؼ��� ������ stateful���� �ʾƾ� �Ѵ�.
*/
//�������� ���� ���������� �����ϱ� ������ �ӵ�,�����ս��� �ֿ��� ��Ȳ�� �ƴ϶�� ����� ���� ���
//https://jypthemiracle.medium.com/java-stream-api%EB%8A%94-%EC%99%9C-for-loop%EB%B3%B4%EB%8B%A4-%EB%8A%90%EB%A6%B4%EA%B9%8C-50dec4b9974b

//interface Collection<E> extends Iterable<E>{
//	default Stream<E> stream(){
//		return StreamSupport.stream(spliterator(), false);
//	}
//}

public class streamStudy {

	public static void main(String[] args) throws IOException {
	
	//�����ϱ�
		//�迭��Ʈ��
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> st = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//�÷��� ��Ʈ��
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> st2 = list.stream();
		Stream<String> pS = list.parallelStream();
		
		//Stream.builder() : builder�� ����� ���ϴ� ���� ���� ����
		Stream<String> bS = Stream.<String>builder().add("Eric").add("Elena").build();
		
		//Stream.generate() : Supplier�� �ش��ϴ� ���ٷ� ���� ����, ���ٿ��� �����ϴ� ���� ��
		//                     -> ���� ���� ���ϰ��� �ִ� �Լ��� �������̽�
		Stream<String> geS = Stream.generate(() -> "gen").limit(5);
		
		//Stream.iterate() : �ʱⰩ�Ұ� �ش簪�� �ٷ�� ���ٸ����� ��Ʈ���� �� ��Ҹ� ����
		Stream<Integer> iterStream = Stream.iterate(30, n -> n+2).limit(5);
		
		//�⺻Ÿ���� ��Ʈ�� : int,long,double 
		IntStream intS = IntStream.range(1, 5); // �ι��� ���� ����x
		LongStream logS = LongStream.rangeClosed(1, 5); // �ι��� ���� ����

			//���׸��� ������ϱ⿡ ����ȿ�� ����ڽ��� ������ �ʿ��Ѱ�� ��밡��
		Stream<Integer> boxedIS = IntStream.range(1, 5).boxed();
			//�����ε� ���������
		DoubleStream doubles = new Random().doubles(3);
		
		//���ڿ� ��Ʈ�� : char�� ���������� �����̱⶧���� ����
		IntStream charsStream = "Stream".chars();
			//����ǥ�������� ���ڿ��� �ڸ��� ����ҵ�� ��Ʈ���� ����
		Stream<String> stringS = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
		
		//���Ͻ�Ʈ�� : filesŬ������ lines �޼ҵ�� �����ǰ� ������ ��Ʈ�� Ÿ���� ��Ʈ������ �������
		File file = new File("file.txt");
		FileWriter fw = new FileWriter(file ,true);
		fw.write("dsfsdfdsf");
		fw.close();
		Stream<String> lineS = Files.lines(Paths.get("file.txt"),Charset.forName("UTF-8"));
		
		//���Ľ�Ʈ�� : ������ ó���� ���� Fork/Join framework�� ���
		ArrayList<Product> productList = new ArrayList<Product>();
		Stream<Product> parallelSt = productList.parallelStream();
		boolean isPar = parallelSt.isParallel();
		System.out.println(isPar);
		
			//�� �۾��� �����带 ���� ����ó��
		boolean isMany = parallelSt.map(product -> product.getAmount() * 10).anyMatch(amount -> amount > 200);
			//���Ľ�Ʈ���� ����
		Arrays.stream(arr).parallel();
			//�÷���,�迭 �ƴϸ� �Ʒ�ó�� ���
		IntStream intSt = IntStream.range(1, 150).parallel();
		boolean isParallel = intSt.isParallel();
			//�ٽ� �����ȸ��
		intSt = intSt.sequential();
		boolean isParallel2 = intSt.isParallel();
		System.out.println(isParallel2);
		
		//��Ʈ�� ���� : stream.concat�� �̿�
		Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
		Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
		Stream<String> concat = Stream.concat(stream1, stream2);
		
	//�����ϱ� : �߰��ܰ��۾� ��Ʈ���� �����ϱ⶧���� �����۾��� �ٿ��� �ۼ�����
		List<String> names = Arrays.asList("Eric", "Elena", "Java");

		//Filtering : ��Ʈ���� ��ҵ��� �ϳ��� �ɷ������۾� predicate boolean�� �����ϴ� �Լ��� �������̽�
		Stream<String> stream = names.stream().filter(name -> name.contains("a"));
		
		//Mapping : ��Ʈ���� ���ִ� ���� input�Ǽ� ������ ��ģ�� output�Ǿ� ���ο� ��Ʈ���� ���
			//map : ��Ʈ���� ��ҵ��� �ϳ��� Ư�������� ����. ������ȯ�ϱ� ���� ���ٸ� ���ڷ� ����
		Stream<String> stream3 = names.stream().map(String::toUpperCase);

			//��ü�� �ν��Ͻ��� ����������
		Stream<Integer> stream4 = productList.stream().map(Product::getAmount);
	
			//flatMap: ���ڷ� mapper, ������ Stream. ��ø������ �Ѵܰ� ������ ���� �÷��� flattening�̶�� �θ�
		List<List<String>> list1 = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"));
		List<String> flatList = list1.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
			//��ü���� ���� ���� //ifPresent(null�� �ƴѰ�� �����ϴ� �������ڵ��̰� isPresent�� �ٸ��� ���ٽ� Ȱ�� ����
		/*students.stream()
			.flatMapToInt(student -> 
                IntStream.of(student.getKor(), student.getEng(), student.getMath()))
            .average().ifPresent(avg -> System.out.println(Math.round(avg * 10)/10.0));
        intS.average().ifPresent(avg -> System.out.println(Math.round(avg*10)/10.0));*/
        
		//Sorting : ������ comparator�� ���
			//���ھ��� ȣ��
        List list5 = IntStream.of(14, 11, 20, 39, 23).sorted().boxed().collect(Collectors.toList());
       	
       		//���� �ѱ�� ȣ��
       	List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
       	List<String> lang2 = lang.stream().sorted().collect(Collectors.toList());
       	List<String> lang3 = lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
       	
       		//���ڿ� ���� ���� ����
       	List<String> lang4 = lang.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
       	List<String> lang5 = lang.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList());

			//Iterating : ��Ʈ���� ��ҵ��� ���� Ư����������ϴ� �޼ҵ�� peek�� ���� consumer�� ���ڷ� ����
		int sum = IntStream.of(1,3,5,7,9).peek(System.out::print).sum();
		System.out.println();
		
		//�������� : ��Ʈ���� ������ �����۾�. ������ ��Ʈ���� ������ ����� ��������� ������ �ܰ�
			//Calculating : �ּ�, �ִ�, ��, ��� �� �⺻�� Ÿ������ ��� ��ȯ
		long count = IntStream.of(1,3,5,7,9).count();
		long sum1 = LongStream.of(1,3,5,7,9).sum();
		OptionalInt min = IntStream.of(1,3,5,7,9).min(); //optional : ���ེƮ���� ����־� ǥ���Ҽ� ������� ���
		OptionalInt max = IntStream.of(1,3,5,7,9).max();
		
		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5).average().ifPresent(System.out::println);
		
			//Reduction : ��Ʈ���� ���� ��Ҹ� ������ �������, ������ �Ķ���͸� ����
				//1.accumulator: �� ��Ҹ� ó���ϴ� ��� ����
		OptionalInt reduced = IntStream.range(1, 4).reduce((a,b) -> {return Integer.sum(a, b);});
				//2.identity: �ʱⰪ
		int reducedTwoP = IntStream.range(1, 4).reduce(10, Integer::sum);
				//3.combiner:���Ľ�Ʈ������ ���� ����� ����� �ϳ��� ��ġ�� ����, ���Ľ�Ʈ�������� ����
		Integer reducedParallel = Arrays.asList(1,2,3).parallelStream().reduce(10, Integer::sum,
			(a,b) -> {
				System.out.println("combiner was called");
				return a+b;
			});
		
			//Collecting : collectorŸ���� ���ڸ��޾Ƽ� ó��, Collectors ��ü���� ����
				//����
		List<Product> productList2 = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
		
			//Collectors.toList() : ��Ʈ�� �۾������ ����Ʈ�� ��ȯ
		List<String> collec = productList2.stream().map(Product::getName).collect(Collectors.toList());
		Stream<Integer> collec1 = productList2.stream().map(Product::getAmount);
		
			//Collectors.joining() : �۾������ �ϳ��� ���ڿ��� ��ȯ. ������ ���ڸ� ��ȯ
				//1.delimiter : ����� �߰��� �� ��Ҹ� ���н����ִ� ������
				//2.prefix: ��� �Ǿտ� �ٴ� ����
				//3.suffix: ��� �ǵڿ� �ٴ� ����
		String listTS = productList2.stream().map(Product::getName).collect(Collectors.joining(",", "<", ">"));
//		Map TS1 = productList2.stream().map(Product::getName)
//		System.out.println(TS1.keySet());
		
			//Collectors.averageInt() : ���ڰ��� ��� ��ȯ
		Double aver = productList2.stream().collect(Collectors.averagingInt(Product::getAmount));
			
			//Collectors.summingInt() : ��������
		int colecSum = productList2.stream().collect(Collectors.summingInt(Product::getAmount));
		int colecSum2 = productList2.stream().mapToInt(Product::getAmount).sum();
			
			
			//Collectors.summarizingInt() : �հ�� ��� ���
		IntSummaryStatistics statistics = productList2.stream().collect(Collectors.summarizingInt(Product::getAmount));
				//{count=5, sum=86, min=13, average=17.200000, max=23} �̷������� ������ ���
				//�� ��Ҵ� .get~~()�� �ҷ��ü� ����
				
			//Collectors.groupBy() : Ư���������� ��Ҹ� �׷�����. �޴� ���ڴ� �Լ��� �������̽� Function
				//��Ÿ���̸� ���� ������ ����Ʈ�� ��� ������
		Map<Integer, List<Product>> collMOL = productList2.stream().collect(Collectors.groupingBy(Product::getAmount));

			//Collectors.partitioningBy() : �Լ��� �������̽� Predicate�� �޾� boolean���� ����
				//true false�� ���� ����Ʈ�� ��� ������
		Map<Boolean, List<Product>> collPB = productList2.stream().collect(Collectors.partitioningBy(num -> num.getAmount() > 15));
		
			//Collectors.collectingAndThen() : ����� collect�� ���Ŀ� �߰��۾��� �ʿ��� ���� ������ ���� ����
		Set<Product> unmodiSet = productList2.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		
			//Collector.of() : �ʿ��� ������ ������ ���� ����
		Collector<Product, ?, LinkedList<Product>> toLinkedList = 
 			 Collector.of(LinkedList::new, 
               			  LinkedList::add, 
               			  (first, second) -> {first.addAll(second);return first;});
		LinkedList<Product> linkedPersons = productList2.stream().collect(toLinkedList);

		//Matching : ���� predicate���޾� ������ �����ϴ� ��� �ִ��� üũ�� ��� ����. 3���� �޼ҵ尡 ����
		List<String> names2 = Arrays.asList("Eric", "Elena", "Java");
			//1. �ϳ��� ������ �����ϴ� ��Ұ� �ִ��� anyMatch()
		boolean anyMatch = names2.stream().anyMatch(name -> name.contains("a"));
			//2. ������ǟ� �����ϴ���			 allMatch()
		boolean allMatch = names2.stream().allMatch(name -> name.length()>3);
			//3. ������ǟ� �������� �ʴ���         noneMatch()
		boolean noneMatch = names2.stream().noneMatch(name -> name.endsWith("s"));
	
		
		//Iterating : foreach�� ���� �����۾� sysout �޼ҵ带 �Ѱ� ����� ����ҋ� ���. peek�� �߰��۾��̶�� ����
		names.stream().forEach(System.out::println);
		
	}
}



























