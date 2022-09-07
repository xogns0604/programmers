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

////참고자료
//https://futurecreator.github.io/2018/08/26/java-8-streams/

////스트림의 사용 이유 
/*스트림 사용이 for-loop보다 의미가 있으려면 
Collection이 되는 스트림 소스의 크기가 충분히 크거나, 컴퓨팅 연산이 CPU-intensive할 정도로 비용이 매우 비싸야 한다. 
병렬 스트림을 사용하려면, 스트림 소스인 Collection은 split하기 쉬운 자료 구조이어야 하며, 웬만해서는 연산이 stateful하지 않아야 한다.
*/
//가독성이 좋고 유지보수가 용이하기 때문에 속도,퍼포먼스가 주요한 상황이 아니라면 사용을 적극 고려
//https://jypthemiracle.medium.com/java-stream-api%EB%8A%94-%EC%99%9C-for-loop%EB%B3%B4%EB%8B%A4-%EB%8A%90%EB%A6%B4%EA%B9%8C-50dec4b9974b

//interface Collection<E> extends Iterable<E>{
//	default Stream<E> stream(){
//		return StreamSupport.stream(spliterator(), false);
//	}
//}

public class streamStudy {

	public static void main(String[] args) throws IOException {
	
	//생성하기
		//배열스트림
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> st = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//컬렉션 스트림
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> st2 = list.stream();
		Stream<String> pS = list.parallelStream();
		
		//Stream.builder() : builder를 사용해 원하는 값을 직접 넣음
		Stream<String> bS = Stream.<String>builder().add("Eric").add("Elena").build();
		
		//Stream.generate() : Supplier에 해당하는 람다로 값을 넣음, 람다에서 리턴하는 값이 들어감
		//                     -> 인자 없고 리턴값만 있는 함수형 인터페이스
		Stream<String> geS = Stream.generate(() -> "gen").limit(5);
		
		//Stream.iterate() : 초기갑소가 해당값을 다루는 람다를통해 스트림에 들어갈 요소를 만듬
		Stream<Integer> iterStream = Stream.iterate(30, n -> n+2).limit(5);
		
		//기본타입형 스트림 : int,long,double 
		IntStream intS = IntStream.range(1, 5); // 두번쨰 인자 포함x
		LongStream logS = LongStream.rangeClosed(1, 5); // 두번쨰 인자 포함

			//제네릭을 사용한하기에 불필효한 오토박싱은 없지만 필요한경우 사용가능
		Stream<Integer> boxedIS = IntStream.range(1, 5).boxed();
			//난수로도 만들수있음
		DoubleStream doubles = new Random().doubles(3);
		
		//문자열 스트림 : char은 문자이지만 숫자이기때문에 가능
		IntStream charsStream = "Stream".chars();
			//정규표현식으로 문자열을 자르고 각요소들로 스트림을 만듬
		Stream<String> stringS = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
		
		//파일스트림 : files클래스의 lines 메소드는 파일의각 라인을 스트링 타입의 스트림으로 만들어줌
		File file = new File("file.txt");
		FileWriter fw = new FileWriter(file ,true);
		fw.write("dsfsdfdsf");
		fw.close();
		Stream<String> lineS = Files.lines(Paths.get("file.txt"),Charset.forName("UTF-8"));
		
		//병렬스트림 : 쓰레드 처리를 위해 Fork/Join framework를 사용
		ArrayList<Product> productList = new ArrayList<Product>();
		Stream<Product> parallelSt = productList.parallelStream();
		boolean isPar = parallelSt.isParallel();
		System.out.println(isPar);
		
			//각 작업을 쓰레드를 통해 병렬처리
		boolean isMany = parallelSt.map(product -> product.getAmount() * 10).anyMatch(amount -> amount > 200);
			//병렬스트림을 생성
		Arrays.stream(arr).parallel();
			//컬렉션,배열 아니면 아래처럼 사용
		IntStream intSt = IntStream.range(1, 150).parallel();
		boolean isParallel = intSt.isParallel();
			//다시 시퀀셜모드
		intSt = intSt.sequential();
		boolean isParallel2 = intSt.isParallel();
		System.out.println(isParallel2);
		
		//스트림 연결 : stream.concat을 이용
		Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
		Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
		Stream<String> concat = Stream.concat(stream1, stream2);
		
	//가공하기 : 중간단계작업 스트림을 리턴하기때문에 여러작업을 붙여서 작성가능
		List<String> names = Arrays.asList("Eric", "Elena", "Java");

		//Filtering : 스트림내 요소들을 하나씩 걸래내는작업 predicate boolean을 리턴하는 함수형 인터페이스
		Stream<String> stream = names.stream().filter(name -> name.contains("a"));
		
		//Mapping : 스트림에 들어가있는 값이 input되서 로직을 거친구 output되어 새로운 스트림에 담김
			//map : 스트림내 요소들을 하나씩 특정값으로 변경. 값을변환하기 위한 람다를 인자로 받음
		Stream<String> stream3 = names.stream().map(String::toUpperCase);

			//객체의 인스턴스도 꺼낼수있음
		Stream<Integer> stream4 = productList.stream().map(Product::getAmount);
	
			//flatMap: 인자로 mapper, 리턴은 Stream. 중첩구조롤 한단계 제거후 단일 컬렉션 flattening이라고 부름
		List<List<String>> list1 = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"));
		List<String> flatList = list1.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
			//객체에도 적용 가능 //ifPresent(null이 아닌경우 실행하는 간결한코드이고 isPresent랑 다르게 람다식 활용 가능
		/*students.stream()
			.flatMapToInt(student -> 
                IntStream.of(student.getKor(), student.getEng(), student.getMath()))
            .average().ifPresent(avg -> System.out.println(Math.round(avg * 10)/10.0));
        intS.average().ifPresent(avg -> System.out.println(Math.round(avg*10)/10.0));*/
        
		//Sorting : 정렬은 comparator를 사용
			//인자없이 호출
        List list5 = IntStream.of(14, 11, 20, 39, 23).sorted().boxed().collect(Collectors.toList());
       	
       		//인자 넘기고 호출
       	List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
       	List<String> lang2 = lang.stream().sorted().collect(Collectors.toList());
       	List<String> lang3 = lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
       	
       		//문자열 길이 기준 정렬
       	List<String> lang4 = lang.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
       	List<String> lang5 = lang.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList());

