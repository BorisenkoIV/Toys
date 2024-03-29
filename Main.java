
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String [] args) {
        
// Принимает три строки, содержащие три поля: id игрушки, название и частоту выпадения игрушки:
    class Toy {
    	private String id;
    	private String name;
    	private int frequency;
    
    	public Toy (String id, String name, int frequency) {
    		this.id = id;
    		this.name = name;
    		this.frequency = frequency;
    	}
    	public String getId() {
    		return id;
    	}
    	public String getName() { 
    		return name;
    	}
    	public int getFrequency() {
    		return frequency;
    	}
    }
    // Заполняем три массива:
    List<Toy> toys = new ArrayList<>();
    String[] ids = new String[3];
    String[] names = new String[3];
    int[] weights = new int[3];
    
    toys.add(new Toy("id1",	"Машинка", 5));
    toys.add(new Toy("id2",	"Кукла", 3));
    toys.add(new Toy("id3",	"Пирамидка", 6));
    toys.add(new Toy("id4",	"Паровоз", 2));
    toys.add(new Toy("id5",	"Мельница", 7));

    for (int i = 0; i < 3; i++) {
    	Toy toy = toys.get(i);
    	ids[i] = toy.getId();
    	names[i] = toy.getName();
    	weights[i] = toy.getFrequency();
    }
    //Создаем список игрушек 'toys', далее заполняем его тремя элементами и далее перебираем каждую игрушку:
    PriorityQueue<Toy> queue = new PriorityQueue<>(Comparator.comparingInt(Toy::getFrequency));
    for (Toy toy : toys){
        queue.add(toy);
    }
    
    try (PrintWriter writer = new PrintWriter(new File("output.txt"))){
    	for (int i = 0; i < 10; i++) {
    		Toy toy = queue.poll();
    		writer.println(toy.getId() + " " + toy.getName() + " " + toy.getFrequency());
    		queue.offer(toy);
    	}
    }
    catch (FileNotFoundException e) {
    	e.printStackTrace();
    }
  }
}
