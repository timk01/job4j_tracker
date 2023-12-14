package ru.job4j.function.training;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class GeneratorEngine {
    public static void main(String[] args) {
        SimpleGen simpleGen = new SimpleGen(5);
        Generator nonStaticGen = simpleGen::getNumber;
        System.out.println(nonStaticGen.getNextElement());

        Generator staticGen = SimpleGen::getRandomNumber;
        System.out.println(staticGen.getNextElement());

        Generator2 generator2 = IntGenerator::next;
        IntGenerator intGenerator = new IntGenerator();
        System.out.println(intGenerator.next());

        ObjectGenerator objectGenerator = ArrayList::new;
        Object newObject = objectGenerator.createNewObject();
        System.out.println(newObject.getClass());

        Supplier<HashMap<Integer, String>> runnable = HashMap::new;
        HashMap<Integer, String> hashMap = runnable.get();
        hashMap.put(1, "123");
        System.out.println(hashMap.get(1));

        ArraysGenerator arraysGenerator = int[]::new;
        Object newObject1 = arraysGenerator.createNewObject(10);
        System.out.println(newObject1.getClass());
    }
}
