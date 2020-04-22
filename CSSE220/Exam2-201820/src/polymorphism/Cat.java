package polymorphism;

public class Cat extends Pets {
	private String name;
	private boolean isEating;

	public Cat(String name) {
		this.name = name;
		this.isEating = false;
	}
	
	@Override
	public void eatFood() {
		System.out.println("Cat " + name + " is eating food.");
		this.isEating = true;
	}
	

	@Override
	public void doSpecialAbility() {
		System.out.println(this.name + " says: Yawn. Zzz...");
	}
}
