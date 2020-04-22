package polymorphism;

public class Fish extends Pets {
	private String name;
	private boolean isEating;
	private int numWiggles;

	public Fish(String name, int numWiggles) {
		this.name = name;
		this.isEating = false;
		this.numWiggles = numWiggles;
	}
	
	@Override
	public void eatFood() {
		System.out.println("Fish " + name + " is eating food.");
		this.isEating = true;
	}
	
	@Override
	public void doSpecialAbility() {
		System.out.println(this.name + " says, time to move!");
		for (int j = 1; j <= this.numWiggles; j++) {
			System.out.println("Wiggle " + j);
		}
	}
}
