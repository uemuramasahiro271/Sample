package anonymous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import common.ISample;

public class AnonymousSample implements ISample {

	public void execute() {

		// 匿名クラス
		Anonymous anonymous1 = new Anonymous() {

			@Override
			public void run() {
				System.out.println("anonymous1 : run()実行");

			}
		};

		anonymous1.run();

		// ラムダ式
		Anonymous anonymous2 = () -> {
			System.out.println("anonymous2 : run()実行");
		};

		anonymous2.run();

		executeConsumerType();
		executeFunctionType();
		executePredicateType();
		executeSupplierType();

	}

	// Consumer型
	// void accept(T t);
	// T型引数を受け取る
	private void executeConsumerType() {
		List<String> list = List.of("a", "b", "c");

		// (1)
		list.forEach(new Consumer<String>() {
		    @Override
		    public void accept(String t) {
		        System.out.println(t);
		    }
		});

		// (2)
		list.forEach(s -> {
		    System.out.println(s);
		});

		// (3)
		list.forEach(s -> System.out.println(s));

		// (4) メソッド参照
		list.forEach(System.out::println);
	}

	// Function型
	// R apply(T t);
	// T型引数を受け取り、R型の戻り値を返す
	private void executeFunctionType() {
		Map<String, Integer> map = new HashMap<>();

		// (1)
		Integer value = map.computeIfAbsent("apple", new Function<String, Integer>(){
		    @Override
		    public Integer apply(String t) {
		        return t.length();
		    }
		});

		// (2)
		value = map.computeIfAbsent("banana", s -> {
		    return s.length();
		});

		// (3)
		value = map.computeIfAbsent("cherry", s -> s.length());

		// (4) インスタンスのメソッド参照
		value = map.computeIfAbsent("durian", String::length);
	}

	// Predicate型
	// boolean test(T t);
	// T型引数を受け取り、booleanの戻り値を返す
	private void executePredicateType() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		// (1)
		list.removeIf(new Predicate<Integer>() {
		    @Override
		    public boolean test(Integer t) {
		        return t % 2 == 0;
		    }
		});

		// (2)
		list.removeIf(t -> {
		    return t % 2 == 0;
		});

		// (3)
		list.removeIf(t -> t % 2 == 0);
	}

	// Supplier型
	// T get();
	// T型の戻り値を返す
	private void executeSupplierType() {
		Optional<String> fruit = Optional.ofNullable(null);

		// (1)
		String result = fruit.orElseThrow(new Supplier<RuntimeException>() {
		    @Override
		    public RuntimeException get() {
		        return new FruitNotFoundException();
		    }
		});

		// (2)
		result = fruit.orElseThrow(() -> {
		    return new FruitNotFoundException();
		});

		// (3)
		result = fruit.orElseThrow(() -> new FruitNotFoundException());

		// (4) コンストラクタ参照
		result = fruit.orElseThrow(FruitNotFoundException::new);
	}

	class FruitNotFoundException extends RuntimeException {
	    public FruitNotFoundException() {
	        super();
	    }
	}
}
