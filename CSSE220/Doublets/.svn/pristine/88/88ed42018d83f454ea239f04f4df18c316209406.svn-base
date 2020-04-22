import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <<Eric and Bill>>
 */
public class Doublets {
	private LinksInterface links;

	public Doublets(LinksInterface links) {
		this.links = links;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Doublets, a game of 'verbal torture.'");
		
		String [] commands = new String[3];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Doublets doublet = new Doublets(new Links("../DoubletsData/english.cleaned.all.35.txt"));
		while (true) {
			System.out.println("Enter starting word: ");
			String commandLine = scanner.nextLine();
			System.out.println("Enter ending word: ");
			String commandLine1 = scanner.nextLine();
			System.out.println("Enter chain manager((s: stack, q: queue, p: priorityQueue x: exit))");
			String commandLine2 = scanner.nextLine();
			
			commands[0] = commandLine;
			commands[1] = commandLine1;
			commands[2] = commandLine2;
			ChainManager manager = new StackChainManager();
			Chain c = new Chain();
			if(commands[2].equals("s")){
				c = doublet.findChain(commands[0],commands[1], manager);
				Set<String> output = new HashSet<>();
				
			}else if(commands[2].equals("q")){
				manager = new QueueChainManager();
				c = doublet.findChain(commands[0],commands[1], manager);
				Set<String> output = new HashSet<>();
				
			}else if(commands[2].equals("p")){
				manager = new PriorityQueueChainManager(commands[1]);
				c = doublet.findChain(commands[0],commands[1], manager);
				Set<String> output = new HashSet<>();
				
			}else if(commands[2].equals("x")){
				scanner.close();
				System.exit(0);
				
			}
			System.out.println(c.toString());
			
			System.out.println("Length: "+c.length());
			System.out.println("Candidates: " + manager.getNumberOfNexts());
			System.out.println("Maxsize: "+ manager.maxSize());
		}
	}
	
	

	public Chain findChain(String start, String end, ChainManager manager) {
		if (start.length() != end.length())
			return null;

		Chain chain = new Chain();
		chain = chain.addLast(start);
		manager.add(chain);
		while (!manager.isEmpty()) {
			Chain c = manager.next();
			if (c.getLast().equals(end)) {
				return c;
			}
			Set<String> set = this.links.getCandidates(c.getLast());
			if (set != null) {
				for (String a : set) {
					if (!c.contains(a)) {
						Chain temp = c.addLast(a);
						manager.add(temp);
					}
				}
			}
		}
		return null;
	}


}