			//Iterating : 스트림내 요소들을 각각 특정연상수행하는 메소드로 peek이 있음 consumer을 인자로 받음
		int sum = IntStream.of(1,3,5,7,9).peek(System.out::print).sum();
		System.out.println();
		
		//결과만들기 : 스트림을 끝내는 최종작업. 가공한 스트림을 가지고 사용할 결과값으로 만들어내는 단계
			//Calculating : 최소, 최대, 합, 평균 등 기본형 타입으로 결과 반환
		long count = IntStream.of(1,3,5,7,9).count();
		long sum1 = LongStream.of(1,3,5,7,9).sum();
		OptionalInt min = IntStream.of(1,3,5,7,9).min(); //optional : 만약스트림이 비어있어 표현할수 없을경우 사용
		OptionalInt max = IntStream.of(1,3,5,7,9).max();
		
		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5).average().ifPresent(System.out::println);
		
			//Reduction : 스트림의 여러 요소를 가지고 결과를냄, 세가지 파라미터를 받음
				//1.accumulator: 각 요소를 처리하는 계산 로직
		OptionalInt reduced = IntStream.range(1, 4).reduce((a,b) -> {return Integer.sum(a, b);});
				//2.identity: 초기값
		int reducedTwoP = IntStream.range(1, 4).reduce(10, Integer::sum);
				//3.combiner:병렬스트림에서 나눠 계산한 결과를 하나로 합치는 동작, 병렬스트림에서만 동작
		Integer reducedParallel = Arrays.asList(1,2,3).parallelStream().reduce(10, Integer::sum,
			(a,b) -> {
				System.out.println("combiner was called");
				return a+b;
			});
		
			//Collecting : collector타입의 인자를받아서 처리, Collectors 객체에서 제공
				//예제
		List<Product> productList2 = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
		
			//Collectors.toList() : 스트림 작업결과를 리스트로 반환
		List<String> collec = productList2.stream().map(Product::getName).collect(Collectors.toList());
		Stream<Integer> collec1 = productList2.stream().map(Product::getAmount);
		
			//Collectors.joining() : 작업결과를 하나의 문자열로 반환. 세개의 인자를 반환
				//1.delimiter : 각요소 중간에 들어가 요소를 구분시켜주는 구분자
				//2.prefix: 결과 맨앞에 붙는 문자
				//3.suffix: 결과 맨뒤에 붙는 문자
		String listTS = productList2.stream().map(Product::getName).collect(Collectors.joining(",", "<", ">"));
