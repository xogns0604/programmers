package Study;
//https://mangkyu.tistory.com/113
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
interface MyLamdaFunction{
	int max(int a, int b);
}


@FunctionalInterface
interface Supplier<T> {
	T get();
}

@FunctionalInterface
interface Comsumer<T> {
	void accept(T t);
	
	default Consumer<T> andThen(Consumer<? super T> after){
		Objects.requireNonNull(after);
		return (T t) -> {accept(t); after.accept(t);};
	}
}

@FunctionalInterface
interface Function<T, R>{
	R apply(T t);
	
	default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
		Objects.requireNonNull(before);
		return (V v) -> apply(before.apply(v));
	}
	
	default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) { 
		Objects.requireNonNull(after); 
		return (T t) -> after.apply(apply(t)); 
	}

	static <T> Function<T, T> identity(){
		return t -> t;
	}
}

@FunctionalInterface
interface Predicate<T> {
	boolean test(T t);
	
	default Predicate<T> and(Predicate<? super T> other) { 
		Objects.requireNonNull(other); 
		return (t) -> test(t) && other.test(t); 
	} 
	
	default Predicate<T> negate() {
		return (t) -> !test(t); 
	} 
	
	default Predicate<T> or(Predicate<? super T> other) { 
		Objects.requireNonNull(other); 
		return (t) -> test(t) || other.test(t); 
	} 
	
	static <T> Predicate<T> isEqual(Object targetRef) { 
		return (null == targetRef) 
				? Objects::isNull 
				: object -> targetRef.equals(object); 
	}
}

public class lamdaStudy {

	//�Լ��� �������̽� andthen(), compose() �� ����
	public static void method1() {
		Function<Integer, String> integerToString = (number) -> Integer.toString(number);
		System.out.println(integerToString.apply(10));
		
		//-----
        Function<Integer, Integer> plusTen = (number) -> number + 10;
        Function<Integer, String> compose = integerToString.compose(plusTen); // plusTen ���� ������ ������� integerToString���� ���
        
        System.out.println(compose.apply(10));
        
        //------
        
        Function<String, Integer> stringToInteger = (string) -> Integer.parseInt(string);
        Function<Integer, Integer> integerIntegerFunction = integerToString.andThen(stringToInteger); // integerToString���� ���� �� ��� ���� stringToInteger���� ���
        
        System.out.println(integerIntegerFunction.apply(10));
	}
	
	public static void main(String[] args) {
		
		//�͸��Լ�
		System.out.println(new lamdaStudy() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		}.max(3, 5));
		
		//�����Լ�
		MyLamdaFunction lamdaF = (int a, int b) -> a > b ? a : b;
		System.out.println(lamdaF.max(3, 5));
		
		//��ȯ���� ������ �Լ��� �������̽�
		Supplier<String> supplier = () -> "Hello world!";
		System.out.println(supplier.get());
		
		//��üT�� �Ű������� �޾Ƽ� ��ȯ���� ���� �Լ��� �������̽�
		Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
		consumer.andThen(System.out::println).accept("Hello World");
		
		//��ü T�� �Ű������� �޾Ƽ� ó���� �� R�� ��ȯ�ϴ� �Լ��� �������̽�
		Function<String, Integer> function = str -> str.length();
		System.out.println(function.apply("Hello World"));
		
		//��ü T�� �Ű� ������ �޾� ó���� �� Boolean�� ��ȯ
		Predicate<String> predicate = (str) -> str.equals("Hello World");
		System.out.println(predicate.test("Hello World"));
		
		//�޼ҵ�����
		Function<String, Integer> function2 = String::length;
		System.out.println(function2.apply("Hello World"));
		
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("Hello World!!");
		
		List<String> list = Arrays.asList("red", "orange", "yellow", "green", "blue");
		list.forEach(System.out::println);
		
	
		Predicate<Boolean> predicate2 = Objects::isNull;
		
		Supplier<String> supplier2 = String::new;
		System.out.println(supplier2.get());
	}

}