//		Map TS1 = productList2.stream().map(Product::getName)
//		System.out.println(TS1.keySet());
		
			//Collectors.averageInt() : 숫자값의 평균 반환
		Double aver = productList2.stream().collect(Collectors.averagingInt(Product::getAmount));
			
			//Collectors.summingInt() : 숫자의합
		int colecSum = productList2.stream().collect(Collectors.summingInt(Product::getAmount));
		int colecSum2 = productList2.stream().mapToInt(Product::getAmount).sum();
			
			
			//Collectors.summarizingInt() : 합계와 평균 모두
		IntSummaryStatistics statistics = productList2.stream().collect(Collectors.summarizingInt(Product::getAmount));
				//{count=5, sum=86, min=13, average=17.200000, max=23} 이런식으로 정보가 담김
				//각 요소는 .get~~()로 불러올수 있음
				
			//Collectors.groupBy() : 특정조건으로 요소를 그룹지음. 받는 인자는 함수형 인터페이스 Function
				//맵타입이면 같은 수량은 리스트로 묶어서 보여줌
		Map<Integer, List<Product>> collMOL = productList2.stream().collect(Collectors.groupingBy(Product::getAmount));

			//Collectors.partitioningBy() : 함수형 인터페이스 Predicate를 받아 boolean값을 리턴
				//true false로 각각 리스트로 묶어서 보여줌
		Map<Boolean, List<Product>> collPB = productList2.stream().collect(Collectors.partitioningBy(num -> num.getAmount() > 15));
		
			//Collectors.collectingAndThen() : 결과를 collect한 이후에 추가작업에 필요함 전자 실행후 후자 실행
		Set<Product> unmodiSet = productList2.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		
			//Collector.of() : 필요한 로직이 있으면 직접 만듬
		Collector<Product, ?, LinkedList<Product>> toLinkedList = 
 			 Collector.of(LinkedList::new, 
               			  LinkedList::add, 
               			  (first, second) -> {first.addAll(second);return first;});
		LinkedList<Product> linkedPersons = productList2.stream().collect(toLinkedList);

		//Matching : 람다 predicate를받아 조건을 만족하는 요소 있는지 체크후 결과 리턴. 3가지 메소드가 있음
		List<String> names2 = Arrays.asList("Eric", "Elena", "Java");
			//1. 하나의 조건을 만족하는 요소가 있는지 anyMatch()
		boolean anyMatch = names2.stream().anyMatch(name -> name.contains("a"));
			//2. 모든조건읆 만족하는지			 allMatch()
		boolean allMatch = names2.stream().allMatch(name -> name.length()>3);
			//3. 모든조건읆 만족하지 않는지         noneMatch()
		boolean noneMatch = names2.stream().noneMatch(name -> name.endsWith("s"));
	
		
		//Iterating : foreach는 보통 최종작업 sysout 메소드를 넘겨 결과를 출력할떄 사용. peek은 중간작업이라는 차이
		names.stream().forEach(System.out::println);
		
	}
}



























